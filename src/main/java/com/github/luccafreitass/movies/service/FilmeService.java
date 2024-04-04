package com.github.luccafreitass.movies.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.luccafreitass.movies.DTO.FilmeDTO;
import com.github.luccafreitass.movies.model.Filme;
import com.github.luccafreitass.movies.repository.FilmeRepository;

@Service
public class FilmeService {

	@Autowired
	private FilmeRepository repositorio;

	public List<FilmeDTO> obterTodosFilmes() {

		return converteDados(repositorio.findAll());
	}

	private List<FilmeDTO> converteDados(List<Filme> filmes) {

		return filmes.stream()
				.map(f -> new FilmeDTO(f.getId(), f.getTitulo(), f.getAnoLancamento(), f.getDuracao(), f.getGenero(), f.getAvaliacao(), f.getPoster()))
				.collect(Collectors.toList());
	}

}
