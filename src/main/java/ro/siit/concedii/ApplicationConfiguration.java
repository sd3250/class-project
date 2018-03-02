package ro.sci.ems;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ro.sci.ems.dao.EmployeeDAO;
import ro.sci.ems.dao.inmemory.IMEmployeeDAO;
import ro.sci.ems.service.EmployeeService;

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
