package com.algaworks.algafood.domain.service;

import java.util.List;

import com.algaworks.algafood.domain.model.Cozinha;

public interface CadastroCozinhaService {

	List<Cozinha> listar();
	Cozinha salvar(Cozinha cozinha);
	void excluir(Long id);
	Cozinha buscarOuFalhar(Long cozinhaId);
}
