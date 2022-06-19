package pl.java_ochnio.addressbook.model;

public class ContactData {

    private final String firstname;
    private final String lastname;
    private final String title;
    private final String company;
    private final String address;
    private final String phone;
    private final String email;
    private final String group;
    private String day;
    private String month;
    private String year;

    public ContactData(String firstname, String lastname, String title, String company, String address,
                       String phone, String email, String group, String day, String month, String year) {

        this.firstname = firstname;
        this.lastname = lastname;
        this.title = title;
        this.company = company;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.group = group;
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getTitle() {
        return title;
    }

    public String getCompany() {
        return company;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getGroup() {
        return group;
    }

    public String getDay() {
        return day;
    }

    public String getMonth() {
        return month;
    }

    public String getYear() {
        return year;
    }
}
