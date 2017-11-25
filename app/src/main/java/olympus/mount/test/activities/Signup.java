package olympus.mount.test.activities;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import olympus.mount.test.R;
import olympus.mount.test.main.MyTwitterApp;
import olympus.mount.test.model.User;

/**
 * Created by berni on 11/22/2017.
 */


public class Signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
    }

    public void signupPressed(View view) {

        TextView firstName = (TextView)  findViewById(R.id.firstName);
        TextView lastName  = (TextView)  findViewById(R.id.lastName);
        TextView email     = (TextView)  findViewById(R.id.Email);
        TextView password  = (TextView)  findViewById(R.id.Password);

        User user = new User (firstName.getText().toString(), lastName.getText().toString(), email.getText().toString(), password.getText().toString());

        MyTwitterApp app = (MyTwitterApp) getApplication();
        app.newUser(user);

        startActivity (new Intent(this, Welcome.class));
    }
    }