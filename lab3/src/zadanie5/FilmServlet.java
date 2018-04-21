package zadanie5;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "FilmServlet", urlPatterns = "/films")
public class FilmServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Film> films = new ArrayList<>();
        films.add(new Film("Ojciec chrzestny", "dramat", "1972", "120000000"));
        films.add(new Film("Pluton", "wojenny", "1986", "50000000"));
        films.add(new Film("Nagi instynkt", "dramat", "1992", "100000000"));
        films.add(new Film("Film", "wojenny", "1992", "50"));
        request.setAttribute("films",films);
        request.getRequestDispatcher("zadanie5/film.jsp").forward(request, response);
    }
}
