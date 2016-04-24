package org.sevenup.repository.springdata;

import org.sevenup.domain.Artwork;
import org.sevenup.repository.common.LokiPagingAndSortingRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
@Repository
public class ArtworkDefaultRepository extends LokiPagingAndSortingRepository<Artwork,Long> implements PagingAndSortingRepository<Artwork, Long>{

}
