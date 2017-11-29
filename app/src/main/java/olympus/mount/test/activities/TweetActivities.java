package olympus.mount.test.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import olympus.mount.test.R;
import olympus.mount.test.main.MyTwitterApp;

/**
 * Created by berni on 11/22/2017.
 */

public class TweetActivities extends AppCompatActivity implements View.OnClickListener {
    private int target = 240;
    private ProgressBar progressBar;
    private MyTwitterApp app;
    private TextView amountTotal;
    private Button tweetButton;
    private NumberPicker amountPicker;
    public int amount;
    private EditText amountText;
    private RadioGroup tweetMethod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tweet);

        app = (MyTwitterApp)            getApplication();
        amountPicker = (NumberPicker)   findViewById(R.id.amountPicker);
        amountTotal = (TextView)        findViewById(R.id.amountTotal);
        progressBar = (ProgressBar)     findViewById(R.id.progressBar);
        amountTotal = (TextView)        findViewById(R.id.amountTotal);

        tweetButton = (Button)          findViewById(R.id.tweetButton);

        amountPicker.setMinValue(0);
        amountPicker.setMaxValue(240);
        progressBar.setMax(target);
        tweetButton.setOnClickListener( this);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.report:
            startActivity(new Intent(this, Report.class));
            break;
            case R.id.menuReport:   startActivity(new Intent(this, Report.class));
                break;
            case R.id.menuSettings: Toast.makeText(this, "Settings Selected", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuLogout:   startActivity(new Intent(this, Welcome.class));
                break;
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_tweet, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void tweetButtonPressed(View view) {
        String method = tweetMethod.getCheckedRadioButtonId() == R.id.twitter ? "twitter" : "Facebook";

        int tweetedAmount = amountPicker.getValue();
        if (tweetedAmount == 0) {
            String text = amountText.getText().toString();
            if (!text.equals(""))
                tweetedAmount = Integer.parseInt(text);
        }

        if (tweetedAmount > 0) {
            app.newTweet(new olympus.mount.test.model.Tweet(tweetedAmount, method));
            progressBar.setProgress(app.totalTweeted);
            String totalTweetedStr = "$" + app.totalTweeted;
            amountTotal.setText(totalTweetedStr);
            amountPicker.setValue(0);
            amountText.setText("");
        }
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tweetButton:
                tweetButtonPressed(v);
        }
    }
}

