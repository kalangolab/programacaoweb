package br.com.kalango.lab.models;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Livro implements Serializable {

	@Id
	private Long id;

	/**
	 * 
	 */
	private static final long serialVersionUID = 2310740993968372238L;
	private String titulo;
	private Long IBSN;
	private BigDecimal valor;
	private int qtPaginas;
	private boolean capaDura;
	private String genero;

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Long getIBSN() {
		return IBSN;
	}

	public void setIBSN(Long iBSN) {
		IBSN = iBSN;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public int getQtPaginas() {
		return qtPaginas;
	}

	public void setQtPaginas(int qtPaginas) {
		this.qtPaginas = qtPaginas;
	}

	public boolean isCapaDura() {
		return capaDura;
	}

	public void setCapaDura(boolean capaDura) {
		this.capaDura = capaDura;
	}

}
