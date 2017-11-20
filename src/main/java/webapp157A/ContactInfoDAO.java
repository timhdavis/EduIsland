package webapp157A;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ContactInfoDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    DataSource dataSource;

    public static final String ADD_CONTACT_INFO = "insert into ContactInfo values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String GET_CONTACT_INFO = "select * from ContactInfo where contact_id = ?";

    public static final String GET_USER_CONTACT_INFO = "select * from ContactInfo ci where ci.contact_id = (select contact_id from HasContactInfo where user_id = ?);";

    public static final String CONNECT_USER_AND_CONTACT_INFO = "insert into HasContactInfo values(?, ?)";

    public void addContactInfoToUser(String userId, ContactInfo contactInfo) {

        contactInfo.setContactId(generateUserContactId(userId));

        jdbcTemplate.update(CONNECT_USER_AND_CONTACT_INFO, new Object[] {userId, contactInfo.getContactId()});

        jdbcTemplate.update(ADD_CONTACT_INFO, new Object[] {contactInfo.getContactId(),
                contactInfo.getFirstName(), contactInfo.getMiddleName(), contactInfo.getLastName(),
                contactInfo.getPhoneNumber(), contactInfo.getEmailAddress(), contactInfo.getEmailAddress2(),
                contactInfo.getStreet(), contactInfo.getCity(), contactInfo.getState(), contactInfo.getZipCode()});
    }

    public void addContactInfo(ContactInfo contactInfo) {
        jdbcTemplate.update(ADD_CONTACT_INFO, new Object[] {contactInfo.getContactId(),
                contactInfo.getFirstName(), contactInfo.getMiddleName(), contactInfo.getLastName(),
                contactInfo.getPhoneNumber(), contactInfo.getEmailAddress(), contactInfo.getEmailAddress2(),
                contactInfo.getStreet(), contactInfo.getCity(), contactInfo.getState(), contactInfo.getZipCode()});
    }

    public ContactInfo getContactInfo(ContactInfo contactInfo) {
        List<ContactInfo> contacts = jdbcTemplate.query(GET_CONTACT_INFO, new Object[]{contactInfo.getContactId()}, new ContactInfoMapper());

        return contacts.size() > 0 ? contacts.get(0) : null; // this checks if users size > greater than 0, then return the first contactInfo else return null
    }

    public ContactInfo getContactInfo(String contactId) {
        List<ContactInfo> contacts = jdbcTemplate.query(GET_CONTACT_INFO, new Object[]{contactId}, new ContactInfoMapper());

        return contacts.size() > 0 ? contacts.get(0) : null; // this checks if users size > greater than 0, then return the first contactInfo else return null
    }

    public ContactInfo getUserContactInfo(String userId) {
        List<ContactInfo> contacts = jdbcTemplate.query(GET_USER_CONTACT_INFO, new Object[]{userId}, new ContactInfoMapper());

        return contacts.size() > 0 ? contacts.get(0) : null; // this checks if users size > greater than 0, then return the first contactInfo else return null
    }

    public class ContactInfoMapper implements RowMapper {
        public ContactInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
            ContactInfo contactInfo = new ContactInfo();

            contactInfo.setContactId(rs.getString("contact_id"));

            contactInfo.setFirstName(rs.getString("first_name"));
            contactInfo.setMiddleName(rs.getString("middle_name"));
            contactInfo.setLastName(rs.getString("last_name"));

            contactInfo.setPhoneNumber(rs.getString("phone_number"));
            contactInfo.setEmailAddress(rs.getString("email_address"));
            contactInfo.setEmailAddress2(rs.getString("email_address_2"));

            contactInfo.setStreet(rs.getString("street"));
            contactInfo.setCity(rs.getString("city"));
            contactInfo.setState(rs.getString("state"));
            contactInfo.setZipCode(rs.getString("zip_code"));

            return contactInfo;
        }
    }

    // Private methods:

    private String generateUserContactId(String userId)
    {
        return userId + "-c";
    }
}
