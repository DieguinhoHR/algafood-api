package com.algaworks.algafood.core.jackson;

import com.algaworks.algafood.domain.model.Cidade;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.api.model.mixin.CidadeMixin;
import com.algaworks.algafood.api.model.mixin.CozinhaMixin;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.stereotype.Component;

@Component
public class JacksonMixinModule extends SimpleModule {

	public JacksonMixinModule() {
		// Digo que a classe restaurante tem uma classe mixin
		setMixInAnnotation(Cidade.class, CidadeMixin.class);
		setMixInAnnotation(Cozinha.class, CozinhaMixin.class);
	}
}
