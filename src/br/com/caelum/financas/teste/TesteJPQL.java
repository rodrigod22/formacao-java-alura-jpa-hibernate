package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteJPQL {

	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		Conta conta = new Conta();
		conta.setId(1);
		
		String jpql = "select m from Movimentacao m where m.conta = :pConta " +
				 "and m.tipo = :pTipo " +
				 "order by m.valor asc";
		Query query = em.createQuery(jpql);
		
		//comparando as contas como objeto passando a conta como parametro na requisicao 
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", TipoMovimentacao.SAIDA);
		List<Movimentacao> lista = query.getResultList();
		em.getTransaction().commit();
		em.close();
		
		for (Movimentacao movimentacao : lista) {			
			System.out.println(movimentacao.getConta().getId());
			System.out.println(movimentacao.getDescricao());
			System.out.println(movimentacao.getValor());
			
		}

	}

}
