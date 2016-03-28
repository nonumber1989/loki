package org.sevenup.rest;

import java.util.List;

import org.sevenup.domain.Note;
import org.sevenup.domain.Tag;
import org.sevenup.repository.NoteRepository;
import org.sevenup.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notes")
public class LokiController {
	@Autowired
	private NoteRepository noteRepository;
	@Autowired
	private TagRepository tagRepository;
	@RequestMapping(method = RequestMethod.GET)
	public List<Note> getNotes() {
		List<Note> notes = this.noteRepository.findAll();
		return notes;
	}

	@RequestMapping("/1")
	public Note getNote() {
		List<Note> notes = this.noteRepository.findAll();
		return notes.get(0);
	}

	@RequestMapping(value = "/tags", method = RequestMethod.GET)
	public List<Tag> getTags() {
		List<Tag> tags = this.tagRepository.findAll();
		return tags;
	}

}