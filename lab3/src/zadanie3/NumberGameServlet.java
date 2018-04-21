package zadanie3;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "NumberGameServlet", urlPatterns = "/numbergame")
public class NumberGameServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        NumberGame numberGame = new NumberGame();
        int counter = 0, correctNumber;
        int playerNumber = Integer.parseInt(request.getParameter("playerNumber"));

        if (session.isNew()) {
            numberGame.generateNewNumber();
            session.setAttribute("startNewGame", false);
            session.setAttribute("correctNumber", numberGame.getCorrectNumber());
            session.setAttribute("counter", counter);
        }
        Boolean startNewGame = (Boolean) session.getAttribute("startNewGame");
        if (startNewGame == null || startNewGame) {
            session.invalidate();
            request.getRequestDispatcher("/numbergame").forward(request, response);
        } else {
            counter = (Integer) session.getAttribute("counter");
            correctNumber = (Integer) session.getAttribute("correctNumber");
            int result = numberGame.compareNumbers(correctNumber, playerNumber);
            session.setAttribute("result", result);
            counter = counter + 1;
            session.setAttribute("counter", counter);
            request.getRequestDispatcher("zadanie3/result.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
