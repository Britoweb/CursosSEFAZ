package com.mercado.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;
import org.omnifaces.util.Messages.Message;

import com.mercado.DAO.FabricanteDAO;
import com.mercado.modelo.Fabricante;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class FabricanteBean implements Serializable {

	private Fabricante fabricante;
	
	private List<Fabricante> fabricantes; 

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}
	
	public void editar(ActionEvent evento){
		fabricante = (Fabricante) evento.getComponent().getAttributes().get("fabricanteSelecionado");
		
		
	}
	
	public void excluir(ActionEvent evento){
		try{
		
		fabricante = (Fabricante) evento.getComponent().getAttributes().get("fabricanteSelecionado");
		FabricanteDAO fabricanteDAO =new FabricanteDAO();
		fabricanteDAO.excluir(fabricante);
		fabricantes = fabricanteDAO.listar();
		
		Messages.addGlobalInfo("Excluido com sucesso");
		}catch(RuntimeException erro){
			Messages.addGlobalError("erro ao selecionar");
			erro.printStackTrace();
		}
		}
	
	
	
	@PostConstruct
	public void listar(){
		try{
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		fabricantes= fabricanteDAO.listar();
		}catch(RuntimeException erro){
			Messages.addGlobalError("erro ao listar");
			erro.printStackTrace();
		}
	}
	

	public void Salvar(){
		try{
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		fabricanteDAO.merge(fabricante);
		novo();
		fabricantes = fabricanteDAO.listar();
		Messages.addGlobalInfo("Salvo com sucesso");
		}catch(RuntimeException erro){
			Messages.addGlobalError("erro ao salvar");
		}

	
		}

	public void novo() {

		fabricante = new Fabricante();

	}

	public List<Fabricante> getFabricantes() {
		return fabricantes;
	}

	public void setFabricantes(List<Fabricante> fabricantes) {
		this.fabricantes = fabricantes;
	}
}
