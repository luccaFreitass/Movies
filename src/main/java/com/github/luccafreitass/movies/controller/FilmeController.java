package com.github.luccafreitass.movies.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.luccafreitass.movies.DTO.FilmeDTO;
import com.github.luccafreitass.movies.service.FilmeService;

@RestController
@RequestMapping("/filmes")
public class FilmeController {
	
	@Autowired
	private FilmeService service;
	
	@GetMapping
	public List<FilmeDTO> obterFilmes(){
		return service.obterTodosFilmes();
	}

}
