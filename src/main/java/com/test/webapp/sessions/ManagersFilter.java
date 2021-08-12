package com.test.webapp.sessions;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/managers/*", filterName = "ManagersFilter")
public class ManagersFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        UserAccount userAccount = UsersSessions.getUser(request.getSession());
        if (userAccount != null && userAccount.isManager()) {
            filterChain.doFilter(request, response);
        } else {
            response.sendRedirect("/");
        }
    }

    @Override
    public void destroy() {

    }
}
