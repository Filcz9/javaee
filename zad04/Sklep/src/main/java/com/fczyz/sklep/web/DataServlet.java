package com.fczyz.sklep.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.text.DateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fczyz.sklep.game.ComputerGame;
import com.fczyz.sklep.service.*;

@WebServlet(urlPatterns = "/data")
public class DataServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        String title = request.getParameter("title");
        String date = request.getParameter("release_date");
        Double price = Double.parseDouble(request.getParameter("price"));
        DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
        Boolean available = Boolean.parseBoolean(request.getParameter("available"));



        ComputerGame game = new ComputerGame();
        game.setTitle(title);
        game.setAvailable(available);
        game.setPrice(price);
        try{
            Date releaseDate = formatter.parse(date);
            game.setReleaseDate(releaseDate);
        }
        catch(ParseException e)
        {
            e.printStackTrace();
        }

        GameService service = new GameService();
        service.add(game);
        out.println("<html><body><h2> All Games</h2>");
        for (ComputerGame games: service.getAllComputerGames())
        {
            out.println("<form action='delete'>"+
                    "Title: <input type='text' name='title' value='" + games.getTitle() + "'readony/> <br>" +
                    "Price: <input type='number' step='0.01' name='price' value=" +games.getPrice()+" readonly/> <br />" +
                    "Release Date: <input type='text' name='releaseDate' value='"+games.getReleaseDate()+"'readonly/> <br />" +
                    "Availability <input type='text' name='available' value='"+games.getAvailable()+"'readonly/><br />" +
                    "<Input type='submit' value='delete'/> "+
                    "</form>");
        }
        out.println("</body></html>");
        out.close();
    }

}
