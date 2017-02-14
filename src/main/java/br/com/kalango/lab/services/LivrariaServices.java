package br.com.kalango.lab.services;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(serviceName="LivrariaService")
public class LivrariaServices {

	@WebMethod()
	public String sayHello(){
		return "Olá amigos!";
	}
	
	@WebMethod
	public double calcular(
			@WebParam double a, 
			@WebParam double b){
		return a + b;
	}
	
}
