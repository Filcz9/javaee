package com.fczyz.sklep.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fczyz.sklep.game.ComputerGame;
import com.fczyz.sklep.service.*;

@WebServlet(urlPatterns = "/shoppingcart")
public class PurchaseServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        Double toPay = 0.0;

        PurchaseService service = new PurchaseService();

        out.println("<html><body><h3>Shopping Cart</h3>");
        for(int i=0; i<service.purchase.size(); i++) {
            toPay += service.purchase.get(i).getPrice();
            out.println("<h2>" + service.purchase.get(i).getTitle() + "</h2>" +
                    "<p>Price: " + service.purchase.get(i).getPrice() + "<br />");

        }
        out.println("<h2> To Pay: "+toPay+ "</h2>"+
        "</body></html>");
        out.close();
    }

}