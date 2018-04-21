package pack;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "zad1", urlPatterns = "/zad1")
public class Zadanie1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String paramWiek = request.getParameter("paramWiek");
        String paramImie = request.getParameter("paramImie");
        out.println("<html><body>");
        if (Integer.parseInt(paramWiek) >= 18 && paramImie.charAt(paramImie.length() - 1) == 'a') {
            out.println("Jest to pelnoletnia kobieta");
        }
        else
            out.println("Nie jest to kobieta lub nie jest pelnoletnia");
        out.println("</body><html>");
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
