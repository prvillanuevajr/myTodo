package com.presmelito.mytodo.controller.todo;

import com.presmelito.mytodo.dao.TodoDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/todos/complete")
public class TodoComplete extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean updated = new TodoDao().markAsComplete(Long.parseLong(req.getParameter("todoId")));
        resp.sendRedirect(req.getContextPath()+"/todos");
    }
}
