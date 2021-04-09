package com.algaworks.algafood.infrastructure.service;

import java.util.List;

import javax.transaction.Transactional;

import com.algaworks.algafood.domain.exception.RestauranteNaoEncontradoException;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.domain.repository.RestauranteRepository;
import com.algaworks.algafood.domain.service.CadastroCozinhaService;
import com.algaworks.algafood.domain.service.CadastroRestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class CadastroRestauranteServiceImpl implements CadastroRestauranteService {

	private static final String MSG_RESTAURANTE_NAO_ENCONTRADO
		= "Não existe um cadastro de restaurante com código %d";

	@Autowired
	private RestauranteRepository restauranteRepository;

	@Autowired
	private CozinhaRepository cozinhaRepository;

	@Autowired
	private CadastroCozinhaService cadastroCozinhaService;

	@Override
	public List<Restaurante> listar() {
		return this.restauranteRepository.findAll();
	}

	@Override
	@Transactional
	public Restaurante salvar(Restaurante restaurante) {
		Long cozinhaId = restaurante.getCozinha().getId();

		Cozinha cozinha = this.cadastroCozinhaService.buscarOuFalhar(cozinhaId);

		restaurante.setCozinha(cozinha);

		return this.restauranteRepository.save(restaurante);
	}

	@Transactional
	public void excluir(Long restauranteId) {
		try {
			this.restauranteRepository.deleteById(restauranteId);
			this.restauranteRepository.flush();
		} catch (EmptyResultDataAccessException e) {
			throw new RestauranteNaoEncontradoException(
				String.format(MSG_RESTAURANTE_NAO_ENCONTRADO, restauranteId));
		}
	}

	public Restaurante buscarOuFalhar(Long restauranteId) {
		return restauranteRepository.findById(restauranteId)
			.orElseThrow(() -> new RestauranteNaoEncontradoException(restauranteId));
	}
}
