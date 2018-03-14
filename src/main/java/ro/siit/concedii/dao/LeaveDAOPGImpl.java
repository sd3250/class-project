package ro.siit.concedii.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ro.siit.concedii.domain.Leave;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by dan.sabau on 3/14/2018
 */
public class LeaveDAOPGImpl implements LeaveDAO {

    private JdbcTemplate jdbcTemplate;

    public LeaveDAOPGImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Collection<Leave> searchByEmployeeID(long employeeID) {
        return (Collection<Leave>) findById(employeeID);
    }

    @Override
    public Collection<Leave> getAll() {
        return jdbcTemplate.query("select * from leave", new RowMapper<Leave>() {
            @Override
            public Leave mapRow(ResultSet resultSet, int i) throws SQLException {
                Leave result = new Leave();
                result.setId(resultSet.getLong(1));
                result.setEmployeeID(resultSet.getLong(2));
                result.setStartDate(resultSet.getDate(3));
                result.setNoDays(resultSet.getInt(4));
                result.setLeaveType(resultSet.getString(5));
                result.setApproved(resultSet.getBoolean(6));
                return result;
            }
        });
    }

    @Override
    public Leave findById(Long id) {
        return jdbcTemplate.queryForObject("select * from leave where id = ?", new RowMapper<Leave>() {
            @Override
            public Leave mapRow(ResultSet resultSet, int i) throws SQLException {
                Leave result = new Leave();
                result.setId(resultSet.getLong(1));
                result.setEmployeeID(resultSet.getLong(2));
                result.setStartDate(resultSet.getDate(3));
                result.setNoDays(resultSet.getInt(4));
                result.setLeaveType(resultSet.getString(5));
                result.setApproved(resultSet.getBoolean(6));
                return result;
            }
        }, id);
    }

    @Override
    public Leave add(Leave model) {
        long id = jdbcTemplate.queryForObject("insert into leave (employee_id, start_date, days, leave_type, approved) values (?, ?, ?, ?, ?) returning id", new RowMapper<Long>() {
            @Override
            public Long mapRow(ResultSet resultSet, int i) throws SQLException {
                return resultSet.getLong(1);
            }
        }, model.getEmployeeID(),model.getStartDate(), model.getNoDays(), model.getLeaveTypeToString(),model.getApproved());
        model.setId(id);
        return model;
    }

    @Override
    public boolean update(Leave model, Long id) {
        int i = jdbcTemplate.update("update leave set (employee_id, start_date, days, leave_type, approved) = (?, ?, ?, ?, ?) where id = ?", model.getEmployeeID(),model.getStartDate(), model.getNoDays(), model.getLeaveTypeToString(),model.getApproved(), model.getId());
        if (i != 0 ){
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Leave model) {
        int i = jdbcTemplate.update("DELETE FROM leave WHERE id=?", model.getId());
        if (i != 0 ){
            return true;
        }
        return false;
    }
}
