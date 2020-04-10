package br.unisinos.bd2.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SECAO")

public class Secao {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_Secao")
	@SequenceGenerator(name = "seq_Secao", sequenceName = "s_Secao", allocationSize = 1)
	private Long id;
}
