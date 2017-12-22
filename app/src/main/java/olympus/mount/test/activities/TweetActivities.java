package olympus.mount.test.activities;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;

import olympus.mount.test.R;
import olympus.mount.test.main.MyTwitterApp;
import olympus.mount.test.model.Portfolio;
import olympus.mount.test.model.Tweet;


public class TweetActivities extends Activity implements TextWatcher {

    private Button tweetButton;
    private MyTwitterApp app;
    private EditText message;
    private Tweet tweet;
    private Portfolio portfolio;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actvity_tweet);

        message = (EditText) findViewById(R.id.tweets_list_item_message);
        tweet = new Tweet();

        MyTwitterApp app = (MyTwitterApp) getApplication();
        portfolio = app.portfolio;

    }

    public void updateControls(Tweet tweet) {
        message.setText(tweet.message);

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tweet, menu);
        return true;
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {
        tweet.setMessage(editable.toString());

    }
}
