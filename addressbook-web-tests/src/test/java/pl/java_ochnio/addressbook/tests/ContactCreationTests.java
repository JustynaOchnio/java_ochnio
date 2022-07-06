package pl.java_ochnio.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;

import pl.java_ochnio.addressbook.model.ContactData;

import java.util.List;

public class ContactCreationTests extends TestBase{

    @Test
    public void testContactCreation() throws Exception {
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().createContact(new ContactData("test 1", null, null, null, null, null, "test1"), true);
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() + 1);
    }

}
