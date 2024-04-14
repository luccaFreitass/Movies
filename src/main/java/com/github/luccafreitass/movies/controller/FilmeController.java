package com.github.luccafreitass.movies.controller;

import com.github.luccafreitass.movies.DTO.FilmeRequestDto;
import com.github.luccafreitass.movies.DTO.FilmeResponseDto;
import com.github.luccafreitass.movies.model.Filme;
import com.github.luccafreitass.movies.service.FilmeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filmes")
@RequiredArgsConstructor
public class FilmeController {

	private final FilmeService service;

	@GetMapping
	public List<Filme> obterFilmes() {
		return service.obterTodosFilmes();
	}

	@GetMapping("/{id}")
	public FilmeResponseDto obterPorId(@PathVariable Long id){
		    return service.obterPorId(id);
	}

	@PostMapping
	public FilmeResponseDto salvarFilme(@RequestBody FilmeRequestDto requestDto) {
		return service.salvarFilme(requestDto.nome());
	}
}
