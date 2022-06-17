package pl.java_ochnio.addressbook.tests;

import org.testng.annotations.*;

import pl.java_ochnio.addressbook.model.GroupDataBirthday;
import pl.java_ochnio.addressbook.model.GroupDataContacts;

public class ContactCreationTests extends TestBase{

    @Test
    public void testContactCreation() throws Exception {
        app.openNewContactPage();
        app.fillContactForm(new GroupDataContacts("Justyna", "Ochnio", "test1", "test2", "test3", "888555", "test@test"));
        app.fillBirthdayDate(new GroupDataBirthday("10", "January", "1980"));
        app.selectGroup();
        app.submitContactCreation();
        app.returnToHomePage();

    }

}
