package com.github.luccafreitass.movies.principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Component;

import com.github.luccafreitass.movies.model.DadosFilme;
import com.github.luccafreitass.movies.model.Filme;
import com.github.luccafreitass.movies.repository.FilmeRepository;
import com.github.luccafreitass.movies.service.ConsumoApi;
import com.github.luccafreitass.movies.service.ConverteDados;

@Component
public class Principal {

	private final String ENDERECO = "https://www.omdbapi.com/?t=";
	private final String API_KEY = "&apikey=6585022c";

	private ConsumoApi consumo = new ConsumoApi();
	private ConverteDados conversor = new ConverteDados();

	private Scanner in = new Scanner(System.in);

	private final FilmeRepository repositorio;
	private List<Filme> filmes = new ArrayList<>();

	public Principal(FilmeRepository repositorio) {
		this.repositorio = repositorio;
	}

	public void exibeMenu() {
		int escolha = -1;
		while (escolha != 0) {
			String menu = """
					1 - Buscar filme
					2 - Listar filmes
					3 - Top5 Filmes


					0 - Sair
					""";
			System.out.println(menu);
			escolha = in.nextInt();
			in.nextLine();

			switch (escolha) {
			case 1:
				buscarFilme();
				break;
			case 2:
				listarFilmes();
				break;
			case 3:

				break;
			default:
				System.out.println("Opcao invalida");
				break;
			}
		}
	}

	private void listarFilmes() {
		filmes = repositorio.findAll();
		filmes.stream().forEach(System.out::println);
	}

	private DadosFilme getDadosFilme() {
		System.out.println("Digite o nome do filme para busca");
		var nomeSerie = in.nextLine();
		var json = consumo.obterDados(ENDERECO + nomeSerie.replace(" ", "+") + API_KEY);
		DadosFilme dados = conversor.obterDados(json, DadosFilme.class);
		return dados;
	}

	private void buscarFilme() {
		DadosFilme dados = getDadosFilme();

		if (dados != null) {
			Filme filme = new Filme(dados);
			System.out.println("Título do filme: " + filme.getTitulo());
			System.out.println(dados);
			repositorio.save(filme);
		} else {
			System.out.println("Não foi possível obter os dados do filme.");
		}
	}

}
