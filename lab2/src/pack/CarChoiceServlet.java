package pack;

import pack.Car.Car;
import pack.Car.CarChoiceHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "CarChoiceServlet", urlPatterns = "/zad4")
public class CarChoiceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String carType = request.getParameter("carType");
        String bottomLimit = request.getParameter("bottom");
        String topLimit = request.getParameter("top");
        out.println("<html><body>");
        CarChoiceHelper carChoiceHelper = new CarChoiceHelper(carType, Integer.parseInt(bottomLimit), Integer.parseInt(topLimit));
        ArrayList<String> names = carChoiceHelper.findCars();
        out.println(names);
        out.println("</body><html>");
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
