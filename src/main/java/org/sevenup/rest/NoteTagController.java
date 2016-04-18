package org.sevenup.rest;

import java.util.List;

import org.sevenup.domain.Note;
import org.sevenup.domain.Tag;
import org.sevenup.service.NoteTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notes")
public class NoteTagController {
	@Autowired
	private NoteTagService notTagService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Note> getNotes() {
		List<Note> notes = notTagService.findAllNote();
		return notes;
	}

	@RequestMapping(value = "/tags", method = RequestMethod.GET)
	public List<Tag> getTags() {
		List<Tag> tags = notTagService.findAllTag();
		return tags;
	}
}
