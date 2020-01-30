package br.com.caelum.financas.teste;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Categoria;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteMovimentacaoCategoria {

	public static void main(String[] args) {
		
		  EntityManager em = new JPAUtil().getEntityManager();
		
		Categoria categoria1 = new Categoria("Viagem");
		Categoria categoria2 = new Categoria("negocios");
		
		Conta conta = em.find(Conta.class, 1);
			
		
		
		Movimentacao movimentacao1 = new Movimentacao();
		movimentacao1.setData(Calendar.getInstance());
		movimentacao1.setDescricao("viagem a sp");
		movimentacao1.setTipo(TipoMovimentacao.SAIDA);
		movimentacao1.setValor(new BigDecimal("200.0"));
		movimentacao1.setCategoria(Arrays.asList(categoria1,categoria2));
		
		movimentacao1.setConta(conta);
		
		Movimentacao movimentacao2 = new Movimentacao();
		movimentacao2.setData(Calendar.getInstance());
		movimentacao2.setDescricao("viagem ao rj");
		movimentacao2.setTipo(TipoMovimentacao.SAIDA);
		movimentacao2.setValor(new BigDecimal("300.0"));
		movimentacao2.setCategoria(Arrays.asList(categoria1,categoria2));
		
		movimentacao2.setConta(conta);
		
		
	        em.getTransaction().begin();

	        em.persist(categoria1); // Agora a 'categoria1' é Managed
	        em.persist(categoria2);
	        
	        em.persist(conta);
	        
	        em.persist(movimentacao1);
	        em.persist(movimentacao2);

	        em.getTransaction().commit();    
	        em.close();    	
		
	}
}
