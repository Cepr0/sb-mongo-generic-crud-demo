package io.github.cepr0.demo.model;

import io.github.cepr0.crud.model.IdentifiableEntity;

import java.io.Serializable;
import java.util.Objects;

public abstract class MongoEntity<ID extends Serializable> implements IdentifiableEntity<ID> {

	@Override
	public String toString() {
		return getClass().getSimpleName() + "{id=" + getId() + "}";
	}

//	@Override
//	public boolean equals(Object o) {
//		if (this == o) return true;
//		if (o == null || getClass() != o.getClass()) return false;
//		return getId() != null && getId().equals(((MongoEntity) o).getId());
//	}
//
//	@Override
//	public int hashCode() {
//		return 31;
//	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) return true;
		if (!(o instanceof MongoEntity)) return false;
		final MongoEntity<?> that = (MongoEntity<?>) o;
		return Objects.equals(getId(), that.getId());
	}

	@Override
	public int hashCode() {
		return getId() != null ? getId().hashCode() : 0;
	}
}
