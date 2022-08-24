package br.com.andre.gerenciador.acao;

import java.io.IOException;

import br.com.andre.gerenciador.modelo.Banco;
import br.com.andre.gerenciador.modelo.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class Login implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String login = request.getParameter("login");
		String senha= request.getParameter("senha");
		
		Banco banco = new Banco();
		Usuario usuario = banco.existeusuario(login, senha);
		if (usuario != null) {
			HttpSession session = request.getSession();
			session.setAttribute("ususarioLogado", usuario);
			return "redirect:entrada?acao=ListaEmpresas";
		}else {
		
			return "redirect:entrada?acao=LoginForm";

		}
		}

}
