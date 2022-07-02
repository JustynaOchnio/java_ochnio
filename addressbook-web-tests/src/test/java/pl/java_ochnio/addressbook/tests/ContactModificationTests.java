package pl.java_ochnio.addressbook.tests;

import org.testng.annotations.Test;
import pl.java_ochnio.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() {
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(new ContactData(
                "test1", "test", "test", "test", "test", "test",
                "test", null, "1", "January", "2000"), false);
        app.getContactHelper().submitContactModification();
        app.getNavigationHelper().goToHomePage();
    }
}

