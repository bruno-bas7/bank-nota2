package br.com.bank.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.bank.model.Client;
import br.com.bank.model.Contato;
import br.com.bank.service.ClientServiceImpl;
import br.com.bank.service.ContatoServiceImpl;

/**
 * Servlet implementation class ContatoServlet
 */
@WebServlet("/contatosServlet")
public class ContatosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	private Contato contato;
	private ContatoServiceImpl service;
	private Client client;
	private ClientServiceImpl serviceClient;

	
	public ContatosServlet() {
		this.service = new ContatoServiceImpl();
		this.contato = new Contato();
		this.serviceClient = new ClientServiceImpl();
		this.client = new Client();
	}
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String acao = request.getParameter("acao");
		
		switch (acao) {
		
		case "remover":
			// processar a remoção do contato
			String id = request.getParameter("id");
			System.out.println(id);
			// criar o metodo de remocão no dao, e no service
			// chamar o service aqui, passando o id (da request) como parametro para executar a remoção do contato
			
		case "editar":
			
		case "listar":
			RequestDispatcher rd = request.getRequestDispatcher("/admin/pages/contatos/list_client.jsp");
			request.setAttribute("contatos", this.service.list());
			rd.forward(request, response);
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		try {
		String name  = request.getParameter("name"); 
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String senha = request.getParameter("senha");
		
		//MONTEI O MEU OBJETO CLIENT
		Client client = new Client();
		client.setName(name);
		client.setEmail(email);
		client.setPhone(phone);
		client.setSenha(senha);
		
		if(this.serviceClient.save(client)) {
		RequestDispatcher rd = request.getRequestDispatcher("/admin/pages/contatos/list_client.jsp");
		request.setAttribute("sucesso", "Cadastro salvo com sucesso");
		request.setAttribute("clients", this.serviceClient.getAll());
		rd.forward(request, response);
			}
		}catch (Exception e){
			System.out.println(e.toString());
			response.sendRedirect("admin/primeiroAcesso.jsp");
		}
		
	}
}