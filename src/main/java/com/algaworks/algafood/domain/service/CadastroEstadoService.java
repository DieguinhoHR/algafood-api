package com.algaworks.algafood.domain.service;

import java.util.List;

import com.algaworks.algafood.domain.model.Estado;

public interface CadastroEstadoService {

	List<Estado> listar();
	Estado salvar(Estado estado);
	void excluir(Long estadoId);
	Estado buscarOuFalhar(Long cozinhaId);
}
