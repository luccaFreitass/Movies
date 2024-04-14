package com.github.luccafreitass.movies.DTO;

import com.github.luccafreitass.movies.model.DadosFilme;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FilmeResponseDto {
    private String titulo;
    private String anoLancamento;
    private String duracao;
    private String genero;
    private String avaliacao;
    private String poster;

    public FilmeResponseDto(DadosFilme dados) {
        this.titulo = dados.titulo();
        this.anoLancamento = dados.anoLancamento();
        this.duracao = dados.duracao();
        this.genero = dados.genero();
        this.avaliacao = dados.avaliacao();
        this.poster = dados.poster();
    }

}
