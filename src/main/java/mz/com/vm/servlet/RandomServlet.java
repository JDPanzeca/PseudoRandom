package mz.com.vm.servlet;

import java.io.IOException;
//import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mz.com.vm.http.PseudoRN;

public class RandomServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private int rn;
	//private int 
	
	@Override 
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, 
	IOException { 
		//req.getRequestDispatcher("WEB-INF/random.jsp").forward(req, resp);
		//req.forward(request, response);
		resp.setContentType("text/html");
		//PrintWriter out = resp.getWriter();
		// buscando os par�metros no request
		//int qtd = (Integer.parseInt(req.getParameter("qtd")));
		//String slt = req.getParameter("slt");
		
		//System.out.println(qtd);
		//System.out.println(slt);
		
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
				
	    req.setAttribute("numbers", numbers);
		
	    RequestDispatcher rd = req.getRequestDispatcher("/random.jsp");
	    rd.forward(req, resp);
				
	}
	
}
