package br.unisinos.bd2.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "COR")
public class Cor {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_Cor")
	@SequenceGenerator(name = "seq_Cor", sequenceName = "s_Cor", allocationSize = 1)
	private Long codigoCor;
	
	@Column(length=50, unique=true, nullable = false)
	private String nome;
	
	@OneToMany(mappedBy= "cor")
	private List<GradeItem> gradeItem;
}
