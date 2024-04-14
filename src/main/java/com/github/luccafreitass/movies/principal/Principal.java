package com.github.luccafreitass.movies.principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.stereotype.Component;

import com.github.luccafreitass.movies.DTO.FilmeResponseDto;
import com.github.luccafreitass.movies.model.DadosFilme;
import com.github.luccafreitass.movies.model.Filme;
import com.github.luccafreitass.movies.repository.FilmeRepository;
import com.github.luccafreitass.movies.service.ConsumoApi;
import com.github.luccafreitass.movies.service.ConverteDados;

@Component
public class Principal {

	private final String ENDERECO = "https://www.omdbapi.com/?t=";
	private final String API_KEY = "&apikey=6585022c";

	private ConsumoApi consumo = new ConsumoApi();
	private ConverteDados conversor = new ConverteDados();

	private Scanner in = new Scanner(System.in);

	private final FilmeRepository repositorio;
	private List<Filme> filmes = new ArrayList<>();

	public Principal(FilmeRepository repositorio) {
		this.repositorio = repositorio;
	}

	private void listarTop5() {
		filmes = repositorio.findTop5ByOrderByAvaliacaoDesc();
		filmes.forEach(System.out::println);
	}

	private void listarFilmes() {
		filmes = repositorio.findAll();
		filmes.stream().forEach(System.out::println);
	}

	public DadosFilme getDadosFilme(String nomeSerie) {
		var json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + API_KEY);
		DadosFilme dados = conversor.obterDados(json, DadosFilme.class);
		return dados;
	}

	public FilmeResponseDto buscarFilme(String nomeSerie) {
		DadosFilme dados = getDadosFilme(nomeSerie);
		FilmeResponseDto dto = new FilmeResponseDto(dados);
		Filme filme = new Filme(dto);

		Optional<Filme> filmeExistente = repositorio.findByTitulo(filme.getTitulo());
		if (filmeExistente.isPresent()) {
			Filme filmeAtualizado = filmeExistente.get();
			filmeAtualizado.setAvaliacao(filme.getAvaliacao());
			filmeAtualizado.setTitulo(filme.getTitulo());
			repositorio.save(filmeAtualizado);
		} else {
			repositorio.save(filme);
		}
		return dto;
	}
}
