package com.mercado.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import com.mercado.DAO.CidadeDAO;
import com.mercado.DAO.PessoaDAO;
import com.mercado.modelo.Cidade;
import com.mercado.modelo.Estado;
import com.mercado.modelo.Pessoa;

@ManagedBean
@ViewScoped
public class PessoaBean implements Serializable {

	private static final long serialVersionUID = 8541734290701985422L;

	private Pessoa pessoa;
	private List<Pessoa> pessoas;
	private List<Cidade> cidades;
	private List<Estado> estados;
	
	private Estado estado;

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public void novo() {
		pessoa = new Pessoa();
	}

	public void salvar() {
		try {
			PessoaDAO dao = new PessoaDAO();
			dao.merge(pessoa);
			novo();
			listar();
			Messages.addGlobalInfo("Salvo com sucesso");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("erro ao salvar");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent event) {
		pessoa = (Pessoa) event.getComponent().getAttributes().get("pessoaSelecionada");
	}

	public void excluir(ActionEvent event) {
		try {
			pessoa = (Pessoa) event.getComponent().getAttributes().get("pessoaSelecionada");
			PessoaDAO pessoaDAO = new PessoaDAO();
			pessoaDAO.excluir(pessoa);
			setPessoas(pessoaDAO.listar());
			Messages.addGlobalInfo("Pessoa: '" + pessoa.getNome() + "' foi removido!!!");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("erro ao selecionar");
			erro.printStackTrace();
		}
	}

	@PostConstruct
	public void listar() {
		try {
			PessoaDAO pessoaDAO = new PessoaDAO();
			pessoas = pessoaDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro ao listar!");
			erro.printStackTrace();
		}
	}
	
	public void popular(){
		try {
			if(estado != null) {
				CidadeDAO cidadeDAO = new CidadeDAO();
				cidades = cidadeDAO.buscarPorEstado(estado.getCodigo());
			} else {
				cidades = new ArrayList<>();
			}
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Erro em Popular");
			erro.printStackTrace();
		}
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

}
