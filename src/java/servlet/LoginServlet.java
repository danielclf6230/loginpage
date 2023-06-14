package servlet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.User;
import services.AccountService;

/**
 *
 * @author danielchow
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String requestedURL = request.getRequestURI();
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");

        if (action != null) {
            
            session.invalidate();
            request.setAttribute("LogoutMessage", "You have successfully logged out");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                    .forward(request, response);
        }
        if (username != null) {
            if (requestedURL.contains("/login") || requestedURL.endsWith("/")) {
                response.sendRedirect("home");
            }
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                    .forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("Username");
        String pass = request.getParameter("Password");

        if (name == null || name.isEmpty() || pass == null || pass.isEmpty()) {
            request.setAttribute("errorMessage", "Invalid username or password");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp")
                    .forward(request, response);
        } else {
            AccountService accountService = new AccountService();
            User user = accountService.login(name, pass);

            if (user != null) {
                HttpSession session = request.getSession();
                session.setAttribute("username", user.getUsername());
                response.sendRedirect("home");
            } else {
                request.setAttribute("errorMessage", "The username or password is incorrect");
                request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            }
        }

    }
}
