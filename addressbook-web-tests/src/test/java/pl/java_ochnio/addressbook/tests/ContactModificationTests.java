package pl.java_ochnio.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.java_ochnio.addressbook.model.ContactData;

import java.util.List;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() {
        app.getNavigationHelper().goToHomePage();
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData
                    ("test1", null, null, null, null, null, "test1"), true);
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContact(before.size() -2);
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(new ContactData
                ("test1", "test2", "test3", "test4", "4325435", "test@test", "test1"), false);
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToContactPage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());
    }
}

