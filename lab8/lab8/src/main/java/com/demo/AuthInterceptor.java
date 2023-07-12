package com.demo;

import com.demo.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class AuthInterceptor
        implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        HttpSession session = request.getSession();
        Account user = (Account) session.getAttribute("user");
        String error = "";
        if (user == null) {
            error = "Please login!";
        } else if (!user.isAdmin() && uri.startsWith("/admin/")) {
            error = "Access denied!";
        }
        if (error.length() > 0) {
            session.setAttribute("security-uri", uri);
            response.sendRedirect("/account/login?error=" + error);
            return false;
        }
        return true;
    }
}
