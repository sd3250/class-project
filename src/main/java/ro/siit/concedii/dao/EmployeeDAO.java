package ro.siit.concedii.dao;


import ro.siit.concedii.domain.Employee;

import java.util.Collection;

public interface EmployeeDAO extends BaseDAO<Employee>{

	Collection<Employee> searchByName(String query);
//	long addBy //	//shout retun id
}
