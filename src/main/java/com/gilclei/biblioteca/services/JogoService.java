package com.gilclei.biblioteca.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.gilclei.biblioteca.entities.Jogo;
import com.gilclei.biblioteca.entities.repositories.JogoRepository;
import com.gilclei.biblioteca.services.exeptions.DatabaseException;
import com.gilclei.biblioteca.services.exeptions.IntegrityConstraintViolationException;
import com.gilclei.biblioteca.services.exeptions.ResourceNotFoundException;

@Service
public class JogoService {	
	
	@Autowired
	private JogoRepository repository;

	public Jogo insert(Jogo obj) {
		try {
			obj.setId(null);
			return repository.save(obj);
		} catch (DataIntegrityViolationException e) {
			throw new IntegrityConstraintViolationException(e.getCause().getLocalizedMessage());
		}
	}

	public Jogo findById(Long id) {
		Optional<Jogo> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public List<Jogo> findAll() {
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

	public Jogo update(Long id, Jogo obj) {
		try {
			Jogo entity = findById(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(Jogo entity, Jogo obj) {
		entity.setNome(obj.getNome());	
		entity.setTipo(obj.getTipo());
		entity.setValor(obj.getValor());
		entity.setAlugado(obj.getAlugado());
		
		entity.setDesenvolvedora(obj.getDesenvolvedora());
		entity.setDigital(obj.getDigital());
		entity.setVersao(obj.getVersao());
		
	}
	
		
}
