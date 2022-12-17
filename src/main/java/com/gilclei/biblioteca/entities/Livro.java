package com.gilclei.biblioteca.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "livros")
public class Livro extends Media implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer edicao;
	
	@ManyToOne
	@JoinColumn(name = "autor_id")
	private Autor autor;

	public Livro() {
	}

	public Livro(String nome) {
		super(nome, "Livro");
	} 
	
	public Livro( Long id,String nome, String tipo, Integer edicao, Autor autor,Double valor, Boolean alugado) {
		super(nome, tipo,valor, alugado);
		this.id = id;
		this.edicao = edicao;
		this.autor = autor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
		return "Livro [id=" + id + ", edicao=" + edicao + ", autor=" + autor + ", nome=" + nome + ", tipo=" + tipo
				+ ", valor=" + valor + ", alugado=" + alugado + "]";
	}

	

}
