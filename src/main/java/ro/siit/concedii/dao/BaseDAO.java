package ro.siit.concedii.dao;


import ro.siit.concedii.domain.AbstractModel;
import ro.siit.concedii.domain.Leave;

import java.util.Collection;

//reuse de la sebi

public interface BaseDAO<T extends AbstractModel> {


	Collection<T> getAll();
	
	T findById(Long id);
	
	T add(T model);

	boolean update (T model, Long id);
	
	boolean delete(T model);
}
