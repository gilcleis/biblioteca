package com.gilclei.biblioteca.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "jogos")
public class Jogo extends Media implements Serializable {
	private static final long serialVersionUID = 1L;

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

	public Jogo(Long id, String nome, String tipo, String versao, Boolean digital, Desenvolvedora desenvolvedora,
			Double valor, Boolean alugado) {
		super(id, nome, tipo, valor, alugado);
		this.versao = versao;
		this.digital = digital;
		this.desenvolvedora = desenvolvedora;
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
		return "Jogo [id=" + getId() + ", versao=" + versao + ", digital=" + digital + ", desenvolvedora="
				+ desenvolvedora + ", nome=" + nome + ", tipo=" + tipo + ", valor=" + valor + ", alugado=" + alugado
				+ "]";
	}

}
