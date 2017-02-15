package com.mercado.util;

import org.junit.Test;

import com.mercado.DAO.PessoaDAO;
import com.mercado.DAO.UsuarioDAO;
import com.mercado.modelo.Pessoa;
import com.mercado.modelo.Usuario;

public class UsuarioDAOTest {
	
	@Test
	public void salvar(){
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(1L);
		
	Usuario usuario = new Usuario();
	usuario.setPessoa(pessoa);
	usuario.setSenha("191512");
	usuario.setTipo('A');
	
	
	UsuarioDAO usuarioDAO = new UsuarioDAO();
	usuarioDAO.salvar(usuario);
	
	System.out.println("usuario salvo");
	
	}

}
