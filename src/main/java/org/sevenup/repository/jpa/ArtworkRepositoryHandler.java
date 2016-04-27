package org.sevenup.repository.jpa;

import org.sevenup.domain.Artwork;
import org.sevenup.repository.ArtworkRepository;
import org.sevenup.repository.common.LokiPagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ArtworkRepositoryHandler extends LokiPagingAndSortingRepository<Artwork,Long> implements ArtworkRepository{

	@Override
	public void test() {
		this.em.clear();
		
	}
	
}

