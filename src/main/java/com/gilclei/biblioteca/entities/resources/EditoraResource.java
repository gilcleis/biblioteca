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

import com.gilclei.biblioteca.entities.Editora;
import com.gilclei.biblioteca.services.EditoraService;

@RestController
@RequestMapping(value = "/editoras")
public class EditoraResource {

	@Autowired
	private EditoraService service;

	@GetMapping
	public ResponseEntity<List<Editora>> findAll() {
		List<Editora> editoras = service.findAll();
		return ResponseEntity.ok().body(editoras);
	}

	@GetMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<Editora> findById(@PathVariable Long id) {
		Editora editora = service.findById(id);
		return ResponseEntity.ok().body(editora);
	}

	@PostMapping
	public ResponseEntity<Editora> insert(@Valid @RequestBody Editora obj) {
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
	public ResponseEntity<Editora> update(@Valid @PathVariable Long id, @RequestBody Editora obj) {
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}

}
