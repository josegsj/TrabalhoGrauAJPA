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
@Table(name = "DEPARTAMENTO")
public class Departamento {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_Departamento")
	@SequenceGenerator(name = "seq_Departamento", sequenceName = "s_Departamento", allocationSize = 1)
	private Long codigoDepartamento;
	
	@Column(length=50, unique=true, nullable = false)
	private String nome;
	
	@OneToMany(mappedBy= "departamento")
	private List<Secao> secao;
}
