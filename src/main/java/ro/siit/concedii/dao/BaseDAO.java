package ro.siit.concedii.dao;


import ro.siit.concedii.domain.AbstractModel;

import java.util.Collection;

//reuse de la sebi

public interface BaseDAO<T extends AbstractModel> {

	Collection<T> getAll();
	
	T findById(Long id);
	
	T update(T model);
	
	boolean delete(T model);
}
