package org.sevenup.repository;

import org.sevenup.domain.Artwork;

public interface ArtworkRepository {

	public long count();

	public Artwork delete(Long id);

}