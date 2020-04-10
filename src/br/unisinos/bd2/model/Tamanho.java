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
@Table(name = "TAMANHO")
public class Tamanho {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_Tamanho")
	@SequenceGenerator(name = "seq_Tamanho", sequenceName = "s_Tamanho", allocationSize = 1)
	private Long codigoTamanho;
	
	@Column(length=50, unique=true, nullable = false)
	private String nome;
	
	@OneToMany(mappedBy= "tamanho")
	private List<GradeItem> gradeItem;
}
