package br.unisinos.bd2.model;

import java.sql.Date;
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
@Table(name = "LOJA")
public class Loja {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_Loja")
	@SequenceGenerator(name = "seq_Loja", sequenceName = "s_Loja", allocationSize = 1)
	private Long codigoLoja;
	
	@ManyToOne(optional = false, cascade = {CascadeType.ALL})
	@JoinColumn(name = "codigoEmpresa")
	private Empresa empresa;
	
	@OneToMany(mappedBy= "loja")
	private List<LojaDepartamento> lojaDepartamento;
		
	@OneToMany(mappedBy= "loja")
	private List<EstoqueGradeItem> estoqueGradeItem;
	
	@Column(length=50, unique=true, nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private Integer nroFuncionario;
	
	@Column(nullable = false)
	private Date dataAbertura;
	
}
