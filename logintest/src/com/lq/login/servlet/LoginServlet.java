package com.lq.login.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lq.login.exception.ParamException;
import com.lq.login.exception.ServiceException;
import com.lq.login.po.User;
import com.lq.login.service.UserService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public LoginServlet() {
        super();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
}

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        try {
            User user = null;
            UserService userService = new UserService();
            user = userService.login(userName, password);
            HttpSession session = request.getSession();
            user.setPassword(null);
            session.setAttribute("USER", user);
            request.getRequestDispatcher("/WEB-INF/jsp/home.jsp").forward(request, response);
        } catch (ParamException paramException) {
            Map<String, String> errorFiled = paramException.getErrorFileds();
            request.setAttribute("ERROR_FILED", errorFiled);
            request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
        } catch (ServiceException serviceException) {
            request.setAttribute("WRONG_MESSAGE", serviceException.getMessage() + "[" + serviceException.getCode() + "]");
            request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
        }
    }
}
