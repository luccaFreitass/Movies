package com.github.luccafreitass.movies.service;

import com.github.luccafreitass.movies.DTO.FilmeResponseDto;
import com.github.luccafreitass.movies.model.Filme;
import com.github.luccafreitass.movies.principal.Principal;
import com.github.luccafreitass.movies.repository.FilmeRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FilmeService {

	@Autowired
	private Principal principal;
	@Autowired
	private FilmeRepository repositorio;

	public List<Filme> obterTodosFilmes() {
		return repositorio.findAll();
	}

	private List<FilmeResponseDto> converteDados(List<Filme> filmes) {
		return filmes.stream().map(f -> new FilmeResponseDto(f.getTitulo(), f.getAnoLancamento(), f.getDuracao(),
				f.getGenero(), f.getAvaliacao(), f.getPoster())).collect(Collectors.toList());
	}

	public FilmeResponseDto obterPorId(Long id) {
		Optional<Filme> optionalFilme = repositorio.findById(id);
		Filme filme = optionalFilme.orElseThrow(() -> new RuntimeException("Filme not found with ID: " + id));

		return new FilmeResponseDto(filme.getTitulo(), filme.getAnoLancamento(), filme.getDuracao(), filme.getGenero(),
				filme.getAvaliacao(), filme.getPoster());
	}

	public FilmeResponseDto salvarFilme(String nome) {
		return principal.buscarFilme(nome);
	}

}
