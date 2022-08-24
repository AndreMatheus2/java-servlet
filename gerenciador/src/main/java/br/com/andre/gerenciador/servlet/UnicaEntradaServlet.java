package br.com.andre.gerenciador.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import br.com.andre.gerenciador.acao.AlteraEmpresa;
import br.com.andre.gerenciador.acao.ListaEmpresa;
import br.com.andre.gerenciador.acao.MostraEmpresa;
import br.com.andre.gerenciador.acao.NovaEmpresa;
import br.com.andre.gerenciador.acao.RemoveEmpresa;

@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String paramAcao = request.getParameter("acao"); 

        if(paramAcao.equals("ListaEmpresas")) {
            ListaEmpresa acao = new ListaEmpresa();
            acao.executa(request, response); 
            
        } else if(paramAcao.equals("RemoveEmpresa")) {
        	RemoveEmpresa acao = new RemoveEmpresa();
        	acao.executa(request, response);
            
        } else if(paramAcao.equals("MostraEmpresa")) {
        	MostraEmpresa acao = new MostraEmpresa();
        	acao.executa(request, response);
            
        }else if(paramAcao.equals("NovaEmpresa")) {
        	NovaEmpresa acao = new NovaEmpresa();
        	acao.executa(request, response);
            
        }else if(paramAcao.equals("AlteraEmpresa")) {
        	AlteraEmpresa acao = new AlteraEmpresa();
        	acao.executa(request, response);
            
        }
    }

}


