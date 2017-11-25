package olympus.mount.test.activities;

/**
 * Created by berni on 11/22/2017.
 */
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import android.widget.TextView;
import android.widget.Toast;

import olympus.mount.test.R;
import olympus.mount.test.main.MyTwitterApp;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
    }
    public void signinPressed (View view)
    {
        MyTwitterApp app = (MyTwitterApp) getApplication();

        TextView email     = (TextView)  findViewById(R.id.loginEmail);
        TextView password  = (TextView)  findViewById(R.id.loginPassword);

        if (app.validUser(email.getText().toString(), password.getText().toString()))
        {
            startActivity (new Intent(this, Tweet.class));
        }
        else
        {
            Toast toast = Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}





