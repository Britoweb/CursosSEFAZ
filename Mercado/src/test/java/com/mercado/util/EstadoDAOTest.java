package com.mercado.util;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.mercado.DAO.EstadoDAO;
import com.mercado.modelo.Estado;

public class EstadoDAOTest {

	@Test
	@Ignore
	public void salvar() {
		Estado estado = new Estado();
		estado.setNome("Brasilia");
		estado.setSigla("DF");

		EstadoDAO estadoDAO = new EstadoDAO();
		estadoDAO.salvar(estado);
	}

	@Test
	public void listar() {
		System.out.println("--");
		EstadoDAO estadoDAO = new EstadoDAO();

		List<Estado> resultado = estadoDAO.listar();

		for (Estado estado : resultado) {
			System.out.println(estado.getSigla() + " - " + estado.getNome());

		}
		System.out.println("Total de Estados" + resultado.size());
	}

	@Test
	@Ignore
	public void buscar() {

		Long codigo = 2L;

		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigo);

		if (estado == null) {
			System.out.println(" nenhum registro");
		} else {
			System.out.println("Registro encontrado");

		}
	}

	@Test
	@Ignore
	public void editar() {

		Long codigo = 20l;

		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigo);

		if (estado == null) {
			System.out.println(" nenhum registro encontrado");
		} else {

			estado.setNome("BAHIA");
			estado.setSigla("BA");
			estadoDAO.editar(estado);

			System.out.println("Registro encontrado");
			System.out.println(estado.getNome() + "- " + estado.getSigla());
			System.out.println();
		}
	}

	@Test
	@Ignore
	public void excluir() {
		Long codigo = 1L;
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigo);

		if (estado == null) {
			System.out.println("Nenhum registro encontrado");
		} else {

			estadoDAO.excluir(estado);

			System.out.println("Registro removido:");
			System.out.println(estado.getCodigo() + " - " + estado.getSigla() + " - " + estado.getNome());
		}
	}
}
