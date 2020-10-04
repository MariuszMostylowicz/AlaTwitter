import DAO.AppUserDao;
import DAO.TweetDao;
import DAO.imp.MySQLTweetDao;
import DAO.imp.MySQLUserDao;
import models.AppUser;
import models.Tweet;

import java.util.List;

public class TempTest {
    public static void main(String[] args) {
        AppUserDao dao = new MySQLUserDao();
        TweetDao tweetDao= new MySQLTweetDao();
        AppUser user1 = AppUser.UserBuilder.getBuilder()
                .name("Mark")
                .lastName("1")
                .email("1@1")
                .password("aaa")
                .login("lol")
                .build();

        AppUser user2 = AppUser.UserBuilder.getBuilder()
                .name("Anna")
                .lastName("Big")
                .email("2@2")
                .password("aaa1")
                .login("lol1")
                .build();
        AppUser user3 = AppUser.UserBuilder.getBuilder()
                .name("Henk")
                .lastName("3")
                .email("3@3")
                .password("aaa2")
                .login("lol2")
                .build();

        dao.saveUser(user1);
        Tweet tweet = new Tweet(user1.getLogin(), "afwefsefsdfgrhrt");
        tweetDao.save(tweet);

        System.out.println("--------------------");
        List<Tweet> userTweets = tweetDao.getUserTweets(user1);
        userTweets.forEach(System.out::println);
        System.out.println("---------------");
        dao.deleteUser(user1);

    }
}




