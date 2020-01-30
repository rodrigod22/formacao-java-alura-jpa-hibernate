package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteContas {

	public static void main(String[] args) {

		Conta conta = new Conta();
		conta.setAgencia("1604");
		conta.setBanco("Itau");
		conta.setTitular("Rodrigo");
		conta.setNumero("15261-5");
		
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
		em.persist(conta);	
		em.getTransaction().commit();		
		em.close();		
		
		EntityManager em2 = new JPAUtil().getEntityManager();
		em2.getTransaction().begin();

		conta.setTitular("Leonardo");
		//metodo merge tranforma a conta em estado managed
		em2.merge(conta);

		em2.getTransaction().commit();
		em2.close();
	}

}
