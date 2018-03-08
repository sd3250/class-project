package ro.siit.concedii.mocking;

import ro.siit.concedii.dao.BaseDAO;
import ro.siit.concedii.domain.AbstractModel;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class IMBaseDAO<T extends AbstractModel> implements BaseDAO<T> {
	private Map<Long, T> models = new HashMap<Long, T>();

	private static AtomicLong ID = new AtomicLong(System.currentTimeMillis());


	@Override
	public Collection<T> getAll() {

		return models.values();
	}

	@Override
	public T findById(Long id) {

		return models.get(id);
	}

	@Override
	public T add(T model) {

			model.setId(ID.getAndIncrement());


		models.put(model.getId(), model);
		return model;
	}

	@Override
	public boolean update(T model, Long id) {
		if (findById(id) != null){
            models.put(model.getId(), model);
            return true;
		}
		return false;
	}

	@Override
	public boolean delete(T model) {
		boolean result = models.containsKey(model.getId());

		if (result)
			models.remove(model.getId());
		return result;
	}

}
