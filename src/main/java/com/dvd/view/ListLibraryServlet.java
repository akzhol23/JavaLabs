package com.dvd.view;

import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.dvd.model.DVDItem;

@WebServlet(name = "ListLibraryServlet", value = "/list_library.view")
public class ListLibraryServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List dvds = new ArrayList();
        dvds.add( new DVDItem("Close Encounters of the Third King", "1976", "Sci-Fi") );
        dvds.add( new DVDItem("Star Wars", "1977", "Sci-Fi") );
        dvds.add( new DVDItem("Mission to Mars  ", "2000", "Sci-Fi") );
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
        out.println("<HTML>");
        out.println("<HEAD><TITLE>ListLibraryServlet</TITLE></HEAD>");
        out.println("<BODY>");
        out.println("<p>");
        out.println("You currently have <b>"+dvds.size()+"</b> DVDs in your collection:");
        out.println("</p>");
        out.println("<table");
        out.println("<tr>");
        out.println("<td align='center'><b>TITLE</b></td>");
        out.println("<td align='center'><b>YEAR</b></td>");
        out.println("<td align='center'><b>GENRE</b></td>");
        out.println("</tr>");
        Iterator items = dvds.iterator();
        while (items.hasNext()) {
            DVDItem item = (DVDItem)items.next();
            out.println("<tr>");
            out.println("<td>"+item.getTitle()+"</td>");
            out.println("<td align='center'>"+item.getYear()+"</td>");
            out.println("<td align='center'>"+item.getGenre()+"</td>");
            out.println("</tr>");
        }
        out.println("</table>");
        out.println("</BODY>");
        out.println("</HTML>");
    }

    public void destroy() {
    }
}
