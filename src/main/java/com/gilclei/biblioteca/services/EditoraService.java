package com.gilclei.biblioteca.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.gilclei.biblioteca.entities.Editora;
import com.gilclei.biblioteca.entities.repositories.EditoraRepository;
import com.gilclei.biblioteca.services.exeptions.DatabaseException;
import com.gilclei.biblioteca.services.exeptions.IntegrityConstraintViolationException;
import com.gilclei.biblioteca.services.exeptions.ResourceNotFoundException;

@Service
public class EditoraService {	
	
	@Autowired
	private EditoraRepository repository;

	public Editora insert(Editora obj) {
		try {
			obj.setId(null);
			return repository.save(obj);
		} catch (DataIntegrityViolationException e) {
			throw new IntegrityConstraintViolationException(e.getCause().getLocalizedMessage());
		}
	}

	public Editora findById(Long id) {
		Optional<Editora> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public List<Editora> findAll() {
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

	public Editora update(Long id, Editora obj) {
		try {
			Editora entity = findById(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Editora entity, Editora obj) {
		entity.setNome(obj.getNome());		
	}
	
		
}
