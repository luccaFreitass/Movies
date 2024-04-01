package com.github.luccafreitass.movies.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.luccafreitass.movies.model.Filme;

public interface FilmeRepository extends JpaRepository<Filme, Long>{

	

}
