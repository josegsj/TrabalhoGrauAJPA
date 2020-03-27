package br.unisinos.bd2.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class Holding {
	
	private Long codigoHolding;
	private String nome;

}
