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
		
		
		Conta conta = new Conta();
		conta.setId(2);
		
		//namedQuery
		TypedQuery<Double> typedQuery = em.createNamedQuery("getMediasPorDiaETipo", Double.class);
		typedQuery.setParameter("pConta", conta);
		typedQuery.setParameter("pTipo", TipoMovimentacao.SAIDA);
	
		//DAO
		//MovimentacaoDao dao = new MovimentacaoDao(em);
		//dao .getMediasPorDiaETipo(TipoMovimentacao.SAIDA, conta);
		
		List<Double> medias = typedQuery.getResultList();
		
		for (Double media : medias) {
			System.out.println("media = " + media);
		}
		
	}

}



