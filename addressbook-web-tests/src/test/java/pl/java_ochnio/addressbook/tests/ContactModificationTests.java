package pl.java_ochnio.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.java_ochnio.addressbook.model.ContactData;

import java.util.HashSet;
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
        app.getContactHelper().selectContact(before.size() -1);
        app.getContactHelper().initContactModification();
        ContactData contact = new ContactData(before.get(before.size() -1).getId(),"firstname", "lastname", "test3", "test4", "4325435", "test@test", "test1");
        app.getContactHelper().fillContactForm((contact), false);
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToContactPage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size() -1);
        before.add(contact);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));


    }
}

