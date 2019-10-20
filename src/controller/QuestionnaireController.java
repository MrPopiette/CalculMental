package controller;

import bo.Questionnaire;
import model.LoginBean;
import model.QuestionnaireBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (name = "questionnaireController", urlPatterns = {"/questionnaire"})
public class QuestionnaireController extends HttpServlet {

    private static final String PAGE_QUESTIONNAIRE = "/questionnaire.jsp";
    private static final String PATH_RESULTAT_JSP = "/resultat.jsp";
    private static final String PAGE_LOGIN = "jsp/login.jsp";

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        QuestionnaireBean modelQuestionnaire = new QuestionnaireBean();
        LoginBean modelLogin = new LoginBean();
        if(modelLogin.isConnected(request)){
            response.sendRedirect(request.getContextPath() + PAGE_QUESTIONNAIRE);
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
