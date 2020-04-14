package br.unisinos.bd2.model;

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

@Entity
@Table(name = "SECAO")

public class Secao {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_Secao")
	@SequenceGenerator(name = "seq_Secao", sequenceName = "s_Secao", allocationSize = 1)
	@Column(name = "codigo_secao")
	private Long codigoSecao;
	
	@Column(length=50, nullable = false)
	private String nome;
	
	@OneToMany(mappedBy= "secao")
	private List<Categoria> categoria;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "codigo_departamento", foreignKey = @ForeignKey(name = "fk_secao_departamento"))
	private Departamento departamento;
}
