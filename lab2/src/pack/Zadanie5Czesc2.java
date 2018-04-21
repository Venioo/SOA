package pack;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Vector;

@WebServlet(name = "Zadanie5Czesc2", urlPatterns = "/zad5cz2")
public class Zadanie5Czesc2 extends HttpServlet {
    public Vector<Data> data = new Vector<>();

    public class Data {
        String name;
        String email;
        String comment;

        public Data(String name, String email, String comment) {
            this.name = name;
            this.email = email;
            this.comment = comment;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession(false);
        if (session != null) {
            out.println("<html><body>");
            out.println("<title>Zadanie 5</title>");
            out.println("<h2>Please submit your feedback:</h2>");
            out.println("<form action=\"zad5cz2\" method=\"post\">  \n" +
                    "    Your name:<input type=\"text\" name=\"name\"><br>  \n" +
                    "    Your email:<input type=\"text\" name=\"email\"><br>  \n" +
                    "    Comment:<input type=\"text\" name=\"comment\"><br>  \n" +
                    "    <input type=\"submit\" value=\"Send Feedback\">  \n" +
                    "    </form>");

            out.println("_______________________________________________________________________________<br>");
            if (request.getParameter("name") != null) {
                data.add(new Data(request.getParameter("name"), request.getParameter("email"), request.getParameter("comment")));
            }
            Enumeration<Data> dataEnumeration = data.elements();
            while (dataEnumeration.hasMoreElements()) {
                Data entry = dataEnumeration.nextElement();
                out.println("<b><big>" + entry.name + "</b></big> (" + entry.email + ") says<br>" +
                        "&nbsp&nbsp&nbsp&nbsp" + entry.comment + "<br><br>");
            }
            out.println("</body><html>");
        } else {
            out.print("Please login first");
            request.getRequestDispatcher("zad5.html").include(request, response);
        }
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        doPost(request, response);
    }
}