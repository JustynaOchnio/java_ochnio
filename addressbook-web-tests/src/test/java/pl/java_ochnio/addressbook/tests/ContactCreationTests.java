package pl.java_ochnio.addressbook.tests;

import org.testng.annotations.*;
import pl.java_ochnio.addressbook.model.ContactData;
import pl.java_ochnio.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() throws Exception {
        Contacts before = app.contact().all();
        ContactData contact = new ContactData().withFirstname("firstname").withLastname("lastname").withGroup("test1");
        app.contact().create(contact, true);
        Contacts after = app.contact().all();
        assertThat(after.size(), equalTo(before.size() +1));
        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
    }
}
