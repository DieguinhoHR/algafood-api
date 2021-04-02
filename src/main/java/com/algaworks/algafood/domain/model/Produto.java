package com.algaworks.algafood.domain.model;

import java.math.BigDecimal;

import javax.persistence.*;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Produto {

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	private String descricao;

	@Column(nullable = false)
	private BigDecimal preco;

	@Column(nullable = false)
	private boolean ativo;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Restaurante restaurante;
}
