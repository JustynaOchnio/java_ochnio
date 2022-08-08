package pl.java_ochnio.addressbook.tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.java_ochnio.addressbook.model.ContactData;
import pl.java_ochnio.addressbook.model.Contacts;
import pl.java_ochnio.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddContactToGroupTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().contacts().size() == 0) {
            app.goTo().homePage();
            app.contact().create(new ContactData().withFirstname("test1"), true);
        }
    }


    @Test(enabled = false)
    public void addContactToGroup() throws Exception {
        ContactData contact = new ContactData();
        Contacts contacts = app.db().contacts();
        Groups contactGroups = contact.getGroups();
        ContactData selectedContact = contacts.iterator().next();
        app.goTo().homePage();
        app.contact().addContactToGroup(selectedContact);
        Groups contactGroupsAfter = contact.getGroups();
        assertThat(contactGroupsAfter, equalTo(contactGroups));
    }
}
