package pl.java_ochnio.addressbook.tests;

import org.testng.annotations.*;

import pl.java_ochnio.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase{

    @Test
    public void testContactCreation() throws Exception {
        app.getContactHelper().createContact(new ContactData("test 1", null, null, null, null, null, "test1"), true);
        app.getSessionHelper().logout();
    }

}
