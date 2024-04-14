package com.github.luccafreitass.movies.controller;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.luccafreitass.movies.DTO.FilmeResponseDto;
import com.github.luccafreitass.movies.service.FilmeService;

@RestController
@RequestMapping("/filmes")
@RequiredArgsConstructor
public class FilmeController {

	private final FilmeService service;

	@GetMapping
	public List<FilmeResponseDto> obterFilmes() {
		return service.obterTodosFilmes();
	}

	@GetMapping("/{id}")
	public FilmeResponseDto obterPorId(@PathVariable Long id){
		    return service.obterPorId(id);
	}
}
