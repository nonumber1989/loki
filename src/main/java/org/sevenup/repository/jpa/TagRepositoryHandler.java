package org.sevenup.repository.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.sevenup.domain.Tag;
import org.sevenup.repository.TagRepository;
import org.springframework.stereotype.Repository;

@Repository
class TagRepositoryHandler implements TagRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Tag> findAll() {
		return this.entityManager.createQuery("SELECT t FROM Tag t", Tag.class)
				.getResultList();
	}

}
