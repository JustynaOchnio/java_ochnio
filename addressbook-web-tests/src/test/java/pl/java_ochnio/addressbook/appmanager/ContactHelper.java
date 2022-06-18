package pl.java_ochnio.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import pl.java_ochnio.addressbook.model.GroupDataBirthday;
import pl.java_ochnio.addressbook.model.GroupDataContacts;

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

    public void selectContactGroup() {
        click(By.name("new_group"));
        new Select(wd.findElement(By.name("new_group"))).selectByVisibleText("test1");
    }

    public void fillBirthdayDate(GroupDataBirthday groupDataBirthday) {
        click(By.name("bday"));
        new Select(wd.findElement(By.name("bday"))).selectByVisibleText(groupDataBirthday.day());
        click(By.xpath("//option[@value='1']"));
        click(By.name("bmonth"));
        new Select(wd.findElement(By.name("bmonth"))).selectByVisibleText(groupDataBirthday.month());
        click(By.xpath("//option[@value='January']"));
        type(By.name("byear"), groupDataBirthday.year());
    }

    public void fillContactForm(GroupDataContacts groupDataContacts) {
        type(By.name("firstname"), groupDataContacts.firstname());
        type(By.name("lastname"), groupDataContacts.lastname());
        type(By.name("title"), groupDataContacts.title());
        type(By.name("company"), groupDataContacts.company());
        type(By.name("address"), groupDataContacts.address());
        type(By.name("mobile"), groupDataContacts.phone());
        type(By.name("email"), groupDataContacts.email());
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
