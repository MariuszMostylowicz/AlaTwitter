package controllers;

import DAO.imp.MySQLTweetDao;
import DAO.imp.MySQLUserDao;
import services.TweetAppService;
import services.impl.TweetAppServiceImp;
import utils.ServletUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LogOutServlet", value = "/logout")
public class LogOutServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        for (Cookie cookie: req.getCookies()) {
            if (cookie.getName().equals(ServletUtils.USER_LOGIN) || (cookie.getName().equals(ServletUtils.USER_PASSWORD))){
                cookie.setMaxAge(0);
                resp.addCookie(cookie);
            }

        }
        req.getRequestDispatcher("/login.jsp").forward(req, resp);

    }




}