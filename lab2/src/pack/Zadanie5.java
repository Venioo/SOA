package pack;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

@WebServlet(name = "Zadanie5", urlPatterns = "/zad5")
public class Zadanie5 extends HttpServlet {
    Vector<DaneOsobowe> daneOsobowe = new Vector<>();

    public class DaneOsobowe {
        String login;
        String haslo;
        String imie;
        String nazwisko;

        public DaneOsobowe(String login, String haslo, String imie, String nazwisko) {
            this.login = login;
            this.haslo = haslo;
            this.imie = imie;
            this.nazwisko = nazwisko;
        }
    }

    public Zadanie5() {
        daneOsobowe.add(new DaneOsobowe("login", "123", "Jan", "Kowalski"));
        daneOsobowe.add(new DaneOsobowe("login2", "1234", "Adam", "Nowak"));
    }

    private boolean loginValidate(String login, String passwd) {
        for (int i = 0; i < daneOsobowe.size(); i++) {
            DaneOsobowe user = daneOsobowe.get(i);
            if (login.equals(user.login) && passwd.equals(user.haslo)) {
                return true;
            }
        }
        return false;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String login = request.getParameter("login");
        String passwd = request.getParameter("passwd");
        out.println("<html><body>");
        if (loginValidate(login, passwd)) {
            HttpSession session = request.getSession(true);
            session.setAttribute("name", login);
            request.getRequestDispatcher("/zad5cz2").include(request, response);
        } else {
            if (login.equals("")) {
                out.println("Podaj login");
            } else if (passwd.equals("")) {
                out.println("Podaj haslo");
            } else {
                out.print("Nieprawidlowe dane logowania");
            }
            request.getRequestDispatcher("zad5.html").include(request, response);
        }
        out.println("</body><html>");
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
