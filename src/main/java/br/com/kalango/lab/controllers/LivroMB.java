package br.com.kalango.lab.controllers;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.kalango.lab.dao.LivroDAO;
import br.com.kalango.lab.models.Livro;

@ManagedBean
@ViewScoped
public class LivroMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7622242311578618762L;

	@EJB
	private LivroDAO dao;

	private Livro livro;

	public List<Livro> getLivros() {
		return dao.listarTodos();
	}

	@PostConstruct
	public void init() {
		livro = new Livro();
	}

	public void salvar() {
		try{
			dao.salvar(livro);
			FacesContext.getCurrentInstance().addMessage("", new FacesMessage("Sucesso", "Operação realizada com sucesso!"));
		}catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Livro não foi salvo"));
		}
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

}
