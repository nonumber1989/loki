package org.sevenup.repository.common;

import java.io.Serializable;

import org.springframework.data.repository.Repository;

public interface LokiCrudRepository<T, ID extends Serializable> {

	<S extends T> S save(S entity);

	<S extends T> Iterable<S> save(Iterable<S> entities);

	T findOne(ID id);

	boolean exists(ID id);

	Iterable<T> findAll(Iterable<ID> ids);

	long count();

	void delete(ID id);

	void delete(T entity);

	void delete(Iterable<? extends T> entities);

}
