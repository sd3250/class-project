package ro.siit.concedii;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.web.client.RestTemplate;
import ro.siit.concedii.dao.EmployeeDAO;
import ro.siit.concedii.dao.EmployeeDAOPGImpl;
import ro.siit.concedii.dao.UserDAO;
import ro.siit.concedii.dao.UserDAOPGImpl;
import ro.siit.concedii.dao.LeaveDAO;
import ro.siit.concedii.dao.LeaveDAOPGImpl;
import ro.siit.concedii.mocking.IMEmployeeDAO;
import ro.siit.concedii.service.EmployeeService;
import ro.siit.concedii.service.EmployeeServiceIMPL;
import ro.siit.concedii.service.UserService;
import ro.siit.concedii.service.UserServiceIMPL;
import ro.siit.concedii.service.LeaveService;
import ro.siit.concedii.service.LeaveServiceIMPL;

import javax.sql.DataSource;

@Configuration
public class ApplicationConfiguration {
	@Bean
	public EmployeeDAO employeeDAO (){
	    return new EmployeeDAOPGImpl(dataSource());
    }

    @Bean
    public UserDAO userDAO (){
        return new UserDAOPGImpl(dataSource());
    }

    @Bean
    public LeaveDAO leaveDAO () {
	    return new LeaveDAOPGImpl(dataSource());
	}

    @Bean
    public DataSource dataSource() {
        String url = new StringBuilder()
                .append("jdbc:")
                .append("postgresql")
                .append("://")
                .append("localhost")
                .append(":")
                .append("5432")
                .append("/")
                .append("postgres")
                .append("?user=")
                .append("sebastian.sirb").toString();
        return new SingleConnectionDataSource(url, false);
    }

    @Bean
    public EmployeeService employeeService() {
	    return new EmployeeServiceIMPL();
    }
    @Bean
    public UserService UserService() { return new UserServiceIMPL(); }

    @Bean
    public LeaveService leaveService() {
	    return new LeaveServiceIMPL();
	}

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
