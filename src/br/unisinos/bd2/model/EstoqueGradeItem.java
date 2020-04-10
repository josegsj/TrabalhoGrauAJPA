package br.unisinos.bd2.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ESTOQUE_GRADE_ITEM")
public class EstoqueGradeItem {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_EstoqueGradeItem")
	@SequenceGenerator(name = "seq_EstoqueGradeItem", sequenceName = "s_EstoqueGradeItem", allocationSize = 1)
	private Long codigoEstoqueGradeItem;
	
	@ManyToOne(optional = false, cascade = {CascadeType.ALL})
	@JoinColumn(name = "codigoGradeItem")
	private GradeItem gradeItem;
}
