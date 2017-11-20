package webapp157A;

import com.mysql.jdbc.TimeUtil;

import java.sql.Timestamp;
import java.util.Date;

public class ContactInfo {

    private String contactId;

    private String firstName;
    private String middleName;
    private String lastName;

    private String phoneNumber;
    private String emailAddress;
    private String emailAddress2;

    private String street;
    private String city;
    private String state;
    private String zipCode;

    // Getters and setters:

    public void setContactId(String contactId) { this.contactId = contactId; }
    public String getContactId() { return contactId; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getMiddleName() { return middleName; }
    public void setMiddleName(String middleName) { this.middleName = middleName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getEmailAddress() { return emailAddress; }
    public void setEmailAddress(String emailAddress) { this.emailAddress = emailAddress; }

    public String getEmailAddress2() { return emailAddress2; }
    public void setEmailAddress2(String emailAddress2) { this.emailAddress2 = emailAddress2; }

    public String getStreet() { return street; }
    public void setStreet(String street) { this.street = street; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getState() { return state; }
    public void setState(String state) { this.state = state; }

    public String getZipCode() { return zipCode; }
    public void setZipCode(String zipCode) { this.zipCode = zipCode; }
}
