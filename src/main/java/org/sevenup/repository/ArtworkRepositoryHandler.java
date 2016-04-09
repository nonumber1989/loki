package org.sevenup.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.sevenup.domain.Artwork;
import org.sevenup.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public class ArtworkRepositoryHandler implements ArtworkRepository {
	@PersistenceContext
	private EntityManager em;

	@Override
	public Page<Artwork> findByPageable(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends User> S save(S entity) {
		em.persist(entity);
		return entity;
	}

	@Override
	public User findById(Long id) {
		return em.find(User.class, id);
	}

	@Override
	public boolean exists(Long id) {
		return false;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

}
