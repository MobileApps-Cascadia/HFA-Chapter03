package com.hfad.mymessenger;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class ReviewMessageActivity extends Activity {

    private static final String EXTRA_MESSAGE = "message";
    private static final String EXTRA_URGENT = "urgent";

    private Button sendButton;
    private TextView review;
    private CheckBox isUrgent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_message);

        sendButton = (Button)findViewById(R.id.sendMessage);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSendClick();
            }
        });

        review = (TextView)findViewById(R.id.review);
        isUrgent = (CheckBox)findViewById(R.id.urgent);

        review.setText(getIntent().getStringExtra(EXTRA_MESSAGE));
    }

    private void onSendClick(){
        Intent intent =
                new Intent(this, ReceiveMessageActivity.class)
                        .setType("text/plain")
                        .putExtra( EXTRA_MESSAGE, review.getText().toString())
                        .putExtra( EXTRA_URGENT, isUrgent.isChecked());

        startActivity(intent);
    }
}
