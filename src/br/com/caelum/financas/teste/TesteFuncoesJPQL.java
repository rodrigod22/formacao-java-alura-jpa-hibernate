package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteFuncoesJPQL {

	public static void main(String[] args) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
		Conta conta = new Conta();
		conta.setId(2);
		
		//funcoes: sum = soma -- avg = media 		
//		String jpql = "select avg(m.valor) from Movimentacao m where m.conta = :pConta " +
//				 "and m.tipo = :pTipo " +
//				 "order by m.valor asc";
		
		
		String jpql = "select avg(m.valor) from Movimentacao m where m.conta = :pConta " +
				 "and m.tipo = :pTipo " 
				+"group by day(m.data), month(m.data), year(m.data)";
		
		TypedQuery<Double> query = em.createQuery(jpql, Double.class);
		
		//comparando as contas como objeto passando a conta como parametro na requisicao 
		query.setParameter("pConta", conta);
		query.setParameter("pTipo", TipoMovimentacao.SAIDA);
		List<Double> medias = (List<Double>) query.getResultList();
		em.getTransaction().commit();
		em.close();
		
		System.out.println("media dia 30 = " + medias.get(0));
		System.out.println("media dia 31 = " + medias.get(1));

	}

}
