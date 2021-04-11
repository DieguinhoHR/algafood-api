package com.algaworks.algafood.domain.service;

import com.algaworks.algafood.domain.model.FormaPagamento;

public interface CadastroFormaPagamentoService {

	FormaPagamento salvar(FormaPagamento cozinha);
	void excluir(Long id);
	FormaPagamento buscarOuFalhar(Long cidadeId);
}
