package ro.siit.concedii;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import ro.siit.concedii.dao.EmployeeDAO;
import ro.siit.concedii.dao.EmployeeDAOPGImpl;
import ro.siit.concedii.dao.LeaveDAO;
import ro.siit.concedii.dao.LeaveDAOPGImpl;
import ro.siit.concedii.mocking.IMEmployeeDAO;
import ro.siit.concedii.service.EmployeeServiceIMPL;

import javax.sql.DataSource;

@Configuration
public class ApplicationConfiguration {
	@Bean
	public EmployeeDAO employeeDAO (){
	    return new EmployeeDAOPGImpl(dataSource());
    }

    @Bean
    private LeaveDAO leaveDAO () {
	    return new LeaveDAOPGImpl(dataSource());
	}

    @Bean
    private DataSource dataSource() {
        String url = new StringBuilder()
                .append("jdbc:")
                .append("postgresql")
                .append("://")
                .append("localhost")
                .append(":")
                .append("5432")
                .append("/")
                .append("concedii")
                .append("?user=")
                .append("postgres")
                .append("&password=")
                .append("asdf123").toString();
        return new SingleConnectionDataSource(url, false);
    }
}
