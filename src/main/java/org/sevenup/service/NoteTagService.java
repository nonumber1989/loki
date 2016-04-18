package org.sevenup.service;

import java.util.List;

import org.sevenup.domain.Note;
import org.sevenup.domain.Tag;

public interface NoteTagService {
	List<Note> findAllNote();

	List<Tag> findAllTag();
}
