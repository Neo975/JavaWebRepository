package servlets;

import accounts.AccountService;
import accounts.UserProfile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by user on 09.01.2016.
 */
public class SignInServlet extends HttpServlet{
    private final AccountService accountService;

    public SignInServlet(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    //Get public user profile
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    //Sign up
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        if(login == null || password == null) {
            response.setContentType("text/html;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        if(accountService.getUserByLogin(login) == null) {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().println("Unauthorized");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        } else {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().println("Authorized");
            response.setStatus(HttpServletResponse.SC_OK);
        }
    }

    @Override
    //Change profile
    public void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    //Unregister
    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
