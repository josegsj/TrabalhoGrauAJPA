package br.unisinos.bd2.model;

import java.text.ParseException;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
//import javax.persistence.TypedQuery;
import javax.persistence.TypedQuery;

//import br.com.bd2.model.AcessoSistema;
//import br.com.bd2.model.BeneficiosColaboradores;
//import br.com.bd2.model.Beneficio;
//import br.com.bd2.model.Colaborador;
//import br.com.bd2.model.DependenteColaborador;
//import utility.Conversor;



public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev2");
		EntityManager em = emf.createEntityManager();

		System.out.println("teste new 2");
	}

}
