package com.github.luccafreitass.movies.DTO;

import com.github.luccafreitass.movies.model.DadosFilme;
import com.github.luccafreitass.movies.model.Filme;

import lombok.*;
import lombok.Data;

@Data
@AllArgsConstructor
public class FilmeResponseDto {
    private String titulo;
    private String anoLancamento;
    private String duracao;
    private String genero;
    private String avaliacao;
    private String poster;

    // Constructor accepting individual strings
    public FilmeResponseDto(String titulo, String anoLancamento, String duracao, String genero, String avaliacao, String poster) {
        this.titulo = titulo;
        this.anoLancamento = anoLancamento;
        this.duracao = duracao;
        this.genero = genero;
        this.avaliacao = avaliacao;
        this.poster = poster;
    }

    // Constructor accepting DadosFilme object
    public FilmeResponseDto(DadosFilme dados) {
        this.titulo = dados.titulo();
        this.anoLancamento = dados.anoLancamento();
        this.duracao = dados.duracao();
        this.genero = dados.genero();
        this.avaliacao = dados.avaliacao();
        this.poster = dados.poster();
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
