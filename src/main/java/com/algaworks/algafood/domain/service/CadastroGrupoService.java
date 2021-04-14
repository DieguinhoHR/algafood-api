package com.algaworks.algafood.domain.service;

import com.algaworks.algafood.domain.model.Grupo;

public interface CadastroGrupoService {

	Grupo salvar(Grupo grupo);
    void excluir(Long grupoId);
	Grupo buscarOuFalhar(Long grupoId);
}
