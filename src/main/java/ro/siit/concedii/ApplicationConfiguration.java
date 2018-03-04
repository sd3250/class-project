package ro.siit.concedii;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ro.siit.concedii.dao.EmployeeDAO;
import ro.siit.concedii.mocking.IMEmployeeDAO;
import ro.siit.concedii.service.EmployeeServiceIMPL;

@Configuration
public class ApplicationConfiguration {

	@Bean
	public EmployeeServiceIMPL employeeService() {
		EmployeeServiceIMPL ems = new EmployeeServiceIMPL();
		
		ems.setDao(employeeDAO());
		return ems;
	}
	
	@Bean
	public EmployeeDAO employeeDAO() {
		return new IMEmployeeDAO();
	}
}
