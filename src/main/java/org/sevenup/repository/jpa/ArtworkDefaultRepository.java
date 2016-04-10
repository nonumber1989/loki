package org.sevenup.repository.jpa;

import org.sevenup.domain.Artwork;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ArtworkDefaultRepository extends PagingAndSortingRepository<Artwork,Long>{

}
