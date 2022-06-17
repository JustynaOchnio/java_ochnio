package pl.java_ochnio.addressbook.tests;

import org.testng.annotations.*;
import pl.java_ochnio.addressbook.model.GroupData;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() throws Exception {
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm(new GroupData("test1", "test2", "test3"));
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().gotoGroupPage();
        app.getSessionHelper().logout();
    }

}
