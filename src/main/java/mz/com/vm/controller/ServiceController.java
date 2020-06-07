package mz.com.vm.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.ws.rs.Consumes;
//import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import mz.com.vm.http.PseudoRN;
import mz.com.vm.repository.PseudoRepository;

/**
 * Essa classe vai expor os nosso métodos para serem acessasdos via http
 * 
 * @Path - Caminho para a chamada da classe que vai representar o nosso serviço
 * */
@Path("/service")
public class ServiceController {
		
	private final  PseudoRepository repository = new PseudoRepository();
	private int rn;

	/**
	 * @Consumes - determina o formato dos dados que vamos postar
	 * @Produces - determina o formato dos dados que vamos retornar
	 * 
	 * Esse método gera e retorna o pseudo número e o tempo para gerar cada um deles
	 * */
	@POST	
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/random")
	public String random(PseudoRN pnr){
			
		List<PseudoRN> numbers = new ArrayList<PseudoRN>();
		
		Random random = new Random();
		
		long start=System.currentTimeMillis();
		Thread t1=new Thread();
		t1.start();
		try {
			Thread.sleep(20000);			
		}catch(InterruptedException e) {
			e.printStackTrace();			
		}
		t1.interrupt();
		
		do {
			rn=random.nextInt();
			
		}while(rn<=3);
		
		long elapsed=System.currentTimeMillis()-start;
		PseudoRN pn = new PseudoRN();
		int index=numbers.size();
		index+=1;
		pn.setCodigo(index);
		pn.setPnR(rn);
		pn.setTime(elapsed);
		numbers.add(pn);
					
	    /* Retornar o número gerado para a view random.jsp localizada em src/main/webapp*/		
	
		return "";
	}
	
	/**
	 * Essse método retorna a lista dos números gerados
	 * **/
	
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/history")
	public List<PseudoRN> allNumbers(){
		
		List<PseudoRN> pseudoNRs =  new ArrayList<PseudoRN>();
		pseudoNRs=repository.todosNumeros();		
		
		return pseudoNRs;
	}
	
	
	/**
	 * Este método cancela a requisição do número aleatório.
	 * */
	@PUT
	@Produces("application/json; charset=UTF-8")
	@Path("{codigo}/cancel/")	
	public String Excluir(@PathParam("codigo") Integer codigo){
		
		try {	
			
			return "Requisição cancelada com sucesso!";
			
		} catch (Exception e) {
		
			return "Erro ao cancelar a requisição! " + e.getMessage();
		}
		
	}

	
	/**
	 * Essse método retorna as estatísticas das requisições dos números aleatórios
	 * **/
	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")	
	@Path("/stats")
	public String history(PseudoRN pnr){
		
		return"";

	}
	
	
	/**
	 * Esse método lista todos os números pendentes para serem gerados.
	 * 	 * */
	
	@GET
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")	
	@Path("/pending")
	public List<PseudoRN> pending(PseudoRN pnr){
		
		List<PseudoRN> pseudoNRs =  new ArrayList<PseudoRN>();
		pseudoNRs=repository.numerosPend();		
		
		return pseudoNRs;

	}
	
	
	/**
	 * Esse método muda a Thread-Pool usada para processar a requisição de números 
	 * */
	
	@PUT
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")	
	@Path("/threads")
	public String Alterar(PseudoRN pessoa){
		
		return"";

	}

}
