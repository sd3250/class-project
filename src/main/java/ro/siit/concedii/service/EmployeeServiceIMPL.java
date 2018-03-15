package ro.siit.concedii.service;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import ro.siit.concedii.dao.EmployeeDAO;
import ro.siit.concedii.domain.Employee;





@Service
public class EmployeeServiceIMPL implements EmployeeService{
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceIMPL.class);

	private EmployeeDAO dao;

    @Override
	public Collection<Employee> listAll() {
		return dao.getAll();
	}

	/*
	daca trebuie sa identificam un angajat pe baza de aLtceva decat id va trebui sa folosim o alta
	metoda, poate CNP de adaugat la employee sa fie search unic, sau un mod de a filtra
	in mai multe rezultate de angajati cu acelasi nume

		(NU FACEM IN SPRINTUL ASTA!!!!!!!!!!!!!! presupunem ca nu avem angajati cu acelasi nume)


	   */
	@Override
	@Deprecated
	public Collection<Employee> search( String query) {
		LOGGER.debug("Searching for " + query);
		return dao.searchByName(query);
	}

    @Override
	public boolean delete(Long id) {
		LOGGER.debug("Deleting employee for id: " + id);
		Employee emp = dao.findById(id);
		if (emp != null) {
			dao.delete(emp);
			return true;
		}

		return false;
	}

    @Override
	public Employee get(Long id) {
		LOGGER.debug("Getting employee for id: " + id);
		return dao.findById(id);

	}

    @Override
	public void save(Employee employee) throws ValidationException {
		LOGGER.debug("Saving: " + employee);
		validate(employee);

		dao.add(employee);
	}

	@Override
	public boolean update(Employee employee, Long id) throws ValidationException {
	    if (dao.update(employee,id)) {
            LOGGER.debug("Updateing: " + employee);
            return true;
        } else {
            LOGGER.debug("Can't update employee, id not found: " + id);
            return false;
        }

	}

	private void validate(Employee employee) throws ValidationException {
		Date currentDate = new Date();
		List<String> errors = new LinkedList<String>();
		if (StringUtils.isEmpty(employee.getFirstName())) {
			errors.add("First Name is Empty");
		}

		if (StringUtils.isEmpty(employee.getLastName())) {
			errors.add("Last Name is Empty");
		}

		if (employee.getGender() == null) {
			errors.add("Gender is Empty");
		}

		if (StringUtils.isEmpty(employee.getJobTitle())) {
			errors.add("JobTitle is Empty");
		}

		if (employee.getBirthDate() == null) {
			errors.add("BirthDate is Empty");
		} else {
			if (currentDate.before(employee.getBirthDate())) {
				errors.add("Birthdate in future");
			}
			
			Calendar c = GregorianCalendar.getInstance();
			c.setTime(new Date());
			c.set(Calendar.YEAR, c.get(Calendar.YEAR) - 18);
			if (employee.getBirthDate().after(c.getTime())) {
				errors.add("Too young to get employeed");
			}
			
			c.set(Calendar.YEAR, 1901);
			if (employee.getBirthDate().before(c.getTime())) {
				errors.add("Too old to get employeed");
			}
			
		}

		if (employee.getEmploymentDate() == null) {
			errors.add("EmploymentDate is Empty");
		} else {
			if (currentDate.before(employee.getEmploymentDate())) {
				errors.add("EmploymentDate in future");
			}
		}
		
		if (employee.getBirthDate() != null && employee.getEmploymentDate() != null) {
			if (employee.getEmploymentDate().before(employee.getBirthDate())) {
				errors.add("EmploymentDate before BirthDate");
			}
		}
		
		

		if (!errors.isEmpty()) {
			throw new ValidationException(errors.toArray(new String[] {}));
		}
	}

	public EmployeeDAO getDao() {
		return dao;
	}

	public void setDao(EmployeeDAO dao) {
		this.dao = dao;
	}
	
	
}
