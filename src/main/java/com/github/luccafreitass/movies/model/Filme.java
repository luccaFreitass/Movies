package com.github.luccafreitass.movies.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Filmes")
public class Filme {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(unique = true)
	private String titulo;
	private String anoLancamento;
	private String duracao;
	private String genero;

	public Filme() {
	}

	public Filme(DadosFilme dados) {
		this.titulo = dados.titulo();
		this.anoLancamento = dados.anoLancamento();
		this.duracao = dados.duracao();
		this.genero = dados.genero();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAnoLancamento() {
		return anoLancamento;
	}

	public void setAnoLancamento(String anoLancamento) {
		this.anoLancamento = anoLancamento;
	}

	public String getDuracao() {
		return duracao;
	}

	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	@Override
	public String toString() {
		return "Titulo: " + titulo + "\nAno De Lancamento: " + anoLancamento + "\nDuracao: " + duracao
				+ "\nGenero: " + genero + "\n\n";
	}

}