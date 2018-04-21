package zadanie4;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AddToCartServlet", urlPatterns = "/cart")
public class AddToCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        Cart shoppingCart = (Cart) session.getAttribute("cart");
        if (shoppingCart == null) {
            shoppingCart = new Cart();
            session.setAttribute("cart", shoppingCart);
        }
        Integer itemId = Integer.parseInt(request.getParameter("itemId"));
        Integer quantity = shoppingCart.getQuantity(itemId);
        if (quantity == null) {
            quantity = 0;
        }
        String action = request.getParameter("action");
        if (action == null || action.equals("+")) {
            quantity++;
            shoppingCart.addToCart(itemId, quantity);
        } else if (action.equals("-")) {
            if (quantity == 1) {
                shoppingCart.deleteFromCart(itemId);
            } else {
                quantity--;
                shoppingCart.addToCart(itemId, quantity);
            }
        } else
            shoppingCart.deleteFromCart(itemId);
        session.setAttribute("cart", shoppingCart);
        request.getRequestDispatcher("/zadanie4/cartPage.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {

    }
}
