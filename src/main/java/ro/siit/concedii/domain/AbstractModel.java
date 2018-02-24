package ro.siit.concedii.domain;

/**
 * Used to define the information needed for an Employee.
 *
 * @author sebi
 *
 */
public abstract class AbstractModel {
	private long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	

}
