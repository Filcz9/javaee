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

@WebServlet(urlPatterns = "/purchase")
public class ShoppingCartServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        String title = request.getParameter("title");
        String date = request.getParameter("release_date");
        Double price = Double.parseDouble(request.getParameter("price"));
        SimpleDateFormat format = new SimpleDateFormat("yyyy-dd-MM");
        Boolean available = Boolean.parseBoolean(request.getParameter("available"));
        Double toPay =  0.0;


        ComputerGame game = new ComputerGame();
        game.setTitle(title);
        game.setAvailable(available);
        game.setPrice(price);
        try{
            Date release_date = format.parse(date);
            game.setReleaseDate(release_date);
        }
        catch(ParseException e)
        {
            e.printStackTrace();
        }

        PurchaseService service = new PurchaseService();
        service.add(game);
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