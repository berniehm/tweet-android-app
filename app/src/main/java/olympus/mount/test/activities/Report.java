package olympus.mount.test.activities;

/**
 * Created by berni on 11/25/2017.
 */

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import olympus.mount.test.R;
import olympus.mount.test.main.MyTwitterApp;
import olympus.mount.test.model.Tweet;

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


    //  @Override
    // public boolean onOptionsItemSelected(MenuItem item) {
    // {
    //     case menuTweet:   startActivity(new Intent(this, TweetActivities.class));
    //         break;
    //     case menuSettings: Toast.makeText(this, "Settings Selected", Toast.LENGTH_SHORT).show();
    //         break;
    //    case menuLogout:   startActivity(new Intent(this, Welcome.class));
    //         break;
    //  }
    //   return true;
    // }

//}


    class TweetsAdapter extends ArrayAdapter<Tweet> {
        private Context context;
        public List<Tweet> tweets;

        public TweetsAdapter(Context context, List<Tweet> tweets) {
            super(context, R.layout.row_layout, tweets);
            this.context = context;
            this.tweets = tweets;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View view = inflater.inflate(R.layout.row_layout, parent, false);
            Tweet tweet = tweets.get(position);
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
}

