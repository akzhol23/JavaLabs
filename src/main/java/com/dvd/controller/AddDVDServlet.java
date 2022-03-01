package com.dvd.controller;

import com.dvd.model.DVDItem;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AddDVDServlet", value = "/add_dvd.do")
public class AddDVDServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String title = request.getParameter("title");
        String year = request.getParameter("year");
        String genre = request.getParameter("genre");
        String newgenre = request.getParameter("newGenre");
        if (newgenre != null && newgenre.length() != 0) {
            genre = newgenre;
        }
        List<String> errors = new ArrayList<>();
        if (title == null || title.length() == 0 ) {
            errors.add("Title cannot be empty.");
        }
        if (year == null || year.length() == 0) {
            errors.add("Year cannot be empty.");
        }
        if (year != null && !year.matches("\\d\\d\\d\\d")) {
            errors.add("Year must be four digits long");
        }
        if (genre.equals("UNKNOWN")) {
            errors.add("Genre cannot be empty");
        }
        RequestDispatcher rd;
        if (errors.isEmpty()) {
            DVDItem dvdItem = new DVDItem(title, year, genre);
            request.setAttribute("dvdItem", dvdItem);
            rd = request.getRequestDispatcher("/success.view");
            rd.forward(request, response);
        }
        else {
            request.setAttribute("errors", errors);
            rd = request.getRequestDispatcher("/add_dvd.view");
            rd.forward(request, response);
        }
    }

    public void destroy() {
    }
}
