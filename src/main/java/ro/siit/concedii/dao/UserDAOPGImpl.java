package ro.siit.concedii.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ro.siit.concedii.domain.User;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

public class UserDAOPGImpl implements UserDAO {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeDAOPGImpl.class);


    private JdbcTemplate jdbcTemplate;

    public UserDAOPGImpl(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public User getUserInfo(User user) {
        return null;
    }

    @Override
    public Collection<User> getAll() {
        return jdbcTemplate.query("select * from user", new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User result = new User();
                result.setId(resultSet.getLong(1));
                return result;
            }
        });
    }

    @Override
    public User findById(Long id) {
        return jdbcTemplate.queryForObject("select * from user where id = ?", new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User result = new User();
                result.setId(resultSet.getInt(1));
                result.setUserName(resultSet.getString(2));
                result.setPassword(resultSet.getString(3));
                result.setAdmin(resultSet.getString(4).equals("ADMIN"));
                result.setEmployeeId(resultSet.getInt(5));
                return result;
            }
        }, id);
    }

    public User findByEmployeeId(Long id) {
        return jdbcTemplate.queryForObject("select * from user where employee_id = ?", new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User result = new User();
                result.setId(resultSet.getInt(1));
                result.setUserName(resultSet.getString(2));
                result.setPassword(resultSet.getString(3));
                result.setAdmin(resultSet.getString(4).equals("ADMIN"));
                result.setEmployeeId(resultSet.getInt(5));
                return result;
            }
        }, id);
    }


    public User findByUsername(String username) {
        return jdbcTemplate.queryForObject("select * from user where username = ?", new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User result = new User();
                result.setId(resultSet.getInt(1));
                result.setUserName(resultSet.getString(2));
                result.setPassword(resultSet.getString(3));
                result.setAdmin(resultSet.getString(4).equals("ADMIN"));
                result.setEmployeeId(resultSet.getInt(5));
                return result;
            }
        }, username);
    }

    //TODO Sebi: need to move the duplicate logic for mapping user row to another function

    @Override
    public User add(User model) {
        return new User();
    }

    @Override
    public boolean update(User model, Long id) {
        return false;
    }

    @Override
    public boolean delete(User model) {
        return false;
    }
}
