package pl.java_ochnio.mantis.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.java_ochnio.mantis.appmanager.HttpSession;
import pl.java_ochnio.mantis.model.UserData;
import pl.java_ochnio.mantis.model.Users;

import java.io.IOException;

import static org.testng.Assert.assertTrue;

public class ResetPasswordTests extends TestBase {
    // @BeforeMethod
    //public void startMailServer() {
    //    app.mail().start();
    // }

    @Test
    public void testResetPassword() throws IOException {
        HttpSession session = app.newSession();
        session.login("administrator", "root");
        Users users = app.db().users();
        UserData modifiedUser = users.iterator().next();
        System.out.println(users);
        UserData user = new UserData().withId(modifiedUser.getId());
        app.resetPassword().manageUsers(user.getId());


    }


    //  @AfterMethod(alwaysRun = true)
    // public void stopMailServer() {
    //    app.mail().stop();
    // }
}
