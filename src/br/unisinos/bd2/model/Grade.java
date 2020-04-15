package br.unisinos.bd2.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table(name = "GRADE")
public class Grade implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_Grade")
	@SequenceGenerator(name = "seq_Grade", sequenceName = "s_Grade", allocationSize = 1)
	@Column(name = "codigo_grade")
	private Long codigoGrade;
	
	@Column(length=50, unique=true, nullable = false)
	private String nome;
	
	@OneToMany(mappedBy= "grade")
	private List<Produto> produtos;
	
	@OneToMany(mappedBy= "grade")
	private List<GradeItem> gradeItem;
	
}

