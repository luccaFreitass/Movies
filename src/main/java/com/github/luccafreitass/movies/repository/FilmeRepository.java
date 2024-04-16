package com.github.luccafreitass.movies.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.luccafreitass.movies.model.Filme;

public interface FilmeRepository extends JpaRepository<Filme, Long> {
	List<Filme> findTop5ByOrderByAvaliacaoDesc();

	Optional<Filme> findByTitulo(String titulo);

}
