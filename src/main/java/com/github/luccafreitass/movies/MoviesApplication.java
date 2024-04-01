package com.github.luccafreitass.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.github.luccafreitass.movies.principal.Principal;
import com.github.luccafreitass.movies.repository.FilmeRepository;

@SpringBootApplication
public class MoviesApplication implements CommandLineRunner {
	
	@Autowired
    private FilmeRepository repositorio;
	
	

	public static void main(String[] args) {
		SpringApplication.run(MoviesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(repositorio);
		principal.exibeMenu();
	}
}
