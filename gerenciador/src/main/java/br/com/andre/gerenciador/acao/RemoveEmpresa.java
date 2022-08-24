package br.com.andre.gerenciador.acao;

import java.io.IOException;
import java.util.List;

import br.com.andre.gerenciador.modelo.Banco;
import br.com.andre.gerenciador.modelo.Empresa;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RemoveEmpresa {
	

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        System.out.println("removendo empresa");


		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		Banco banco = new Banco();
		banco.removeEmpresa(id);
		
		return "redirect:entrada?acao=ListaEmpresas";

		
	}

}
