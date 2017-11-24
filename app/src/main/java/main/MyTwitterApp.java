package main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import olympus.mount.test.R;
import olympus.mount.test.Signup;
import olympus.mount.test.Welcome;

/**
 * Created by berni on 11/22/2017.
 */


public class MyTwitterApp extends AppCompatActivity {

    private Signup app;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tweet);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        // inflater.inflate(R.menu.menu_mytweet, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
             case R.id.settings:
             Toast.makeText(this, "Settings Selected", Toast.LENGTH_SHORT).show();
               break;
            case R.id.menuLogout:
               startActivity(new Intent(this, Welcome.class));
                break;
        }
        return true;
    }


//activity for when tweet button is pressed

public void tweetButtonPressed(View view) {
   //MyTwitterApp app = MyTwitterApp getApplication();

   Toast toast = Toast.makeText(this, "Message Sent", Toast.LENGTH_SHORT);
   toast.show();

 }
}
