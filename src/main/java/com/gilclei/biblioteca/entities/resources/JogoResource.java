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

import com.gilclei.biblioteca.entities.Jogo;
import com.gilclei.biblioteca.services.JogoService;

@RestController
@RequestMapping(value = "/jogos")
public class JogoResource {

	@Autowired
	private JogoService service;

	@GetMapping
	public ResponseEntity<List<Jogo>> findAll() {
		List<Jogo> jogos = service.findAll();
		return ResponseEntity.ok().body(jogos);
	}

	@GetMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<Jogo> findById(@PathVariable Long id) {
		Jogo jogo = service.findById(id);
		return ResponseEntity.ok().body(jogo);
	}

	@PostMapping
	public ResponseEntity<Jogo> insert(@Valid @RequestBody Jogo obj) {
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
	public ResponseEntity<Jogo> update(@Valid @PathVariable Long id, @RequestBody Jogo obj) {
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}

}
