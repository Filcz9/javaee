package com.example.servletdemo;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/about")
public class AboutServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		out.println("<html><body><h1> Robert Kubica </h1></body><p>Sport: Formula 1</p>"
				+ "<p>Hobby: Samochody</p><p>Dane:</p><ul><li>Waga:80kg</li><li>Wzrost: 178cm</li><li>Plec: Mezczyzna</li></ul></html>");
		
	
	}
}

