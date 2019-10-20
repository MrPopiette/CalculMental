package controller;

import model.HomeBean;
import model.LoginBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet (name = "homeController", urlPatterns = {"/home"} )
public class HomeController extends HttpServlet {

    private static final String PAGE_LOGIN = "/login";
    private static final String PATH_HOME_JSP = "/WEB-INF/jsp/home.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        LoginBean model = new LoginBean();
        if(model.isConnected(request)){
            HomeBean homeBean = new HomeBean();
            homeBean.getScores();
            request.setAttribute("homeBean", homeBean);

            request.getRequestDispatcher(PATH_HOME_JSP).forward(request, response);
        } else{
            response.sendRedirect(request.getContextPath() + PAGE_LOGIN);
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
