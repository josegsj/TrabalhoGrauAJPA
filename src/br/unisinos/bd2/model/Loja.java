package br.unisinos.bd2.model;

import java.io.Serializable;
import java.sql.Date;
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

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table(name = "LOJA")
public class Loja implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_Loja")
	@SequenceGenerator(name = "seq_Loja", sequenceName = "s_Loja", allocationSize = 1)
	@Column(name = "codigo_loja")
	private Long codigoLoja;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "codigo_empresa", foreignKey = @ForeignKey(name = "fk_loja_empresa"))
	private Empresa empresa;
	
	@Column(length=50, nullable = false)
	private String nome;
		
	@Column(name = "data_abertura", nullable = false)
	private Date dataAbertura;
	
	@Column(name = "nro_funcionario", nullable = false)
	private Integer nroFuncionario;
	
	@OneToMany(mappedBy= "loja")
	private List<LojaDepartamento> lojaDepartamento;
	
	@OneToMany(mappedBy= "loja")
	private List<EstoqueGradeItem> estoqueGradeItem;
}
