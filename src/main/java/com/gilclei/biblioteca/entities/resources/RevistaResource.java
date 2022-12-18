package com.gilclei.biblioteca.entities.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gilclei.biblioteca.entities.Revista;
import com.gilclei.biblioteca.services.RevistaService;

@RestController
@RequestMapping(value = "/revistas")
public class RevistaResource {

	@Autowired
	private RevistaService service;

	@GetMapping
	public ResponseEntity<List<Revista>> findAll() {
		List<Revista> revistas = service.findAll();
		return ResponseEntity.ok().body(revistas);
	}

	@GetMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<Revista> findById(@PathVariable Long id) {
		Revista revista = service.findById(id);
		return ResponseEntity.ok().body(revista);
	}

	@PostMapping
	public ResponseEntity<Revista> insert(@Valid @RequestBody Revista obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Revista> update(@Valid @PathVariable Long id, @RequestBody Revista obj) {
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}

}
