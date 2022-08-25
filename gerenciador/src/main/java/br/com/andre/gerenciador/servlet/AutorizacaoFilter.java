package br.com.andre.gerenciador.servlet;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter("/entrada")
public class AutorizacaoFilter extends HttpFilter implements Filter {
   
	public void doFilter(ServletRequest servletRequest, ServletResponse ServletResponse, FilterChain chain) throws IOException, ServletException {
	
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response= (HttpServletResponse) ServletResponse;

		String paramAcao = request.getParameter("acao"); 

		
		HttpSession sessao = request.getSession();
		boolean usuarioNaoEstaLogado = (sessao.getAttribute("usuarioLogado") == null);
		boolean ehUmaAcaoProtegida = !(paramAcao.equals("Login") || paramAcao.equals("LoginForm"));
		
			if (ehUmaAcaoProtegida && usuarioNaoEstaLogado) {
			response.sendRedirect("entrada?acao=LoginForm");
			return;
		}
		
		chain.doFilter(request, response);
	}
}
