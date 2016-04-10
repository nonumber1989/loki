
package org.sevenup.service;

import org.sevenup.domain.Artwork;
import org.sevenup.repository.ArtworkRepository;
import org.sevenup.repository.jpa.ArtworkDefaultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ArtworkServiceHandler implements ArtworkService {
	@Autowired
	private ArtworkRepository artworkRepository;
	@Autowired
    private ArtworkDefaultRepository JpaRepository;
	@Override
	public Page<Artwork> findByPageable(Pageable pageable) {
		return JpaRepository.findAll(pageable);
	}

	@Override
	public Artwork findById(Long id) {
		return  (Artwork) JpaRepository.findOne(id);
	}

	@Override
	public boolean exists(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long count() {
		return artworkRepository.count();
	}

	@Override
	@Transactional
	public void delete(Long id) {
		artworkRepository.xxxx(id);

	}

	@Override
	public Artwork save(Artwork entity) {
		return JpaRepository.save(entity);
	}

}
