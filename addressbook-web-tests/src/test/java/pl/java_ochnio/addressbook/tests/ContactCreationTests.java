package pl.java_ochnio.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import pl.java_ochnio.addressbook.model.ContactData;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() throws Exception {
        Set<ContactData> before = app.contact().all();
        ContactData contact = new ContactData().withFirstname("firstname").withLastname("lastname").withGroup("test1");
        app.contact().create(contact, true);
        Set<ContactData> after = app.contact().all();
        Assert.assertEquals(after.size(), before.size() + 1);

        contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt());
        before.add(contact);
        Assert.assertEquals(before, after);
    }
}
