package br.com.kalango.lab.dao;

import javax.ejb.Stateless;

import br.com.kalango.lab.models.Livro;

@Stateless
public class LivroDAO extends BaseDAO<Livro>{
	public LivroDAO(){
		super(Livro.class);
	}
}
