package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.financas.modelo.Conta;

public class TesteContas {

	public static void main(String[] args) {

		Conta conta = new Conta();
		conta.setAgencia("1604");
		conta.setBanco("Itau");
		conta.setTitular("Rodrigo");
		conta.setNumero("15261-5");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("financas");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(conta);
	
		em.getTransaction().commit();
		em.close();
		emf.close();
		
	}

}
