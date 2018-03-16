package ro.siit.concedii.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import ro.siit.concedii.domain.User;

import javax.sql.DataSource;
import java.util.Collection;
import java.util.LinkedList;

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
        return new LinkedList<>();
    }

    @Override
    public User findById(Long id) {
        return new User();
    }

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
