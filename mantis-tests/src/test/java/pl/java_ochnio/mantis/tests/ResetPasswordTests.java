package pl.java_ochnio.mantis.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.java_ochnio.mantis.model.MailMessage;
import pl.java_ochnio.mantis.model.UserData;
import pl.java_ochnio.mantis.model.Users;
import ru.lanwen.verbalregex.VerbalExpression;

import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class ResetPasswordTests extends TestBase {
    @BeforeMethod
    public void startMailServer() {
        app.mail().start();
    }

    @Test
    public void testResetPassword() throws IOException {
        app.resetPassword().login("administrator", "root");
        Users users = app.db().users();
        UserData modifiedUser = users.iterator().next();
        UserData user = new UserData().withId(modifiedUser.getId());
        app.resetPassword().manageUsers(user.getId());
        List<MailMessage> mailMessages = app.mail().waitForMail(1, 20000);
        String email = modifiedUser.getEmail();
        String password = "password";
        String username = modifiedUser.getUsername();
        String confirmationLink = findConfirmationLink(mailMessages, email);
        app.resetPassword().finish(confirmationLink, password);
        assertTrue(app.newSession().login(username, password));
    }

    private String findConfirmationLink(List<MailMessage> mailMessages, String email) {
        MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findAny().get();
        VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
        return regex.getText(mailMessage.text);
    }


    @AfterMethod(alwaysRun = true)
    public void stopMailServer() {
        app.mail().stop();
    }
}
