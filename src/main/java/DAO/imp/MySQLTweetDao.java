package DAO.imp;

import DAO.AbstractMySQLDao;
import DAO.TweetDao;
import models.AppUser;
import models.Tweet;


import javax.persistence.TypedQuery;

import java.util.List;

public class MySQLTweetDao extends AbstractMySQLDao implements TweetDao {


    @Override
    public void save(Tweet tweet) {
        hibernateUtil.save(tweet);
    }

    @Override
    public void delete(Long tweetId) {
    hibernateUtil.delete(Tweet.class, tweetId);
    }

    @Override
    public List<Tweet> getUserTweets(AppUser user) {
        TypedQuery<Tweet> query = em.createQuery("select t from Tweet t where t.author= :login", Tweet.class);
        query.setParameter("login", user.getLogin());
        return query.getResultList();
    }

    @Override
    public Tweet getTweet(Long id) {
        return em.find(Tweet.class, id);
    }
}
