package com.presmelito.mytodo.controller;

import com.presmelito.mytodo.dao.UserDao;
import com.presmelito.mytodo.model.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/register")
public class UserRegister extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User(
                req.getParameter("firstName"),
                req.getParameter("lastName"),
                req.getParameter("userName"),
                req.getParameter("password")
        );
        if (user.registerUser()) {
            req.setAttribute("NOTIFICATION", "SUCCESSFULLY REGISTERED!");
        }

        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/register.jsp").forward(req, resp);
    }
}
