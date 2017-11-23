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

    public String getContactId() { return contactId; }
    public void setContactId(String contactId) { this.contactId = contactId; }

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

    // Other methods:

    /*
        Replaces fields (except for userId) of this contact with fields in newContactInfo if
         the new fields are not empty strings.
     */
    public void update(ContactInfo newContactInfo)
    {
        // Note: "" is tested first to eliminate NullPointer errors where the new field is null:
        if (!"".equals(newContactInfo.firstName)) { setFirstName(newContactInfo.getFirstName()); }
        if (!"".equals(newContactInfo.middleName)) { setMiddleName(newContactInfo.getMiddleName()); }
        if (!"".equals(newContactInfo.lastName)) { setLastName(newContactInfo.getLastName()); }

        if (!"".equals(newContactInfo.phoneNumber)) { setPhoneNumber(newContactInfo.getPhoneNumber()); }
        if (!"".equals(newContactInfo.emailAddress)) { setEmailAddress(newContactInfo.getEmailAddress()); }
        if (!"".equals(newContactInfo.emailAddress2)) { setEmailAddress2(newContactInfo.getEmailAddress2()); }

        if (!"".equals(newContactInfo.street)) { setStreet(newContactInfo.getStreet()); }
        if (!"".equals(newContactInfo.city)) { setCity(newContactInfo.getCity()); }
        if (!"".equals(newContactInfo.state)) { setState(newContactInfo.getState()); }
        if (!"".equals(newContactInfo.zipCode)) { setZipCode(newContactInfo.getZipCode()); }
    }

    // General methods:

    @Override
    public String toString()
    {
        return "<contact> contact ID: " + this.contactId
                + " / first name: " + this.firstName + " / middle name: " + this.middleName + " / last name: " + this.lastName
                + " / phone: " + this.phoneNumber + " / email: " + this.emailAddress + " / email 2: " + this.emailAddress2
                + " / street: " + this.street + " / city: " + this.city + " / state: " + this.state + " / zip: " + this.zipCode
                + "</contact>";
    }
}
