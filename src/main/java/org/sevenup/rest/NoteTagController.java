package org.sevenup.rest;

import java.util.List;
import java.util.stream.Collectors;

import org.sevenup.domain.Note;
import org.sevenup.domain.Tag;
import org.sevenup.dto.NoteDTO;
import org.sevenup.service.NoteTagService;
import org.springframework.beans.BeanUtils;
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
	public List<NoteDTO> getNotes() {
		List<Note> notes = notTagService.findAllNote();
		List<NoteDTO> noteDTOs = notes.stream().map(note->{
			NoteDTO dto = new NoteDTO();
			BeanUtils.copyProperties(note, dto);
			return dto;
		}).collect(Collectors.toList());
		return noteDTOs;
	}

	@RequestMapping(value = "/tags", method = RequestMethod.GET)
	public List<Tag> getTags() {
		List<Tag> tags = notTagService.findAllTag();
		return tags;
	}
}
