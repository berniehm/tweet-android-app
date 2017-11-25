package olympus.mount.test.activities;

/**
 * Created by berni on 11/25/2017.
 */

import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import olympus.mount.test.R;
import olympus.mount.test.main.MyTwitterApp;
import olympus.mount.test.model.Tweets;

public class Report extends AppCompatActivity {
    private ListView listView;
    private MyTwitterApp app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        app = (MyTwitterApp) getApplication();
        listView = (ListView) findViewById(R.id.reportList);
        TweetsAdapter adapter = new TweetsAdapter(this, app.tweets);
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_report, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.tweet:
                startActivity(new Intent(this, Tweet.class));
                break;
            case R.id.accept:
             // startActivity(new Intent(this, Accept.class));
                break;
            case R.id.message:
                startActivity(new Intent(this, Message.class));
                break;
            case R.id.tweets:
                startActivity(new Intent(this, Tweets.class));
                break;
        }
        return true;
    }

}


    class TweetsAdapter extends ArrayAdapter<Tweets> {
        private Context context;
        public List<Tweets> tweets;

        public TweetsAdapter(Context context, List<Tweets> tweets) {
            super(context, R.layout.row_layout, tweets);
            this.context = context;
            this.tweets = tweets;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View view = inflater.inflate(R.layout.row_layout, parent, false);
            Tweets tweet = tweets.get(position);
            TextView amountView = (TextView) view.findViewById(R.id.row_amount);
            TextView methodView = (TextView) view.findViewById(R.id.row_method);

            amountView.setText("" + tweet.amount);
          //  methodView.setText(tweets.method);

            return view;
        }

        @Override
        public int getCount() {
            return tweets.size();
        }

    }

