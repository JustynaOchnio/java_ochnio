package pl.java_ochnio.addressbook.tests;

import org.testng.annotations.*;
import pl.java_ochnio.addressbook.model.ContactData;
import pl.java_ochnio.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() throws Exception {
        Contacts before = app.contact().all();
        File photo = new File("src/test/resources/stru.png");
        ContactData contact = new ContactData().withFirstname("firstname").withLastname("lastname")
                .withHomePhone("10").withMobilePhone("12").withWorkPhone("15").withPhoto(photo)
                .withGroup("test1");
        app.contact().create(contact, true);
        assertThat(app.contact().count(), equalTo(before.size() +1));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
    }

    @Test (enabled = false)
    public void testBadContactCreation() throws Exception {
        Contacts before = app.contact().all();
        ContactData contact = new ContactData().withFirstname("firstname'").withLastname("lastname'").withGroup("test1");
        app.contact().create(contact, true);
        assertThat(app.contact().count(), equalTo(before.size()));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(before));
    }

}
