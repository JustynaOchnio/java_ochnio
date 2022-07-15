package pl.java_ochnio.addressbook.tests;


import org.testng.annotations.Test;
import pl.java_ochnio.addressbook.model.ContactData;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTests extends TestBase {


    @Test
    public void testContactPhones() {
        app.goTo().homePage();
        if (app.contact().all().size() == 0) {
            app.contact().create(new ContactData().withFirstname("test1").withLastname("test2")
                    .withHomePhone("10").withMobilePhone("20").withWorkPhone("30").
                    withGroup("test1"), true);
        }
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
        assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));

    }
    private String mergePhones(ContactData contact) {
        return Arrays.asList(contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone())
                .stream().filter((s) -> !s.equals(""))
                .map(ContactPhoneTests::cleaned)
                .collect(Collectors.joining("\n"));
    }

    public static String cleaned(String phone) {
        return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
    }
}
