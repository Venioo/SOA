package com.example.web;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "Servlet_wybierzpiwo", urlPatterns = "/WybierzPiwo.do")
public class WyborPiwa extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String c = request.getParameter("kolor");
        EkspertPiwny ekspertPiwny = new EkspertPiwny();
        ArrayList<String> marki = ekspertPiwny.znajdzMarki(c);
        request.setAttribute("marki", marki);
        RequestDispatcher view = request.getRequestDispatcher("com.example.web/wyniki.jsp");
        view.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
