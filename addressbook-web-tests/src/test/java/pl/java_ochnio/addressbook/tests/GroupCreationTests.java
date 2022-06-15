package pl.java_ochnio.addressbook.tests;

import org.testng.annotations.*;
import org.openqa.selenium.*;
import pl.java_ochnio.addressbook.model.GroupData;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() throws Exception {
        app.gotoGroupPage();
        app.initGroupCreation();
        app.fillGroupForm(new GroupData("test1", "test2", "test3"));
        app.submitGroupCreation();
        app.returnToGroupPage();
        app.wd.findElement(By.linkText("Logout")).click();
    }

}
