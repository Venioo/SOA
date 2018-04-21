package temp;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/ConverterServlet")
public class ConverterServlet extends HttpServlet {
    @EJB
    private ConverterInterface converter;

    protected void service(HttpServletRequest request, HttpServletResponse response) throws
            ServletException,
            IOException {
        double result;
        double temp = Double.parseDouble(request.getParameter("temp"));
        String conv = request.getParameter("conv");
        if (conv.equals("F")) {
            result = converter.Cels2Fahr(temp);
        } else
            result = converter.Fahr2Cels(temp);
        request.setAttribute("conv", conv);
        request.setAttribute("newTemp", result);
        System.out.println(result);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
        rd.forward(request, response);
    }
}
