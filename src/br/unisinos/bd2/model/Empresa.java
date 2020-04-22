package br.unisinos.bd2.model;

import java.io.Serializable;
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
@Table(name = "EMPRESA")
public class Empresa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_Empresa")
	@SequenceGenerator(name = "seq_Empresa", sequenceName = "s_Empresa", allocationSize = 1)
	@Column(name = "codigo_empresa")
	private Long codigoEmpresa;
	
	@OneToMany(mappedBy= "empresa")
	private List<Loja> loja;
	
	@Column(name="razao_social",length=50, nullable = false)
	private String razaoSocial;
	
	@Column(length=50, nullable = false)
	private String fantasia;
	
	@Column(length=50, nullable = false)
	private String logradouro;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "codigoHolding", foreignKey = @ForeignKey(name = "fk_empresa_holding"))
	private Holding holding;
}
