package br.com.andre.gerenciador.acao;

import java.io.IOException;
import java.util.List;

import br.com.andre.gerenciador.modelo.Banco;
import br.com.andre.gerenciador.modelo.Empresa;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MostraEmpresa {
	

	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        System.out.println("mostrando dados da empresa");


		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		Banco banco = new Banco();
		Empresa empresa = banco.buscaEmpresaPeloId(id);

		request.setAttribute("empresa", empresa);
		RequestDispatcher rd = request.getRequestDispatcher("/formAlteraEmpresa.jsp");
		rd.forward(request, response);
		
	}

}
