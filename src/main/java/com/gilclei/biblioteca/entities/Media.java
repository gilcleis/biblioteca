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
public abstract class Media implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 100, nullable = false)
	protected String nome;
	protected String tipo;
	protected Double valor;
	protected Boolean alugado;

	public Media() {
	}

	public Media(String nome, String tipo) {
		this.nome = nome;
		this.tipo = tipo;
	}

	public Media(String nome, String tipo, Boolean alugado) {
		this.nome = nome;
		this.tipo = tipo;
		this.alugado = alugado;
	}

	public Media(Long id,String nome, String tipo, Double valor, Boolean alugado) {
		this.nome = nome;
		this.tipo = tipo;
		this.valor = valor;
		this.alugado = alugado;
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Boolean getAlugado() {
		return alugado;
	}

	public void setAlugado(Boolean alugado) {
		this.alugado = alugado;
	}

	@Override
	public String toString() {
		return "Media [id=" + id + ", nome=" + nome + ", tipo=" + tipo + ", valor=" + valor + ", alugado=" + alugado
				+ "]";
	}

}
