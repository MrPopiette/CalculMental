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

    private static final String PAGE_QUESTIONNAIRE = "/WEB-INF/jsp/questionnaire.jsp";
    private static final String PATH_RESULTAT_JSP = "/WEB-INF/jsp/resultat.jsp";
    private static final String PAGE_LOGIN = "/login";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        QuestionnaireBean modelQuestionnaire = new QuestionnaireBean();


        LoginBean modelLogin = new LoginBean();
        if(modelLogin.isConnected(request)){
            Questionnaire questionnaire = new Questionnaire();
            if(request.getParameter("done") == "true"){
                response.sendRedirect(request.getContextPath() + PATH_RESULTAT_JSP);
            }
            request.setAttribute("questionnaire", questionnaire);
            request.getRequestDispatcher(PAGE_QUESTIONNAIRE).forward(request, response);
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
