package com.presmelito.mytodo.controller.todo;

import com.presmelito.mytodo.dao.TodoDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/todos/delete")
public class TodoDelete extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean deleted = new TodoDao().delete(Long.parseLong(req.getParameter("todoId")));
        if (deleted) {
            resp.sendRedirect(req.getContextPath()+"/todos");
        }
    }
}
