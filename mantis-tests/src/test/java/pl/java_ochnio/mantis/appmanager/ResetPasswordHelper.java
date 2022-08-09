package pl.java_ochnio.mantis.appmanager;

import org.openqa.selenium.By;
import pl.java_ochnio.mantis.model.UserData;

public class ResetPasswordHelper extends HelperBase {

    public ResetPasswordHelper(ApplicationManager app) {
        super(app);
    }

    public void login(String username, String password) {
        wd.get(app.getProperty("web.baseUrl") + "/login_page.php");
        type(By.name("username"), username);
        type(By.name("password"), password);
        click(By.cssSelector("input[value='Login']"));
    }

    public void manageUsers(int id) {
        wd.findElement(By.linkText("Manage")).click();
        wd.findElement(By.linkText("Manage Users")).click();
        wd.findElement(By.cssSelector(String.format("a[href='manage_user_edit_page.php?user_id=%s']", id))).click();
        wd.findElement(By.xpath("//input[@value='Reset Password']")).click();
    }

    public void finish(String confirmationLink, String password) {
        wd.get(confirmationLink);
        type(By.name("password"), password);
        type(By.name("password_confirm"), password);
        click(By.cssSelector("input[value='Update User']"));
    }
}
