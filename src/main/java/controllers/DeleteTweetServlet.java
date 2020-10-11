package controllers;

import DAO.imp.MySQLTweetDao;
import DAO.imp.MySQLUserDao;
import services.TweetAppService;
import services.impl.TweetAppServiceImp;
import utils.ServletUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteTweetServlet", value = "/deleteTweet")
public class DeleteTweetServlet extends HttpServlet {
    private TweetAppService service;

    @Override
    public void init() throws ServletException {
        service = new TweetAppServiceImp(new MySQLUserDao(), new MySQLTweetDao());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long tweetId = ServletUtils.getTweetIdToDelete(req);
        service.deleteTweet(tweetId);
        req.getRequestDispatcher("messages").forward(req, resp);
    }
}
