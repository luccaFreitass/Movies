package com.github.luccafreitass.movies.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.luccafreitass.movies.DTO.FilmeResponseDto;
import com.github.luccafreitass.movies.model.Filme;

public interface FilmeRepository extends JpaRepository<Filme, Long> {
	List<Filme> findTop5ByOrderByAvaliacaoDesc();
	Filme findByTitulo(String titulo);
	FilmeResponseDto findDtoById(Long id);
}
