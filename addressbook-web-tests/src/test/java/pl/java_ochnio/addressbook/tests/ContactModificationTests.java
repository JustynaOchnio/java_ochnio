package pl.java_ochnio.addressbook.tests;

import org.testng.annotations.Test;
import pl.java_ochnio.addressbook.model.GroupDataContacts;

public class ContactModificationTests extends TestBase{

    @Test
    public void testContactModification() {
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(new GroupDataContacts("test1", "test2", "test3", "test4", "test5", "test6"," test7" ));
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToHomePage();
    }
}

