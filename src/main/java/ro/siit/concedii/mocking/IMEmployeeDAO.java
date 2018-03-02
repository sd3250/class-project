package ro.siit.concedii.mocking;



import org.apache.commons.lang3.StringUtils;
import ro.siit.concedii.dao.EmployeeDAO;
import ro.siit.concedii.domain.Employee;


import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;


public class IMEmployeeDAO extends IMBaseDAO<Employee> implements EmployeeDAO {

	@Override
	public Collection<Employee> searchByName(String query) {
		if (StringUtils.isEmpty(query)) {
			return getAll();
		}
		
		Collection<Employee> all = new LinkedList<Employee>(getAll());
		for (Iterator<Employee> it = all.iterator(); it.hasNext();) {
			Employee emp = it.next();
			String ss = emp.getFirstName() + " " + emp.getLastName();
			if (!ss.toLowerCase().contains(query.toLowerCase())) {
				it.remove();
			}
		}
		return all;
	}

	

}
