package olympus.mount.test.model;

import java.util.Random;

/**
 * Created by berni on 11/25/2017.
 */


public class Tweet {


    public String message;
    private String tweet;
    public boolean tweeted;
    public Long id;
    public Long date;

    public Tweet(String s ) {
        message = s;
    }
    public Tweet()
    {
        id = unsignedLong();
    }
    private Long unsignedLong() {
        long rndVal = 0;
        do {
            rndVal = new Random().nextLong();
        } while (rndVal <= 0);
        return rndVal;
    }


    public void setMessage(String s) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
    public String getDateString() {
        return "Registered:" + dateString();
    }
    private String dateString() {
        String dateFormat = "EEE d MMM yyyy H:mm";
        return android.text.format.DateFormat.format(dateFormat, date).toString();
    }

    }


