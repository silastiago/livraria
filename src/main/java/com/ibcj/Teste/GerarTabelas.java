package com.ibcj.Teste;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GerarTabelas {

	public static void main(String[] args) {
		System.out.println("Abrindo conexao"); 
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("livrariaPU"); 
		System.out.println("Fechando conexao");
		factory.close();
		System.out.println("Conexao Fechada");
	}
}
