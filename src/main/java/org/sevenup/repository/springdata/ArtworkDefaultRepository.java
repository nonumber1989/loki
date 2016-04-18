package org.sevenup.repository.springdata;

import org.sevenup.domain.Artwork;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ArtworkDefaultRepository extends PagingAndSortingRepository<Artwork,Long>{

}
