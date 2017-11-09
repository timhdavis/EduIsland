package webapp157A;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class UserDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    DataSource dataSource;

    public static final String REGISTER_USER = "insert into user values(?, ?, ?)";

    public void register(User user) {
        jdbcTemplate.update(REGISTER_USER, new Object[] {user.getUserId(), user.getPassword(), user.getDatejoined()});
    }
}
