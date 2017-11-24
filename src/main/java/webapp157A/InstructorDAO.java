package webapp157A;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class InstructorDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    DataSource dataSource;

    public static final String GET_INSTRUCTOR_WITH_USER_ID = "select * from Instructor where user_ID = ?;";

    public static final String UPDATE_INSTRUCTOR_INFO = "update Instructor set biography=?, photo=?, position=? where user_id=?;";

    public InstructorInfo getInstructorInfo(String userId) {
        List<InstructorInfo> instructorInfos = jdbcTemplate.query(GET_INSTRUCTOR_WITH_USER_ID, new Object[]{userId}, new InstructorMapper());

        return instructorInfos.size() > 0 ? instructorInfos.get(0) : null; // this checks if users size > greater than 0, then return the first instructor else return null
    }

    public void updateInstructorInfo(InstructorInfo instructorInfo) {
        jdbcTemplate.update(UPDATE_INSTRUCTOR_INFO, new Object[] {instructorInfo.getBiography(),
                instructorInfo.getPhoto(), instructorInfo.getPosition(),
                instructorInfo.getUserId()});
    }

    public class InstructorMapper implements RowMapper {
        public InstructorInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
            InstructorInfo instructorInfo = new InstructorInfo();
            instructorInfo.setUserId(rs.getString("user_id"));
            instructorInfo.setBiography(rs.getString("biography"));
            instructorInfo.setPhoto(rs.getString("photo"));
            instructorInfo.setPosition(rs.getString("position"));
            return instructorInfo;
        }
    }
}
