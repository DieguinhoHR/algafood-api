package com.algaworks.algafood.domain.model;

import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Restaurante {

	@Id
	private Long id;
	private String nome;

	@Column(name = "taxaFrete")
	private BigDecimal taxaFrete;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getTaxaFrete() {
		return taxaFrete;
	}

	public void setTaxaFrete(BigDecimal taxaFrete) {
		this.taxaFrete = taxaFrete;
	}

	@Override public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Restaurante that = (Restaurante) o;
		return id.equals(that.id);
	}

	@Override public int hashCode() {
		return Objects.hash(id);
	}
}
