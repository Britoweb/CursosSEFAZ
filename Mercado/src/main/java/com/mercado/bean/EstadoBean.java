package com.mercado.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import com.mercado.DAO.EstadoDAO;
import com.mercado.modelo.Estado;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class EstadoBean implements Serializable {

	private Estado estado;
	private List<Estado> estados;

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public void editar(ActionEvent evento) {
		estado = (Estado) evento.getComponent().getAttributes().get("estadoSelecionado");

		Messages.addGlobalInfo("Nome" + getEstado().getNome() + "-" + "Sigla" + getEstado().getSigla());
	}

	public void excluir(ActionEvent evento) {

		try {
			estado = (Estado) evento.getComponent().getAttributes().get("estadoSelecionado");
			EstadoDAO estadoDAO = new EstadoDAO();
			estadoDAO.excluir(estado);

			estado = new Estado();
			estados = estadoDAO.listar();
			Messages.addGlobalInfo("Excluido com sucesso");

		} catch (RuntimeException erro) {
			Messages.addGlobalError("erro ao excluir");
			erro.printStackTrace();
		}
	}

	@PostConstruct
	public void listar() {
		try {
			EstadoDAO estadoDAO = new EstadoDAO();
			estados = estadoDAO.listar();

		} catch (RuntimeException erro) {
			Messages.addGlobalError("erro ao listar");
			erro.printStackTrace();
		}
	}

	public void salvar() {
		try {
			EstadoDAO estadoDAO = new EstadoDAO();
			estadoDAO.merge(estado);
			estado = new Estado();
			estados = estadoDAO.listar();

			Messages.addGlobalInfo("salvo com sucesso");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("erro ao salvar");
			erro.printStackTrace();
		}
	}

	public void novo() {
		estado = new Estado();
	}

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

}