package br.com.kalango.lab.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ApplicationScoped
@ManagedBean
public class BatePapo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -553747353355351210L;

	public List<Mensagem> mensagens = new ArrayList<>();
	private Mensagem mensagem = new Mensagem();

	public void addMensagem() {
		mensagens.add(mensagem);
		mensagem = new Mensagem();
		Collections.sort(mensagens);
		
	}

	public List<Mensagem> getMensagens() {
		return mensagens;
	}

	public void setMensagens(List<Mensagem> mensagens) {
		this.mensagens = mensagens;
	}

	public Mensagem getMensagem() {
		return mensagem;
	}

	public void setMensagem(Mensagem mensagem) {
		this.mensagem = mensagem;
	}

	public static class Mensagem implements Comparable<Mensagem> {
		private String usuario;
		private Calendar momento = Calendar.getInstance();
		private String mensagem;

		public String getUsuario() {
			return usuario;
		}

		public void setUsuario(String usuario) {
			this.usuario = usuario;
		}

		public Calendar getMomento() {
			return momento;
		}

		public void setMomento(Calendar momento) {
			this.momento = momento;
		}

		public String getMensagem() {
			return mensagem;
		}

		public void setMensagem(String mensagem) {
			this.mensagem = mensagem;
		}

		@Override
		public int compareTo(Mensagem o) {
			return this.momento.before(o.momento) ? 1 : -1;
		}

	}

}
