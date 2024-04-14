package com.github.luccafreitass.movies.model;

import com.github.luccafreitass.movies.DTO.FilmeResponseDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.*;

@Entity
@Table(name = "Filmes")
public class Filme {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(unique = true)
	private String titulo;
	private String anoLancamento;
	private String duracao;
	private String genero;
	private String avaliacao;
	private String poster;

	public Filme(FilmeResponseDto filmeResponseDto) {
		this.titulo = filmeResponseDto.getTitulo();
		this.anoLancamento = filmeResponseDto.getAnoLancamento();
		this.duracao = filmeResponseDto.getDuracao();
		this.genero = filmeResponseDto.getGenero();
		this.avaliacao = filmeResponseDto.getAvaliacao();
		this.poster = filmeResponseDto.getPoster();
	}

	public Filme() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(String avaliacao) {
		this.avaliacao = avaliacao;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}
}
