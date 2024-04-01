package com.github.luccafreitass.movies.service;

public interface IConverteDados {
	<T> T obterDados(String json, Class<T> classe);
}
