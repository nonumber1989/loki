package org.sevenup.repository.common;
/*
 * Copyright 2008-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import static org.sevenup.repository.common.QueryUtils.COUNT_QUERY_STRING;
import static org.sevenup.repository.common.QueryUtils.getQueryString;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.TypedQuery;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

//@Repository
@NoRepositoryBean
@Transactional(readOnly = true)
public class LokiPagingAndSortingRepository<T, ID extends Serializable> implements PagingAndSortingRepository<T, ID> {

	private Class<T> entityClass;
	@PersistenceContext(type = PersistenceContextType.TRANSACTION)
	protected EntityManager em;
	@SuppressWarnings("unchecked")
	public LokiPagingAndSortingRepository() {
		entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	protected Class<T> getDomainClass() {
		return this.entityClass;
	}

	@Override
	public <S extends T> S save(S entity) {
		em.persist(entity);
		return entity;
	}

	@Override
	public <S extends T> Iterable<S> save(Iterable<S> entities) {
		List<S> result = new ArrayList<S>();
		if (entities == null) {
			return result;
		}
		for (S entity : entities) {
			result.add(save(entity));
		}
		return result;
	}

	@Override
	public T findOne(ID id) {
		Class<T> domainType = getDomainClass();
		return em.find(domainType, id);
	}

	@Override
	public boolean exists(ID id) {

		String entityName = this.getEntityName();
		
		String existsQuery = QueryUtils.getExistsQueryString(entityName, "x", null);

		TypedQuery<Long> query = em.createQuery(existsQuery, Long.class);

		return query.getSingleResult() == 1L;
	
	}

	@Override
	public Iterable<T> findAll() {
		return em.createQuery("Select t from " + getEntityName() + " t").getResultList();
	}

	@Override
	public Iterable<T> findAll(Iterable<ID> ids) {
		if (ids == null || !ids.iterator().hasNext()) {
			return Collections.emptyList();
		}
		List<T> results = new ArrayList<T>();

		for (ID id : ids) {
			results.add(findOne(id));
		}
		return results;
	}

	@Override
	public long count() {
		return em.createQuery(getCountQueryString(), Long.class).getSingleResult();
	}

	@Override
	public void delete(ID id) {
		T entity = findOne(id);
		if (entity == null) {
			//TODO
		}
		delete(entity);
	}

	@Override
	public void delete(T entity) {
		em.remove(em.contains(entity) ? entity : em.merge(entity));
	}

	@Override
	public void delete(Iterable<? extends T> entities) {
		for (T entity : entities) {
			delete(entity);
		}
	}

	@Override
	public void deleteAll() {
		for (T element : findAll()) {
			delete(element);
		}
	}

	@Override
	public Iterable<T> findAll(Sort sort) {
		return null;
	}

	@Override
	public Page<T> findAll(Pageable pageable) {
		return null;
	}
	
	/**
	 * Executes a count query and transparently sums up all values returned.
	 * 
	 * @param query must not be {@literal null}.
	 * @return
	 */
	private static Long executeCountQuery(TypedQuery<Long> query) {
		List<Long> totals = query.getResultList();
		Long total = 0L;
		for (Long element : totals) {
			total += element == null ? 0 : element;
		}
		return total;
	}
	private String getCountQueryString() {
		String countQuery = String.format(COUNT_QUERY_STRING, "x", "%s");
		return getQueryString(countQuery, this.getDomainClass().getName());
	}
	
	public String getEntityName() {
		Entity entity = this.entityClass.getAnnotation(Entity.class);
		boolean hasName = null != entity && StringUtils.hasText(entity.name());
		return hasName ? entity.name() : this.entityClass.getSimpleName();
	}
}