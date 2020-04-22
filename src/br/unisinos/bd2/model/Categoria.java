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
@Table(name = "CATEGORIA")
public class Categoria implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_Categoria")
	@SequenceGenerator(name = "seq_Categoria", sequenceName = "s_Categoria", allocationSize = 1)
	@Column(name = "codigo_categoria")
	private Long codigoCategoria;

	@Column(length=50, unique=true, nullable = false)
	private String nome;
	
	@ManyToOne(optional = true, cascade = {CascadeType.ALL})
	@JoinColumn(name = "codigo_Secao", foreignKey = @ForeignKey(name = "fk_categoria_secao"))
	private Secao secao;

	@OneToMany(mappedBy= "categoria")
	private List<Produto> produtos;
}
