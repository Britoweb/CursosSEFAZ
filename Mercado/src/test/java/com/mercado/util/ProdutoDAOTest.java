package com.mercado.util;

import java.math.BigDecimal;

import org.junit.Test;

import com.mercado.DAO.FabricanteDAO;
import com.mercado.DAO.ProdutoDAO;
import com.mercado.modelo.Fabricante;
import com.mercado.modelo.Produto;

public class ProdutoDAOTest {
	
	@Test
	public void salvar(){
		FabricanteDAO fabricanteDAO= new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(1l);
		
		
		Produto produto = new Produto();
		produto.setDescricao("cerveja");
		produto.setPreco(new BigDecimal("25.00"));
		produto.setQuantidade(new Short("50"));
		produto.setFabricante(fabricante);
		
		ProdutoDAO produtoDAO =new ProdutoDAO();
		
		produtoDAO.salvar(produto);
		
		System.out.println("Produto salvo");
		
	}

}
