package com.algaworks.algafood.domain.service;

import java.util.List;

import com.algaworks.algafood.domain.model.Restaurante;

public interface CadastroRestauranteService {

	List<Restaurante> listar();
	Restaurante salvar(Restaurante cozinha);
	void excluir(Long id);
	Restaurante buscarOuFalhar(Long cidadeId);
	void ativar(Long restauranteId);
	void inativar(Long restauranteId);
}
