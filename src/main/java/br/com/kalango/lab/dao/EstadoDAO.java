package br.com.kalango.lab.dao;

import javax.ejb.Stateless;

import br.com.kalango.lab.models.Estado;

@Stateless
public class EstadoDAO extends BaseDAO<Estado> {

	public EstadoDAO() {
		super(Estado.class);
	}

}
