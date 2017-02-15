package com.mercado.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import com.mercado.DAO.FabricanteDAO;
import com.mercado.DAO.ProdutoDAO;
import com.mercado.modelo.Fabricante;
import com.mercado.modelo.Produto;

@ManagedBean
@ViewScoped
public class ProdutoBean implements Serializable {

	private static final long serialVersionUID = -3114894886165872438L;

	private Produto produto;
	private List<Produto> produtos;
	private List<Fabricante> fabricantes;

	public void novo() {
		produto = new Produto();
	}

	public void salvar() {
		try {
			ProdutoDAO dao = new ProdutoDAO();
			dao.merge(produto);
			novo();
			listar();
			Messages.addGlobalInfo("Salvo com sucesso");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("erro ao salvar");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent event) {
		produto = (Produto) event.getComponent().getAttributes().get("produtoSelecionado");
	}

	public void excluir(ActionEvent event) {
		try {
			produto = (Produto) event.getComponent().getAttributes().get("produtoSelecionado");
			ProdutoDAO produtoDAO = new ProdutoDAO();
			produtoDAO.excluir(produto);
			setProdutos(produtoDAO.listar());
			Messages.addGlobalInfo("Produto: " + produto.getDescricao() + " foi removido!!!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("erro ao selecionar");
			erro.printStackTrace();
		}
	}

	@PostConstruct
	public void listar() {
		try {
			ProdutoDAO produtoDAO = new ProdutoDAO();
			produtos = produtoDAO.listar();
			FabricanteDAO fabricanteDAO = new FabricanteDAO();
			fabricantes = fabricanteDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao listar!");
			erro.printStackTrace();
		}
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public List<Fabricante> getFabricantes() {
		return fabricantes;
	}

	public void setFabricantes(List<Fabricante> fabricantes) {
		this.fabricantes = fabricantes;
	}

}
