package controller;

import model.LoginBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet (name = "loginController", urlPatterns = {"/login"} )
public class LoginController extends HttpServlet {

    private static final String PAGE_LOGIN = "/WEB-INF/jsp/login.jsp";
    private static final String PATH_HOME_JSP = "/index.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        LoginBean model = new LoginBean();
        if(model.isConnected(request)){
            response.sendRedirect(request.getContextPath() + PATH_HOME_JSP);
        } else{
            request.getRequestDispatcher(PAGE_LOGIN).forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        LoginBean model = new LoginBean();
        model.authenticate(request);
        request.setAttribute("loginBean", model);
        doGet(request, response);


    }


}
