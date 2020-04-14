package br.unisinos.bd2.model;
import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(of = "id") @Entity
@Table(name = "loja_departamento", uniqueConstraints = @UniqueConstraint(name = "uk_lojaDepartamento", columnNames = {"codigo_departamento", "codigo_loja", "codigo_empresa"}))

public class LojaDepartamento implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Getter @Setter
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "s_LojaDepartamento")
	@SequenceGenerator(name = "s_LojaDepartamento", sequenceName = "s_LojaDepartamento", allocationSize = 1)
	private Long id;

	@ManyToOne(optional = false, cascade = {CascadeType.ALL})
	@JoinColumn(name = "codigo_departamento", foreignKey = @ForeignKey(name = "fk_loja_departamento_departamento"))
	private Departamento departamento;

	@ManyToOne(optional = false, cascade = {CascadeType.ALL})
	@JoinColumn(name = "codigo_loja", foreignKey = @ForeignKey(name = "fk_loja_departamento_loja"))
	private Loja loja;
	
	@ManyToOne(optional = false, cascade = {CascadeType.ALL})
	@JoinColumn(name = "codigo_empresa", foreignKey = @ForeignKey(name = "fk_loja_departamento_empresa"))
	private Empresa empresa;
}
