package com.hfad.mymessenger;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ReceiveMessageActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_message);
        Intent intent = getIntent();
        String messageText = intent.getStringExtra(CreateMessageActivity.MESSAGE);
        boolean messageUrgent = intent.getBooleanExtra("Urgent", false);
        TextView messageView = (TextView)findViewById(R.id.message);
        messageView.setText(messageText);

    }
}
