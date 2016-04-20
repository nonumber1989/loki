package org.sevenup.rest;

import java.util.Optional;

import javax.validation.Valid;

import org.sevenup.common.exception.ResourceNotFoundException;
import org.sevenup.domain.Artwork;
import org.sevenup.service.ArtworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefaults;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/artworks")
public class ArtworkController {
	@Autowired
	private ArtworkService artworkService;
	@RequestMapping(method = RequestMethod.GET)
	public Page<Artwork> getPageableArtworks(
			@PageableDefaults(pageNumber = 0, value = 10, sort = { "id" }) Pageable pageable) {
		Page<Artwork> pageArtwork = artworkService.findByPageable(pageable);
		return pageArtwork;
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Artwork getUserById(@PathVariable Long id) {
		Optional<Artwork> artwork = Optional.ofNullable(artworkService.findById(id));
		return artwork.orElseThrow(ResourceNotFoundException::new);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Artwork createUser(@Valid @RequestBody Artwork artwork) {
		return artworkService.save(artwork);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Artwork delete(@PathVariable Long id) {
		 return artworkService.delete(id);
	}
}
