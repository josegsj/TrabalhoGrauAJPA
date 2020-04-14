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
@Table(name = "LOJA_DEPARTAMENTO")
public class LojaDepartamento {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_LojaDepartamento")
	@SequenceGenerator(name = "seq_LojaDepartamento", sequenceName = "s_LojaDepartamento", allocationSize = 1)
	private Long codigoLojaDepartamento;
	
	@ManyToOne(optional = false, cascade = {CascadeType.ALL})
	@JoinColumn(name = "codigoEmpresa")
	private Empresa empresa;
	
	@ManyToOne(optional = false, cascade = {CascadeType.ALL})
	@JoinColumn(name = "codigoLoja")
	private Loja loja;
	
	@ManyToOne(optional = false, cascade = {CascadeType.ALL})
	@JoinColumn(name = "codigoDepartamento")
	private Departamento departamento;
}
