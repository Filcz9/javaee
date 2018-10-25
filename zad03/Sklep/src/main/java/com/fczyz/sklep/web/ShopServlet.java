package com.fczyz.sklep.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.fczyz.sklep.service.*;
import com.fczyz.sklep.game.*;

@WebServlet(urlPatterns = "/shop")
public class ShopServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        GameService service = new GameService();
        out.println("<html><body><h2> All Games</h2>");
        for (ComputerGame game: service.getAllComputerGames())
        {
            out.println("<form action='purchase'>"+
                    "Title: <input type='text' name='title' value='" + game.getTitle() + "'readony/> <br>" +
                    "Price: <input type='number' step='0.01' name='price' value=" +game.getPrice()+" readonly/> <br />" +
                    "Release Date: <input type='text' name='release_date' value='"+game.getReleaseDate()+"'readonly/> <br />" +
                    "Availability <input type='text' name='available' value='"+game.getAvailable()+"'readonly/><br />" +
                    "<Input type='submit' value='Purchase'/> "+
                    "</form>");
        }
        out.println("</body></html>");
        out.close();
    }
}
