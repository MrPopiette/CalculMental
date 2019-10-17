package controller;

import bo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet (name = "loginController", urlPatterns = {"/login"} )
public class LoginController extends HttpServlet {

    private static final String PAGE_LOGIN = "/jsp/login.jsp";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(true);

        List<User> dataSession = (List<User> ) session.getAttribute("login");

        if (dataSession == null){
            dataSession = new ArrayList<>();
            dataSession.add( new User(0, "taral", "lol", 0));
            dataSession.add(new User( 1, "popiette", "lol", 0));
            session.setAttribute("login", dataSession);
        }

        String action = request.getParameter("action");
        if(action == null){
            request.getRequestDispatcher( PAGE_LOGIN ).forward(request, response);
        }
    }


}
