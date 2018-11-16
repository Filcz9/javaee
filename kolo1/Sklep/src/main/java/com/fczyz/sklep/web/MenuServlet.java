package com.fczyz.sklep.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/")
public class MenuServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html><body><h2>Welcome to Computer Games shop </h2></br>"+
                    "<a href='/servletjspdemo/add'> Add new game</a></br>"+
                "<a href='/servletjspdemo/shop'> Browse Shop</a></br>"+
                "<a href='/servletjspdemo/shoppingcart'> Shopping Cart</a></br>"+

                "</body></html>");
        out.close();
    }

}
