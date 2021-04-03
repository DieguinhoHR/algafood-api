package com.algaworks.algafood.domain.service;

import java.util.List;

import com.algaworks.algafood.domain.model.Cidade;

public interface CadastroCidadeService {

	List<Cidade> listar();
	Cidade salvar(Cidade cozinha);
	void excluir(Long id);
	Cidade buscarOuFalhar(Long cidadeId);
}
