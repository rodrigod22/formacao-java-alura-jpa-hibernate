package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Cliente;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteContaCliente {

	public static void main(String[] args) {
		
		Cliente cliente = new Cliente();
        cliente.setNome("Leonardo");
        cliente.setEndereco("Rua Fulano, 123");
        cliente.setProfissao("Professor");
        
		Cliente cliente2 = new Cliente();
        cliente2.setNome("Rodrigo");
        cliente2.setEndereco("Rua Fulano, 333");
        cliente2.setProfissao("Dev");
        
        Conta conta = new Conta();
        conta.setId(2);
        
        cliente.setConta(conta);
        cliente2.setConta(conta);
        
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();
        
        em.persist(cliente);        
        
        em.getTransaction().commit();        

	}

}
