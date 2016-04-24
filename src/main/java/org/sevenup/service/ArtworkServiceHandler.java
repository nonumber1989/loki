
package org.sevenup.service;

import org.sevenup.domain.Artwork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ArtworkServiceHandler implements ArtworkService {
//	@Autowired
//	private ArtworkRepository artworkRepository;
	@Autowired
	private PagingAndSortingRepository<Artwork,Long> artworkDefaultRepository;

	@Override
	public Page<Artwork> findByPageable(Pageable pageable) {
		return artworkDefaultRepository.findAll(pageable);
	}

	@Override
	public Artwork findById(Long id) {
		return (Artwork) artworkDefaultRepository.findOne(id);
	}

	@Override
	public boolean exists(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long count() {
		return artworkDefaultRepository.count();
	}

	@Override
	@Transactional
	public Artwork delete(Long id) {
//		return artworkRepository.delete(id);
		return null;
	}

	@Override
	public Artwork save(Artwork entity) {
		return artworkDefaultRepository.save(entity);
	}

}
