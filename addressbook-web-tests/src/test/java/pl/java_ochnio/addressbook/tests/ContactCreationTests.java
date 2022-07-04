package pl.java_ochnio.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;

import pl.java_ochnio.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase{

    @Test
    public void testContactCreation() throws Exception {
        int before = app.getContactHelper().getContactCount();
        app.getContactHelper().createContact(new ContactData("test 1", null, null, null, null, null, "test1"), true);
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after, before + 1);
    }

}
