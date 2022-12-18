package com.gilclei.biblioteca.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "livros")
public class Livro extends Media implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer edicao;
	
	@ManyToOne
	@JoinColumn(name = "autor_id")
	private Autor autor;

	public Livro() {
	}

	public Livro(String nome) {
		super(nome, "Livro");
	} 
	
	public Livro(Long id, String nome, String tipo, Integer edicao, Autor autor,Double valor, Boolean alugado) {
		super(id,nome, tipo,valor, alugado);
		this.edicao = edicao;
		this.autor = autor;
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

	@Override
	public String toString() {
		return "Livro [id=" + getId() + ", edicao=" + edicao + ", autor=" + autor + ", nome=" + nome + ", tipo=" + tipo
				+ ", valor=" + valor + ", alugado=" + alugado + "]";
	}

	

}
