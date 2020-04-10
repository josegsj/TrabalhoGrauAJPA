package br.unisinos.bd2.model;

import java.io.Serializable;
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
@Table(name = "CATEGORIA")

public class Categoria implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_Categoria")
	@SequenceGenerator(name = "seq_Categoria", sequenceName = "s_Categoria", allocationSize = 1)
	private Long codigoCategoria;

	@Column(length=50, unique=true, nullable = false)
	private String nome;
	
	@ManyToOne(optional = false, cascade = {CascadeType.ALL})
	@JoinColumn(name = "codigoSecao")
	private Secao secao;

	@OneToMany(mappedBy= "categoria")
	private List<Produto> produtos;
}
