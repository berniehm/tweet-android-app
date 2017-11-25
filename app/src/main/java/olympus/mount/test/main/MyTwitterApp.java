package olympus.mount.test.main;
import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import olympus.mount.test.activities.Tweet;
import olympus.mount.test.model.User;
import olympus.mount.test.model.Tweets;
/**
 * Created by berni on 11/22/2017.
 */


public class MyTwitterApp extends Application{


    public final int target = 10000;
    public int totalTweeted = 0;
    public List<Tweets> tweets = new ArrayList<Tweets>();
    public List<User>     users     = new ArrayList<User>();

    public boolean newTweet(Tweets tweets) {
        boolean targetAchieved = totalTweeted > target;

        if(!targetAchieved) {
           tweets.add();
            totalTweeted += tweets.amount;
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
        Log.v("Tweet","Tweet App Started");
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
