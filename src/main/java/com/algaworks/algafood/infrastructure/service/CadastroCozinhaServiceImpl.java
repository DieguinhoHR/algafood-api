package com.algaworks.algafood.infrastructure.service;

import java.util.List;
import java.util.Optional;

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
			Optional<Cozinha> cozinha = this.cozinhaRepository.findById(cozinhaId);
			this.cozinhaRepository.delete(cozinha.get());
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(
				String.format("Não existe um cadastro de cozinha com código %d", cozinhaId));
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
				String.format("Cozinha de código %d não pode ser removida, pois está em uso", cozinhaId));
		}
	}
}
