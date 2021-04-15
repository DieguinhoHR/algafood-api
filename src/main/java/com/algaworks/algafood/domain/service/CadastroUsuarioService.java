package com.algaworks.algafood.domain.service;

import com.algaworks.algafood.domain.model.Usuario;

public interface CadastroUsuarioService {

	Usuario salvar(Usuario usuario);
	void alterarSenha(Long usuarioId, String senhaAtual, String novaSenha);
	Usuario buscarOuFalhar(Long usuarioId);
}
