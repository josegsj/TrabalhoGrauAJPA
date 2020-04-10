package br.unisinos.bd2.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUTO")

public class Produto implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_Produto")
	@SequenceGenerator(name = "seq_Produto", sequenceName = "s_Produto", allocationSize = 1)
	private Long codigoProduto;
	
	@Column(length=50, unique=true, nullable = false)
	private String nome;

	@ManyToOne(optional = false, cascade = {CascadeType.ALL})
	@JoinColumn(name = "codigoCategoria")
	private Categoria categoria;
	
	@ManyToOne(optional = false, cascade = {CascadeType.ALL})
	@JoinColumn(name = "codigoGrade")
	private Grade grade;
	
	@Column(nullable = false)
	private Integer estoqueAtual;
	
	@Column(nullable = false)
	private Integer estoqueMinimo;
}
