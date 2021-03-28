package com.algaworks.algafood.domain.model;

import javax.persistence.*;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Cozinha {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
}
