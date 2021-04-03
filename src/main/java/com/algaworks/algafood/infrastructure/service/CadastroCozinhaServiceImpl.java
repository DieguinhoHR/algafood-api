package com.algaworks.algafood.infrastructure.service;

import java.util.List;

import javax.transaction.Transactional;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.domain.service.CadastroCozinhaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class CadastroCozinhaServiceImpl implements CadastroCozinhaService {

	private static final String MSG_COZINHA_NAO_ENCONTRADA
		= "Não existe um cadastro de cozinha com código %d";
	private static final String MSG_COZINHA_EM_USO
		= "Cozinha de código %d não pode ser removida, pois está em uso";

	@Autowired
	private CozinhaRepository cozinhaRepository;

	@Override
	public List<Cozinha> listar() {
		return this.cozinhaRepository.findAll();
	}

	@Transactional
	@Override
	public Cozinha salvar(Cozinha cozinha) {
		return this.cozinhaRepository.save(cozinha);
	}

	@Transactional
	@Override
	public void excluir(Long cozinhaId) {
		try {
			this.cozinhaRepository.deleteById(cozinhaId);

		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(
				String.format(MSG_COZINHA_NAO_ENCONTRADA, cozinhaId));

		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
				String.format(MSG_COZINHA_EM_USO, cozinhaId));
		}
	}

	@Override
	public Cozinha buscarOuFalhar(Long cozinhaId) {
		return this.cozinhaRepository.findById(cozinhaId)
			.orElseThrow(() -> new EntidadeNaoEncontradaException(
				String.format(MSG_COZINHA_NAO_ENCONTRADA, cozinhaId)));
	}
}
