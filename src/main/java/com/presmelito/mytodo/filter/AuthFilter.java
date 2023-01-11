package com.presmelito.mytodo.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
@WebFilter(servletNames = {"com.presmelito.mytodo.controller.todo.TodoController"})
public class AuthFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpSession session = httpServletRequest.getSession(false);

        if (httpServletRequest.getSession(false) == null || httpServletRequest.getSession(false).getAttribute("user") == null) {
            ((HttpServletResponse) response).sendRedirect(httpServletRequest.getContextPath()+"/login");
        }else {
            chain.doFilter(httpServletRequest,response);
        }
    }
}
