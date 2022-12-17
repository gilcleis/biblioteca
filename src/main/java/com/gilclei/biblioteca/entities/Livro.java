package com.gilclei.biblioteca.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "livros")
public class Livro extends Media  implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer edicao;
	private Autor autor;
	
	public Livro(String nome) {
		super(nome, "Livro");
	}
	
	public Integer getEdicao() {
		return edicao;
	}
	
	public void setEdicao(Integer edicao) {
		this.edicao = edicao;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}
}
