package pl.java_ochnio.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pl.java_ochnio.addressbook.model.ContactData;

public class ContactHelper extends HelperBase {
    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void returnToHomePage() {
        click(By.linkText("home"));
    }

    public void submitContactCreation() {
        click(By.xpath("//div[@id='content']/form/select[5]/option[2]"));
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void fillContactForm(ContactData contactData, boolean creation) {
        type(By.name("firstname"), contactData.getFirstname());
        type(By.name("lastname"), contactData.getLastname());
        type(By.name("title"), contactData.getTitle());
        type(By.name("company"), contactData.getCompany());
        type(By.name("address"), contactData.getAddress());
        type(By.name("mobile"), contactData.getPhone());
        type(By.name("email"), contactData.getEmail());

        new Select(wd.findElement(By.name("bday"))).selectByVisibleText(contactData.getDay());
        new Select(wd.findElement(By.name("bmonth"))).selectByVisibleText(contactData.getMonth());
        type(By.name("byear"), contactData.getYear());

        if (creation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }

    }

    public void openNewContactPage() {
        click(By.linkText("add new"));
    }

    public void initContactModification() {
        click(By.xpath("//table[@id='maintable']/tbody/tr[7]/td[8]/a/img"));
    }

    public void submitContactModification() {
        click(By.xpath("//div[@id='content']/form/input[22]"));
    }

    public void selectContact() {
        click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td"));

    }

    public void deleteContact() {
        click(By.xpath("//input[@value='Delete']"));
    }


    public void confirmDeletion() {
        wd.switchTo().alert().accept();
    }


}
