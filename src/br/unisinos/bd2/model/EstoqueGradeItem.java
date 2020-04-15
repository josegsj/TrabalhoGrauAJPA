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
@Table(name = "ESTOQUE_GRADE_ITEM")
public class EstoqueGradeItem implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_EstoqueGradeItem")
	@SequenceGenerator(name = "seq_EstoqueGradeItem", sequenceName = "s_EstoqueGradeItem", allocationSize = 1)
	@Column(name = "codigo_estoque_grade_item")
	private Long codigoEstoqueGradeItem;
	
	@ManyToOne(optional = false, cascade = {CascadeType.ALL})
	@JoinColumn(name = "codigo_grade_item", foreignKey = @ForeignKey(name = "fk_estoque_grade_item_grade_item"))
	private GradeItem gradeItem;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "codigo_produto", foreignKey = @ForeignKey(name = "fk_estoque_grade_item_produto"))
	private Produto produto;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "codigo_empresa", foreignKey = @ForeignKey(name = "fk_estoque_grade_item_empresa"))
	private Empresa empresa;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "codigo_loja", foreignKey = @ForeignKey(name = "fk_estoque_grade_item_loja"))
	private Loja loja;
	
	@Column(name = "estoque_atual", nullable = false)
	private Integer estoqueAtual;
	
	@Column(name = "estoque_minimo", nullable = false)
	private Integer estoqueMinimo;
}
