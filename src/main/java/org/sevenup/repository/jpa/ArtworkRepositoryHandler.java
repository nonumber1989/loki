package org.sevenup.repository.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.sevenup.domain.Artwork;
import org.sevenup.repository.ArtworkRepository;
import org.springframework.stereotype.Repository;
@Repository
//extends SimpleJpaRepository<Artwork,Long>
public class ArtworkRepositoryHandler  implements ArtworkRepository {
	@PersistenceContext
	private  EntityManager em;
	


	@Override
	public long count() {
		return 0;
	}

	@Override
	@Transactional
	public void xxxx(Long id) {
		Artwork a = new Artwork();
		a.setName("eeeee");
		em.persist(a);
	}
	
}
