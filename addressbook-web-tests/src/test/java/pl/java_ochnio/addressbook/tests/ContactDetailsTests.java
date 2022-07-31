package pl.java_ochnio.addressbook.tests;

import org.testng.annotations.Test;
import pl.java_ochnio.addressbook.model.ContactData;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDetailsTests extends TestBase {
    @Test
    public void testContactDetails() {
        app.goTo().homePage();
        if (app.contact().all().size() == 0) {
            app.contact().create(new ContactData().withFirstname("test1").withLastname("test2").withAddress("test address")
                    .withEmail("email1").withEmail2("email2").withEmail3("email3")
                    .withHomePhone("10").withMobilePhone("20").withWorkPhone("30"), true);
        }
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromDetails = app.contact().infoFromDetails(contact);

        assertThat(mergeNames(contact), equalTo(contactInfoFromDetails.getFirstnameLastname()));
        assertThat(contact.getAddress(), equalTo(contactInfoFromDetails.getAddress()));
        assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromDetails)));
        assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactInfoFromDetails)));
    }

    private String mergeNames(ContactData contact) {
        return Arrays.asList(contact.getFirstname(), contact.getLastname())
                .stream().collect(Collectors.joining(" "));
    }

    private String mergePhones(ContactData contact) {
        return Arrays.asList(contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone())
                .stream().filter((s) -> !s.equals(""))
                .map(ContactDetailsTests::clean)
                .collect(Collectors.joining("\n"));
    }

    private String mergeEmails(ContactData contact) {
        return Arrays.asList(contact.getEmail(), contact.getEmail2(), contact.getEmail3())
                .stream().filter((s) -> !s.equals(""))
                .map(ContactDetailsTests::clean)
                .collect(Collectors.joining("\n"));
    }

    public static String clean(String phone) {
        return phone.replaceAll("H: ", "").replaceAll("M: ", "")
                .replaceAll("W: ", "").replaceAll("\n", "");
    }

}
