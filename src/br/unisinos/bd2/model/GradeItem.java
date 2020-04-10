package br.unisinos.bd2.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "GRADE_ITEM")
public class GradeItem {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_Grade_item")
	@SequenceGenerator(name = "seq_Grade_item", sequenceName = "s_Grade_item", allocationSize = 1)
	private Long codigoGradeItem;
	
	@Column(length=50, unique=true, nullable = false)
	private String nome;
	
	@ManyToOne(optional = false, cascade = {CascadeType.ALL})
	@JoinColumn(name = "codigoGrade")
	private Grade grade;
	
	@ManyToOne(optional = false, cascade = {CascadeType.ALL})
	@JoinColumn(name = "codigoCor")
	private Cor cor;
	
	@ManyToOne(optional = false, cascade = {CascadeType.ALL})
	@JoinColumn(name = "codigoTamanho")
	private Tamanho tamanho;
	
	@OneToMany(mappedBy= "gradeItem")
	private List<EstoqueGradeItem> estoqueGradeItem;
}
