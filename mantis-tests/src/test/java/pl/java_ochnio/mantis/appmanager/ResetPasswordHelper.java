package pl.java_ochnio.mantis.appmanager;

import org.openqa.selenium.By;
import pl.java_ochnio.mantis.model.UserData;

public class ResetPasswordHelper extends HelperBase {

    public ResetPasswordHelper(ApplicationManager app) {
        super(app);
    }

    public void manageUsers(int id) {
        wd.get(app.getProperty("web.baseUrl") + "/manage_user_page.php");
        wd.findElement(By.cssSelector(String.format("a[href='manage_user_edit_page.php?user_id=%s']", id))).click();
    }
}
