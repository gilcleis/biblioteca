package com.gilclei.biblioteca.entities.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gilclei.biblioteca.entities.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>{

}
