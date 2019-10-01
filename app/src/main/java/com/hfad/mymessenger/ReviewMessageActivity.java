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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_message);

        Button sendButton = (Button)findViewById(R.id.sendMessage);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSendClick();
            }
        });

        getReviewTextView().setText(getIntent().getStringExtra(EXTRA_MESSAGE));
    }

    private TextView getReviewTextView(){
        return (TextView)findViewById(R.id.review);
    }

    private CheckBox getCheckBoxForUrgency(){
        return (CheckBox)findViewById(R.id.urgent);
    }

    private void onSendClick(){
        Intent intent = new Intent(this, ReceiveMessageActivity.class);

        intent.setType("text/plain");
        intent.putExtra( EXTRA_MESSAGE, getReviewTextView().getText().toString());
        intent.putExtra( EXTRA_URGENT, getCheckBoxForUrgency().isChecked());

        startActivity(intent);
    }
}
