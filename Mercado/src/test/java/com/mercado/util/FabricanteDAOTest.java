package com.mercado.util;

import org.junit.Test;

import com.mercado.DAO.FabricanteDAO;
import com.mercado.modelo.Fabricante;

public class FabricanteDAOTest {
	@Test
	public void salvar(){
		Fabricante fabricante= new Fabricante();
		fabricante.setDescricao("skol");
		
		
	FabricanteDAO fabricanteDAO = new FabricanteDAO();
	fabricanteDAO.salvar(fabricante);	
	}
}
