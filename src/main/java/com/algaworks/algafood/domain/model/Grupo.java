package com.algaworks.algafood.domain.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Grupo {

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String nome;

	@ManyToMany
	@JoinTable(name = "grupo_permissao",
		joinColumns = @JoinColumn(name = "grupo_id"),
		inverseJoinColumns = @JoinColumn(name = "permissao_id"))
	private List<Permissao> permissoes = new ArrayList<>();
}
