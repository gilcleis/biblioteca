package com.gilclei.biblioteca.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medias")
public abstract class Media  implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 100, nullable = false)
	protected String nome;
	protected String tipo;
	protected Double valor;
	protected Boolean alugado;
	
	public Media() {}
	
	public Media(String nome, String tipo) {
		this.nome = nome;
		this.tipo = tipo;
	}
	
	public Media(String nome, String tipo,Boolean alugado) {
		this.nome = nome;
		this.tipo = tipo;
		this.alugado = alugado;
	}
	
	
	
	public Media(String nome, String tipo, Double valor, Boolean alugado) {
		this.nome = nome;
		this.tipo = tipo;
		this.valor = valor;
		this.alugado = alugado;
	}

	public String getNome() {
		return nome;
	}
	
	public String getTipo() {
		return tipo;
	}

	@Override
	public String toString() {
		return "Media [id=" + id + ", nome=" + nome + ", tipo=" + tipo + ", valor=" + valor + ", alugado=" + alugado
				+ "]";
	}
	
	
}
