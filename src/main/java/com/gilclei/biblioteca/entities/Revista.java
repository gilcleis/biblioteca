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
@Table(name = "revistas")
public class Revista extends Media implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Integer numero;
	
	@ManyToOne
	@JoinColumn(name = "editora_id")
	private Editora editora;

	public Revista() {
	}

	public Revista(String nome) {
		super(nome, "Revista");
	}
	
	public Revista(Long id,String nome, String tipo,  Integer numero, Editora editora,Double valor, Boolean alugado) {
		super(nome, tipo, valor,  alugado);
		this.id = id;
		this.numero = numero;
		this.editora = editora;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}

	@Override
	public String toString() {
		return "Revista [id=" + id + ", numero=" + numero + ", editora=" + editora + ", nome=" + nome + ", tipo=" + tipo
				+ ", valor=" + valor + ", alugado=" + alugado + "]";
	}

	

}
