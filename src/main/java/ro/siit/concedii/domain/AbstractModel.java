package ro.siit.concedii.domain;

import java.util.Objects;

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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof AbstractModel)) return false;
		AbstractModel that = (AbstractModel) o;
		return getId() == that.getId();
	}

	@Override
	public int hashCode() {

		return Objects.hash(getId());
	}
}
