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
@Table(name = "EMPRESA")
public class Empresa {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_Empresa")
	@SequenceGenerator(name = "seq_Empresa", sequenceName = "s_Empresa", allocationSize = 1)
	private Long codigoEmpresa;
	
	@OneToMany(mappedBy= "empresa")
	private List<Loja> loja;
	
	@Column(length=50, unique=true, nullable = false)
	private String razaoSocial;
	
	@Column(length=50, unique=true, nullable = false)
	private String fantasia;
	
	@Column(length=50, unique=true, nullable = false)
	private String logradouro;
	
	@ManyToOne(optional = false, cascade = {CascadeType.ALL})
	@JoinColumn(name = "codigoHolding")
	private Holding holding;
}
