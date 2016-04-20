package org.sevenup.repository.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.sevenup.domain.Artwork;
import org.sevenup.repository.ArtworkRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ArtworkRepositoryHandler implements ArtworkRepository {
	@PersistenceContext
	private EntityManager em;
	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Artwork delete(Long id) {
		Artwork entity = em.find(Artwork.class, id);
		em.remove(em.contains(entity) ? entity : em.merge(entity));
		return entity;
	}


}
