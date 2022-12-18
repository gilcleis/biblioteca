package com.gilclei.biblioteca.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.gilclei.biblioteca.entities.Revista;
import com.gilclei.biblioteca.entities.repositories.RevistaRepository;
import com.gilclei.biblioteca.services.exeptions.DatabaseException;
import com.gilclei.biblioteca.services.exeptions.IntegrityConstraintViolationException;
import com.gilclei.biblioteca.services.exeptions.ResourceNotFoundException;

@Service
public class RevistaService {	
	
	@Autowired
	private RevistaRepository repository;

	public Revista insert(Revista obj) {
		try {
			obj.setId(null);
			return repository.save(obj);
		} catch (DataIntegrityViolationException e) {
			throw new IntegrityConstraintViolationException(e.getCause().getLocalizedMessage());
		}
	}

	public Revista findById(Long id) {
		Optional<Revista> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public List<Revista> findAll() {
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

	public Revista update(Long id, Revista obj) {
		try {
			Revista entity = findById(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Revista entity, Revista obj) {
		entity.setNome(obj.getNome());	
		entity.setTipo(obj.getTipo());
		entity.setValor(obj.getValor());
		entity.setAlugado(obj.getAlugado());
		
		entity.setNumero(obj.getNumero());
		entity.setEditora(obj.getEditora());
		
	}
	
		
}
