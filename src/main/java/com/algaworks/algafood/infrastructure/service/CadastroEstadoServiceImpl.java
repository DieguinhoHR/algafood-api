package com.algaworks.algafood.infrastructure.service;

import java.util.List;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.EstadoRepository;
import com.algaworks.algafood.domain.service.CadastroEstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class CadastroEstadoServiceImpl implements CadastroEstadoService {

	private static final String MSG_ESTADO_EM_USO  =
		"Estado de código %d não pode ser removido, pois está em uso";

	private static final String MSG_ESTADO_NAO_ENCONTRADO =
		"Não existe um cadastro de estado com código %d";

	@Autowired
	private EstadoRepository estadoRepository;

	@Override
	public List<Estado> listar() {
		return this.estadoRepository.findAll();
	}

	@Override
	public Estado buscarOuFalhar(Long cozinhaId) {
		return this.estadoRepository.findById(cozinhaId)
			.orElseThrow(() -> new EntidadeNaoEncontradaException(
				String.format(MSG_ESTADO_NAO_ENCONTRADO, cozinhaId)
			));
	}

	@Override
	public Estado salvar(Estado estado) {
		return this.estadoRepository.save(estado);
	}

	@Override
	public void excluir(Long estadoId) {
		try {
			estadoRepository.deleteById(estadoId);

		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(
				String.format(MSG_ESTADO_NAO_ENCONTRADO, estadoId));

		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
				String.format(MSG_ESTADO_EM_USO, estadoId));
		}
	}
}
