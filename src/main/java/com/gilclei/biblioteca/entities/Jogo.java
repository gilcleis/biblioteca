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
@Table(name = "jogos")
public class Jogo extends Media implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String versao;
	private Boolean digital;
	
	@ManyToOne
	@JoinColumn(name = "desenvolvedora_id")
	private Desenvolvedora desenvolvedora;

	public Jogo() {
	}

	public Jogo(String nome) {
		super(nome, "Jogo");
		
	} 
	
	public Jogo(Long id,String nome, String tipo,  String versao, Boolean digital, Desenvolvedora desenvolvedora,Double valor, Boolean alugado) {
		super(nome, tipo,valor, alugado);
		this.id = id;
		this.versao = versao;
		this.digital = digital;
		this.desenvolvedora = desenvolvedora;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVersao() {
		return versao;
	}

	public void setVersao(String versao) {
		this.versao = versao;
	}

	public Boolean getDigital() {
		return digital;
	}

	public void setDigital(Boolean digital) {
		this.digital = digital;
	}

	public Desenvolvedora getDesenvolvedora() {
		return desenvolvedora;
	}

	public void setDesenvolvedora(Desenvolvedora desenvolvedora) {
		this.desenvolvedora = desenvolvedora;
	}

	@Override
	public String toString() {
		return "Jogo [id=" + id + ", versao=" + versao + ", digital=" + digital + ", desenvolvedora=" + desenvolvedora
				+ ", nome=" + nome + ", tipo=" + tipo + ", valor=" + valor + ", alugado=" + alugado + "]";
	}

	

}
