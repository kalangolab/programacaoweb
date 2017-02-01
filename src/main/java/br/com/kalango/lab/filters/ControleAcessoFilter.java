package br.com.kalango.lab.filters;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.kalango.lab.controllers.SessaoMB;

@WebFilter(urlPatterns={"/admin/*", "/login/*"} )
public class ControleAcessoFilter implements Filter {

	@Inject
	protected SessaoMB sessao;
	
	
	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, 
			FilterChain chain)
			throws IOException, ServletException {
		System.out.println("Entrando no filtro");
		if(sessao.getUsuario()==null){
			HttpServletResponse resp = (HttpServletResponse)response;
			resp.sendRedirect("/livraria/index.jsf");
			return;
		}
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
			
	}

}
