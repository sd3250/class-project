package ro.siit.concedii.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ro.siit.concedii.domain.Employee;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by dan.sabau on 3/14/2018
 */
public class EmployeeDAOPGImpl implements EmployeeDAO {

    private JdbcTemplate jdbcTemplate;

    public EmployeeDAOPGImpl(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Collection<Employee> searchByName(String query) {
        return null;
    }

    @Override
    public Collection<Employee> getAll() {
        return jdbcTemplate.query("select * from employee", new RowMapper<Employee>() {
            @Override
            public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
                Employee result = new Employee();
                result.setId(resultSet.getLong(1));
                result.setFirstName(resultSet.getString(2));
                result.setLastName(resultSet.getString(3));
                result.setBirthDate(resultSet.getDate(4));
                result.setGender(resultSet.getString(5));
                result.setEmploymentDate(resultSet.getDate(6));
                result.setJobTitle(resultSet.getString(7));
                result.setSalary(resultSet.getDouble(8));
                return result;
            }
        });
    }

    @Override
    public Employee findById(Long id) {
        return jdbcTemplate.queryForObject("select * from employee where id = ?", new RowMapper<Employee>() {
            @Override
            public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
                Employee result = new Employee();
                result.setId(resultSet.getInt(1));
                result.setFirstName(resultSet.getString(2));
                result.setLastName(resultSet.getString(3));
                result.setBirthDate(resultSet.getDate(4));
                result.setGender(resultSet.getString(5));
                result.setEmploymentDate(resultSet.getDate(6));
                result.setJobTitle(resultSet.getString(7));
                result.setSalary(resultSet.getDouble(8));
                return result;
            }
        }, id);
    }

    @Override
    public Employee add(Employee model) {
        long id = jdbcTemplate.queryForObject("insert into employee(first_name, last_name, birth_date, gender, employment_date, job_title, salary) values(?, ?, ?, ?, ?, ?, ?) returning id ",
                new RowMapper<Long>() {
                    @Override
                    public Long mapRow(ResultSet resultSet, int i) throws SQLException {
                        return resultSet.getLong(1);
                    }
                }, model.getFirstName(), model.getLastName(),model.getBirthDate(),model.getGenderToString(), model.getEmploymentDate(), model.getJobTitle(), model.getSalary());
        model.setId(id);
        return model;
    }

    @Override
    public boolean update(Employee model, Long id) {
        int i = jdbcTemplate.update("update employee set (first_name, last_name, birth_date, gender, employment_date, job_title, salary) = (?, ?, ?, ?, ?, ?, ?)  where id = ?", model.getFirstName(), model.getLastName(),model.getBirthDate(),model.getGenderToString(), model.getEmploymentDate(), model.getJobTitle(), model.getSalary(), model.getId());
        if (i != 0) {
            return true;
        }
        return false;

    }

    @Override
    public boolean delete(Employee model) {
        int i = jdbcTemplate.update("DELETE FROM employee WHERE id=?", model.getId());
        if (i != 0 ){
            return true;
        }
        return false;
    }
}
