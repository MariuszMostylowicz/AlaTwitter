package services;

import errors.ValidationError;
import models.AppUser;
import models.Tweet;

import java.util.HashSet;
import java.util.List;

public interface TweetAppService {


    List<ValidationError> validateUser(String login, String email);

    void registerUser(AppUser user);

    boolean isLoginAndPasswordValid(String login, String hashedPassword);

    HashSet<AppUser> getFollowedUsers(AppUser user);

    AppUser getUser(String userLogin);

    HashSet<AppUser> getNotFollowedUsers(AppUser user);

    HashSet<AppUser> getFollowers(AppUser user);

    void follow(AppUser currentUser, AppUser toFollow);

    void unfollow(AppUser currentUser, AppUser toStopFollow);

    List<Tweet> getUserTweets(AppUser user);

    void addTweet(String userLogin, String message);

    void deleteTweet(Long tweetId);


}
