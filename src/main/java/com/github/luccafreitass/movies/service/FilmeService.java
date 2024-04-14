package com.github.luccafreitass.movies.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.luccafreitass.movies.DTO.FilmeResponseDto;
import com.github.luccafreitass.movies.model.Filme;
import com.github.luccafreitass.movies.principal.Principal;
import com.github.luccafreitass.movies.repository.FilmeRepository;


@Service
public class FilmeService {

    @Autowired
	private Principal principal;
	
	@Autowired
	private FilmeRepository repositorio;

	public List<FilmeResponseDto> obterTodosFilmes() {

		return converteDados(repositorio.findAll());
	}

	private List<FilmeResponseDto> converteDados(List<Filme> filmes) {
    	   return filmes.stream()
                 .map(f -> new FilmeResponseDto(f.getTitulo(),f.getAnoLancamento(),f.getDuracao(),f.getGenero(),f.getAvaliacao(),f.getPoster()))
                 .collect(Collectors.toList());
}

	public FilmeResponseDto obterPorId(Long id) {
    	FilmeResponseDto filme = repositorio.findDtoById(id);
    	if (filme == null) {
        	throw new RuntimeException("Not found with " + id);
    	}
    	return filme;
	}

	/*public FilmeResponseDto buscarPorNome(String nomeFilme) {
		String nome = principal.buscarFilme(nomeFilme).getTitulo();
	}*/

}
