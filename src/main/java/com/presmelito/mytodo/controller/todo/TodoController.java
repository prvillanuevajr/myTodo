package com.presmelito.mytodo.controller.todo;

import com.presmelito.mytodo.dao.TodoDao;
import com.presmelito.mytodo.model.Todo;
import com.presmelito.mytodo.model.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@WebServlet("/todos")
public class TodoController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Todo> todos = new TodoDao().findAll((User) req.getSession().getAttribute("user"));
        req.setAttribute("todos", todos);
        req.getRequestDispatcher("/WEB-INF/todos/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        Todo todo = new Todo(
                req.getParameter("title"),
                user,
                req.getParameter("description"),
                LocalDateTime.parse(req.getParameter("targetDate")),
                null
        );
        if (todo.save()){
            resp.sendRedirect(req.getContextPath()+"/todos");
        }
    }
}
