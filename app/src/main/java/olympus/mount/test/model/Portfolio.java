package olympus.mount.test.model;
/**
 * Created by berni on 11/25/2017.
 * Guidance taken from https://wit-ictskills-2017.github.io/mobile-app-dev/topic03-b/book-a-myrent-02%20(Listview)/index.html#/05
 */

import android.util.Log;

import java.util.ArrayList;

public class Portfolio {
    public ArrayList<Tweet> tweets;

    public Portfolio() {
        tweets = new ArrayList<Tweet>();
        this.generateTestData();
    }

    public void addTweet(Tweet tweet){
      addTweet(tweet) ;
    }

    public Tweet getTweet(Long id) {
        Log.i(this.getClass().getSimpleName(), "Long parameter id: " + id);

        for (Tweet s : tweets) {
            if (id.equals(s.id)) {
                return s;
            }
        }
        return null;
    }

    private void generateTestData() {
        for (int i = 0; i < 100; i += 1) {
            Tweet s = new Tweet(toString());

            {

                if (i % 2 == 0) {
                    s.tweeted = true;
                } else {
                    s.tweeted = false;
                }
                tweets.add(s);
            }
        }
    }
}
