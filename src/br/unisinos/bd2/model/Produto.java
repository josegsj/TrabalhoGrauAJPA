package br.unisinos.bd2.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table(name = "PRODUTO")
public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_Produto")
	@SequenceGenerator(name = "seq_Produto", sequenceName = "s_Produto", allocationSize = 1)
	@Column(name = "codigo_produto")
	private Long codigoProduto;
	
	@Column(length=50, nullable = false)
	private String nome;

	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "codigo_categoria", foreignKey = @ForeignKey(name = "fk_produto_categoria"))
	private Categoria categoria;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "codigo_grade", foreignKey = @ForeignKey(name = "fk_produto_grade"))
	private Grade grade;
	
	@Column(name = "estoque_atual", nullable = false)
	private Integer estoqueAtual;
	
	@Column(name = "estoque_minimo", nullable = false)
	private Integer estoqueMinimo;
}
