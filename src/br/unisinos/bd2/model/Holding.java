package br.unisinos.bd2.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table(name = "HOLDING")
public class Holding implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_Holding")
	@SequenceGenerator(name = "seq_Holding", sequenceName = "s_Holding", allocationSize = 1)
	@Column(name = "codigo_holding")
	private Long codigoHolding;
	
	@Column(length=50, nullable = false)
	private String nome;
	
	@OneToMany(mappedBy= "holding")
	private List<Empresa> empresa;
}
