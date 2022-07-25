package pl.java_ochnio.addressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pl.java_ochnio.addressbook.appmanager.ApplicationManager;

import javax.sql.rowset.BaseRowSet;
import java.io.IOException;

public class TestBase {

    protected static final ApplicationManager app;

    static {
        try {
            app = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @BeforeSuite
    public void setUp() throws Exception {
        app.init();
    }

    @AfterSuite
    public void tearDown() throws Exception {
        app.stop();
    }

}
