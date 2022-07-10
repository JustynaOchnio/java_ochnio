package pl.java_ochnio.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import pl.java_ochnio.addressbook.model.ContactData;
import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() throws Exception {
        List<ContactData> before = app.getContactHelper().getContactList();
        ContactData contact = new ContactData("firstname", "lastname", "test3", "test4", "4325435", "test@test", "test1");
        app.getContactHelper().createContact(contact, true);
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() + 1);

        before.add(contact);
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }

}
