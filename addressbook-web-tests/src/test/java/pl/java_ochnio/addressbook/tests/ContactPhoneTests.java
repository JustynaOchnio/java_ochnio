package pl.java_ochnio.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.java_ochnio.addressbook.model.ContactData;

public class ContactPhoneTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        if (app.contact().all().size() == 0) {
            app.contact().create(new ContactData().withFirstname("test1").withGroup("test2"), true);
        }
    }

    @Test
    public void testContactPhones () {
        app.goTo().homePage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    }
}
