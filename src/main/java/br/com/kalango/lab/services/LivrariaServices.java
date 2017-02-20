package br.com.kalango.lab.services;

import java.util.List;

import javax.inject.Inject;
import javax.jws.HandlerChain;
import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;

import br.com.kalango.lab.dao.LivroDAO;
import br.com.kalango.lab.models.Livro;

@WebService(serviceName = "LivrariaService")
@HandlerChain(file="../../../../../handler-chain.xml")
public class LivrariaServices {

	@Inject
	private LivroDAO livroDAO;

	@WebMethod
	@WebResult(name = "listLivros")
	public List<Livro> listarLivros() {
		return livroDAO.listarTodos();
	}

}
