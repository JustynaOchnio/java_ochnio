package pl.java_ochnio.addressbook.tests;

import org.testng.annotations.*;

import pl.java_ochnio.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase{

    @Test
    public void testContactCreation() throws Exception {
        app.getContactHelper().openNewContactPage();
        app.getContactHelper().fillContactForm(new ContactData(
                "test1", null, null, null, null, null, null,
                "test1", "1", "January", "2000"), true);
        app.getContactHelper().submitContactCreation();
        app.getNavigationHelper().goToHomePage();

    }

}
