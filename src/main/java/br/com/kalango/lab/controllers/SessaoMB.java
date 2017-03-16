package br.com.kalango.lab.controllers;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.kalango.lab.dao.EstadoDAO;
import br.com.kalango.lab.models.Estado;

@Named
@SessionScoped
public class SessaoMB implements Serializable {

	@Inject
	private EstadoDAO estadoDAO;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1683346421712151629L;
	private String usuario;
	private String senha;
	
	public String login(){
		if(usuario.equalsIgnoreCase("kalango") && senha.equals("123456")){
			FacesContext.getCurrentInstance().addMessage("", new FacesMessage("Usuário logado", "Usuário Logado"));
			return "/admin/index.jsf?faces-redirect=true";
		}else{
			FacesContext.getCurrentInstance().addMessage("", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário ou senha errados!", "Usuário ou senha errados!"));
			return "";
		}
			
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public List<Estado> getListEstados(){
		return estadoDAO.listarTodos();
	}
	
	
	
}
