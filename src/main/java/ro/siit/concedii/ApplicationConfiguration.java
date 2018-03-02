package ro.siit.concedii;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ro.siit.concedii.dao.EmployeeDAO;
import ro.siit.concedii.mocking.IMEmployeeDAO;
import ro.siit.concedii.service.EmployeeService;

@Configuration
public class ApplicationConfiguration {

	@Bean
	public EmployeeService employeeService() {
		EmployeeService ems = new EmployeeService();
		
		ems.setDao(employeeDAO());
		return ems;
	}
	
	@Bean
	public EmployeeDAO employeeDAO() {
		return new IMEmployeeDAO();
	}
}
