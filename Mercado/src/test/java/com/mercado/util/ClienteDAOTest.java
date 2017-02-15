package com.mercado.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;

import com.mercado.DAO.ClienteDAO;
import com.mercado.DAO.PessoaDAO;
import com.mercado.modelo.Cliente;
import com.mercado.modelo.Pessoa;


public class ClienteDAOTest {
	@Test
	public void salvar() throws ParseException{
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(1L);
		
		Cliente cliente = new Cliente();
		cliente.setDataCadastro(new SimpleDateFormat("dd/MM/yyyy").parse("11/11/2016"));
		cliente.setLiberado(true);
		cliente.setPessoa(pessoa);
		
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.salvar(cliente);
		
		System.out.println("cliente salvo ");
		
		
	}

}
