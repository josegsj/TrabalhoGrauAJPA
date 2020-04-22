package br.unisinos.bd2.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table(name = "GRADE_ITEM")
public class GradeItem implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_Grade_item")
	@SequenceGenerator(name = "seq_Grade_item", sequenceName = "s_Grade_item", allocationSize = 1)
	@Column(name = "codigo_grade_item")
	private Long codigoGradeItem;
	
	@Column(length=50, unique=true, nullable = false)
	private String nome;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "codigo_grade", foreignKey = @ForeignKey(name = "fk_grade_item_grade"))
	private Grade grade;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "codigo_cor", foreignKey = @ForeignKey(name = "fk_grade_item_cor"))
	private Cor cor;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "codigo_tamanho", foreignKey = @ForeignKey(name = "fk_grade_item_tamanho"))
	private Tamanho tamanho;
	
	@OneToMany(mappedBy= "gradeItem")
	private List<EstoqueGradeItem> estoqueGradeItem;
}
