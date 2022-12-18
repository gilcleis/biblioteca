package com.gilclei.biblioteca.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.gilclei.biblioteca.entities.Autor;
import com.gilclei.biblioteca.entities.repositories.AutorRepository;
import com.gilclei.biblioteca.services.exeptions.DatabaseException;
import com.gilclei.biblioteca.services.exeptions.IntegrityConstraintViolationException;
import com.gilclei.biblioteca.services.exeptions.ResourceNotFoundException;

@Service
public class AutorService {	
	
	@Autowired
	private AutorRepository repository;

	public Autor insert(Autor obj) {
		try {
			obj.setId(null);
			return repository.save(obj);
		} catch (DataIntegrityViolationException e) {
			throw new IntegrityConstraintViolationException(e.getCause().getLocalizedMessage());
		}
	}

	public Autor findById(Long id) {
		Optional<Autor> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public List<Autor> findAll() {
		return repository.findAll();
	}

	public void delete(Long id) {
		findById(id);
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	public Autor update(Long id, Autor obj) {
		try {
			Autor entity = findById(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Autor entity, Autor obj) {
		entity.setNome(obj.getNome());		
	}
	
		
}
