package pl.java_ochnio.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.java_ochnio.addressbook.model.ContactData;
import pl.java_ochnio.addressbook.model.GroupData;

public class ContactDeletionTests extends TestBase {

    @Test
    public void testContactDeletion() {
        app.getNavigationHelper().goToHomePage();
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData
                    ("test1", null, null, null, null, null, "test1"), true);
        }
        int before = app.getContactHelper().getContactCount();
        app.getContactHelper().selectContact(before -1);
        app.getContactHelper().deleteContact();
        app.getContactHelper().confirmDeletion();
        app.getContactHelper().returnToContactPage();
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after, before - 1);
    }
}
