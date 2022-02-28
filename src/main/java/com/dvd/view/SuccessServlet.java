package com.dvd.view;

import com.dvd.model.DVDItem;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SuccessServlet", value = "/success.view")
public class SuccessServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        DVDItem dvdItem = (DVDItem) request.getAttribute("dvdItem");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
        out.println("<HTML>");
        out.println("<HEAD><TITLE>DVD Library Application:Add DVD Success</TITLE></HEAD>");
        out.println("<BODY>");
        out.println("<h1>Add DVD Success</h1>");
        out.println("You have add the following DVD:<br/>");
        out.println("Title: "+dvdItem.getTitle()+"<br/>");
        out.println("Year Released: "+dvdItem.getYear()+"<br/>");
        out.println("Genre of film: "+dvdItem.getGenre()+"<br/>");
        out.println("<br/><a href='index.jsp'>Home</a>");
        out.println("</BODY>");
        out.println("</HTML>");
        out.close();
    }

    public void destroy() {
    }
}
