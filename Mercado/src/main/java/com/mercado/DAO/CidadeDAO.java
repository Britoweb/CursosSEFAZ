package com.mercado.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.mercado.modelo.Cidade;
import com.mercado.util.HibernateUtil;

public class CidadeDAO extends GenericaDAO<Cidade>{
	
	@SuppressWarnings("unchecked")
	public List<Cidade> buscarPorEstado (Long estadoCodigo){
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {
			Criteria consulta = sessao.createCriteria(Cidade.class);
			consulta.add(Restrictions.eq("estado.codigo", estadoCodigo));
			consulta.addOrder(Order.asc("nome"));
			List<Cidade> resultado = consulta.list();
			return resultado;
		} catch (Exception erro) {
			throw erro;
		} finally {
			sessao.close();
		}
	}

}
