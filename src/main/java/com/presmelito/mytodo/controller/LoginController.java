package com.presmelito.mytodo.controller;

import com.presmelito.mytodo.model.Login;
import com.presmelito.mytodo.model.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/login")
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/login.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Login login = new Login(
                req.getParameter("userName"),
                req.getParameter("password")
        );
        boolean isValid = login.validate();

        if (isValid){
            req.getSession().setAttribute("user",login.getUser());
            resp.sendRedirect(req.getContextPath()+"/todos");
        }else {
            resp.getWriter().println("BAD LOGIN!");
        }
    }
}
