package com.dvd.view;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Iterator;
import java.util.List;

@WebServlet(name = "AddDVDFormServlet", value = "/add_dvd.view")
public class AddDVDFormServlet extends HttpServlet {
    private static final String default_genres = "Sci-Fi,Drama,Comedy";
    private String[] genres;

    public void init() {
        String genres_list = getInitParameter("genres-list");
        if (genres_list == null) {
            genres_list = default_genres;
        }
        genres = genres_list.split(",");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        generateView(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        generateView(request, response);
    }

    public void generateView(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List errors = (List) request.getAttribute("errors");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html lang='en' xmlns='http://www.w3.org/1999/html'>");
        out.println("<head>");
        out.println("<body>");
        out.println("<h1>Add new DVD</h1>");
        if (errors != null) {
            out.println("<p>");
            out.println("<font color='red'>Please correct the following errors:");
            out.println("<ul>");
            Iterator items = errors.iterator();
            while (items.hasNext()) {
                String message = (String) items.next();
                out.println("<li>" + message + "</li>");
            }
            out.println("</ul>");
            out.println("</font>");
            out.println("</p>");
        }
        out.println("<p>");
        out.println("This form allows you to create a new DVD.");
        out.println("</p>");
        out.println("<form action='add_league.do' method='POST'>");
        String year = request.getParameter("year");
        if (year == null) {
            year = "";
        }
        out.println("Year: <input type='text' name='year' value='"+ year +"'/> <br/><br/>");
        String genre = request.getParameter("genre");
        out.println("Season: <select name='season'>");
        if (genre == null) {
            out.println("<option value='UNKNOWN'>select...</option>");
        }
        for (int i = 0; i < genres.length; i++) {
            out.print("<option value='" + genres[i] + "'");
            if (genres[i].equals(genre)) {
                out.print("selected");
            }
            out.println(">" + genres[i] + "</option>");
        }
        out.println("</select><br/><br/>");
        out.println("<input type='Submit' value='Add DVD' />");
        out.println("</form>");
        out.println("</body>");
        out.println("</head>");
        out.println("</html>");
    }
}