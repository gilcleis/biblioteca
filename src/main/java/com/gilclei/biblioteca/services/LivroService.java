package com.gilclei.biblioteca.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.gilclei.biblioteca.entities.Livro;
import com.gilclei.biblioteca.entities.repositories.LivroRepository;
import com.gilclei.biblioteca.services.exeptions.DatabaseException;
import com.gilclei.biblioteca.services.exeptions.IntegrityConstraintViolationException;
import com.gilclei.biblioteca.services.exeptions.ResourceNotFoundException;

@Service
public class LivroService {	
	
	@Autowired
	private LivroRepository repository;

	public Livro insert(Livro obj) {
		try {
			obj.setId(null);
			return repository.save(obj);
		} catch (DataIntegrityViolationException e) {
			throw new IntegrityConstraintViolationException(e.getCause().getLocalizedMessage());
		}
	}

	public Livro findById(Long id) {
		Optional<Livro> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public List<Livro> findAll() {
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

	public Livro update(Long id, Livro obj) {
		try {
			Livro entity = findById(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Livro entity, Livro obj) {
		entity.setNome(obj.getNome());	
		entity.setTipo(obj.getTipo());
		entity.setValor(obj.getValor());
		entity.setAlugado(obj.getAlugado());
		
		entity.setEdicao(obj.getEdicao());	
		entity.setAutor(obj.getAutor());	
	}
	
		
}
