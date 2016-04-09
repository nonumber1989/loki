package org.sevenup.repository;

import java.util.List;

import org.sevenup.domain.Tag;

public interface TagRepository {

	List<Tag> findAll();

}
