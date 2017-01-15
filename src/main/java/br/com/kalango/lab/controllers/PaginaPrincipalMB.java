package br.com.kalango.lab.controllers;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import br.com.kalango.lab.dao.LivroDAO;

@ManagedBean
public class PaginaPrincipalMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5917166101100572866L;
	private String mensagem = "Olá, sejam bem vindos!";
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	
	@EJB
	private LivroDAO livroDAO;
	
	
}
