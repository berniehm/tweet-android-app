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

 public  class TweetActivities extends AppCompatActivity implements View.OnClickListener{

    private int target = 10000;
    private RadioGroup paymentMethod;
    private ProgressBar progressBar;
    private NumberPicker amountPicker;
    private EditText amountText;
    private TextView amountTotal;
    private Button tweetButton;
    private MyTwitterApp app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tweet);

        app           = (MyTwitterApp)getApplication();
        paymentMethod = (RadioGroup)   findViewById(R.id.paymentMethod);
        progressBar   = (ProgressBar)  findViewById(R.id.progressBar);
        amountPicker  = (NumberPicker) findViewById(R.id.amountPicker);
        amountTotal   = (TextView)     findViewById(R.id.amountTotal);
        amountText    = (EditText)     findViewById(R.id.amountText);
        tweetButton  = (Button)       findViewById(R.id.tweetButton);

        amountPicker.setMinValue(0);
        amountPicker.setMaxValue(1000);
        progressBar.setMax(target);
        tweetButton.setOnClickListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
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

    public void tweetButtonPressed(View view)
    {
        String method = paymentMethod.getCheckedRadioButtonId() == R.id.payPal ? "" : "Direct";

        int tweetedAmount = amountPicker.getValue();
        if (tweetedAmount == 0) {
            String text = amountText.getText().toString();
            if (!text.equals(""))
                tweetedAmount = Integer.parseInt(text);
        }

    }
     @Override
     public void onClick(View v) {
         switch (v.getId())
         {
             case R.id.tweetButton: tweetButtonPressed(v);
         }
     }
 }