package com.hfad.mymessenger;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

public class ReceiveMessageActivity extends Activity {

    private static final String EXTRA_MESSAGE = "message";
    private static final String EXTRA_URGENT = "urgent";

    private TextView messageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_message);
        Intent intent = getIntent();
        String messageText = intent.getStringExtra(EXTRA_MESSAGE);
        Boolean isUrgent = intent.getBooleanExtra(EXTRA_URGENT, false);

        messageView = (TextView)findViewById(R.id.message);

        if(isUrgent){
            messageView.setTextColor(Color.RED);
        }

        messageView.setText(messageText);
    }
}
