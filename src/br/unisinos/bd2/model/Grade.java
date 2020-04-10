package br.unisinos.bd2.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "GRADE")
public class Grade {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_Grade")
	@SequenceGenerator(name = "seq_Grade", sequenceName = "s_Grade", allocationSize = 1)
	private Long id;
}
