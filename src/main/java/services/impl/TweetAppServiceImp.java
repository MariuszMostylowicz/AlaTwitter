package services.impl;

import DAO.AppUserDao;
import DAO.TweetDao;
import errors.ValidationError;
import models.AppUser;
import models.Tweet;
import services.TweetAppService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import static utils.ServletUtils.*;

public class TweetAppServiceImp implements TweetAppService {

    private AppUserDao appUserDao;
    private TweetDao tweetDao;

    public TweetAppServiceImp(AppUserDao appUserDao, TweetDao tweetDao) {
        this.appUserDao = appUserDao;
        this.tweetDao = tweetDao;
    }

    @Override
    public void registerUser(AppUser user) {
        appUserDao.saveUser(user);
    }

    @Override
    public List<ValidationError> validateUser(String login, String email) {
        List<ValidationError> errors = new ArrayList<>();
        if (isUserEmailInUse(email)) {
            errors.add(new ValidationError(EMAIL_ERROR_HEADER, EMAIL_ERROR_MESSAGE));
        }
        if (isUserLoginInUse(login)) {
            errors.add(new ValidationError(LOGIN_ERROR_HEADER, EMAIL_ERROR_MESSAGE));
        }
        return errors;
    }

    @Override
    public boolean isLoginAndPasswordValid(String login, String hashedPassword) {
        Optional<AppUser> userByLogin = appUserDao.getUserByLogin(login);
        if (userByLogin.isEmpty()) {
            return false;
        }
        String passFromDB = userByLogin.get().getPassword();
        return passFromDB.equals(hashedPassword);
    }

    @Override
    public HashSet<AppUser> getFollowedUsers(AppUser user) {
        return appUserDao.getFollowedUsers(user);
    }

    @Override
    public AppUser getUser(String userLogin) {
        return appUserDao.getUserByLogin(userLogin).get();
    }

    @Override
    public HashSet<AppUser> getNotFollowedUsers(AppUser user) {
        return appUserDao.getNotFollowedUsers(user);
    }

    @Override
    public HashSet<AppUser> getFollowers(AppUser user) {
        return appUserDao.getFollowers(user);
    }

    @Override
    public void follow(AppUser currentUser, AppUser toFollow) {
        appUserDao.follow(currentUser, toFollow);
    }

    @Override
    public void unfollow(AppUser currentUser, AppUser toStopFollow) {
        appUserDao.unfollow(currentUser, toStopFollow);
    }
    @Override
    public List<Tweet> getUserTweets(AppUser user) {
       return tweetDao.getUserTweets(user);
    }

    private boolean isUserLoginInUse(String userLogin) {
        return appUserDao
                .getUserByLogin(userLogin)
                .isPresent();
    }


    private boolean isUserEmailInUse(String userEmail) {
        return appUserDao
                .getUserByEmail(userEmail)
                .isPresent();
    }

    @Override
    public void addTweet(String userLogin, String message) {
        Tweet tweet = new Tweet(userLogin, message);
        tweetDao.save(tweet);
    }

    @Override
    public void deleteTweet(Long tweetId) {
        tweetDao.delete(tweetId);
    }
}
