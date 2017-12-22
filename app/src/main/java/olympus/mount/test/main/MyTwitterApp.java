package olympus.mount.test.main;
import android.app.Application;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


import olympus.mount.test.model.Portfolio;
import olympus.mount.test.model.Tweet;
import olympus.mount.test.model.User;

/**
 * Created by berni on 11/22/2017.
 *  guidance taken from https://wit-ictskills-2017.github.io/mobile-app-dev/topic03-b/book-a-myrent-02%20(Listview)/index.html#/03
 */


public class MyTwitterApp extends Application{

    public Portfolio portfolio;
    public final int target = 10000;
    public int totalTweeted = 0;
    public List<Tweet> tweets = new ArrayList<Tweet>();
    public List<User>     users     = new ArrayList<User>();
    public int totalTweeeted;

   public boolean newTweet(Tweet tweet) {
      boolean targetAchieved = totalTweeted > target;

       if(!targetAchieved) {
         portfolio.addTweet(tweet);
        }
        else {
            Toast toast = Toast.makeText(this, "Target Exceeded!", Toast.LENGTH_SHORT);
            toast.show();
        }
       return targetAchieved;
   }


    @Override
    public void onCreate()
    {
        super.onCreate();
        portfolio = new Portfolio();


    }

    public void newUser(User user)
    {
        users.add(user);
    }

    public boolean validUser (String email, String password)
    {
        for (User user : users)
        {
            if (user.email.equals(email) && user.password.equals(password))
            {
                return true;
            }
        }
        return false;
    }
}

