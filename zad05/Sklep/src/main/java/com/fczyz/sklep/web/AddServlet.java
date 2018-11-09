package com.fczyz.sklep.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/add")
public class AddServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		out.println("<html><body><h2>Add Computer Game</h2>" +
				"<form action='data'>" +
				"Title: <input type='text' name='title' /> <br />" +
				"Price: <input type='number' step='0.01' name='price' /> <br />" +
				"Release Date: <input type='date' name='releaseDate' /> <br />" +
				"<input type='checkbox' name='available' value='false'>Game is not available to purchase<br />" +
				"<input type='checkbox' name='available' value='true'>Game is available to purchase<br />" +
				"<input type='submit' value=' OK ' />" +
				"</form>" +
				"</body></html>");
		out.close();

	}

}


