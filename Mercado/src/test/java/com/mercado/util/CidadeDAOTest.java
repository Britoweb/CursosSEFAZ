package com.mercado.util;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;


import com.mercado.DAO.CidadeDAO;
import com.mercado.DAO.EstadoDAO;
import com.mercado.modelo.Cidade;
import com.mercado.modelo.Estado;


public class CidadeDAOTest {

	@Test
	@Ignore
	public void salvar(){
	    
		Cidade cidade = new Cidade();
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(1L);

        	
		cidade.setNome("Taguatinga");
		cidade.setEstado(estado);
		
		  
	    	CidadeDAO cidadeDAO = new CidadeDAO();
			cidadeDAO.salvar(cidade);
	    	    
		System.out.println("codigo da cidade "+ cidade.getCodigo());
		System.out.println("Nome da cidade " + cidade.getNome());
		System.out.println("Nome do Estado "+ cidade.getEstado().getNome());
		System.out.println("Sigla "+ cidade.getEstado().getSigla());
	   		
	}
	
	public void listar(){
		CidadeDAO cidadeDAO = new CidadeDAO();
		List<Cidade> resultado = cidadeDAO.listar();
		
		for(Cidade cidade: resultado){
			System.out.println("codigo da cidade "+ cidade.getCodigo());
			System.out.println("Nome da cidade " + cidade.getNome());
			System.out.println("Nome do Estado "+ cidade.getEstado().getNome());
			System.out.println("Sigla "+ cidade.getEstado().getSigla());
			
		}
	}
	
}