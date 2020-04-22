package br.unisinos.bd2.app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {
	public static void main(String[] args) {
		System.out.println("teste");
		
		// TODO Auto-generated method stub
		//System.out.println();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev2");
		EntityManager em = emf.createEntityManager();

		System.out.println("on App");
	}
}
