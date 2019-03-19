package ca.ualberta.cs.Diodone;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class EditTweetActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_tweet);
        Intent intent = getIntent();
        NormalTweet theTweet = intent.getParcelableExtra("NormalTweet");
        TextView ourView = findViewById(R.id.textView);
        ourView.setText(theTweet.getMessage());
    }
}
