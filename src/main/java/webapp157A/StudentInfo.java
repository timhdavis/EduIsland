package webapp157A;

import com.mysql.jdbc.TimeUtil;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class StudentInfo {

    private String userId;
    private String enrollmentStatus;


    // Getters and setters:

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getEnrollmentStatus() { return enrollmentStatus; }
    public void setEnrollmentStatus(String enrollmentStatus) { this.enrollmentStatus = enrollmentStatus; }

}
