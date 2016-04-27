package org.sevenup.repository;

import org.sevenup.domain.Artwork;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ArtworkRepository extends PagingAndSortingRepository<Artwork,Long>{
	public void test();

}