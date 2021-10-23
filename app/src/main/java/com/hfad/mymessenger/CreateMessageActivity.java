package com.hfad.mymessenger;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateMessageActivity extends Activity {
    public static final String MESSAGE = "MESSAGE";
    public static final String URGENT = "URGENT";

    //Declare instance variables for EditText and two Button Views
    EditText messageView;
    Button buttonSendToOtherApp;
    Button buttonSendToActivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_message);

        //TODO: assign findViewById values to all instance variables for all widgets
        messageView = findViewById(R.id.message);
        buttonSendToActivity = findViewById(R.id.sendExplicit);
        buttonSendToOtherApp = findViewById(R.id.sendImplicit);

        
        //TODO: Add a setOnClickListener to each Button
        buttonSendToActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessageToActivity();
            }
        });

        buttonSendToOtherApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessageToOtherApp();
            }
        });

    }

    //Call sendMessageToActivity when the "to Activity" button is clicked
    public void sendMessageToActivity(){
        //TODO: Create an explicit Intent for ReceiveMessageActivity; add the TextView message and start the new Activity
        Intent recieveMsgActivity = new Intent(CreateMessageActivity.this, ReceiveMessageActivity.class);
        String message = messageView.getText().toString();
        recieveMsgActivity.putExtra(MESSAGE, message);
        recieveMsgActivity.putExtra(URGENT, true);
        startActivity(recieveMsgActivity);
    }

    //Creates an IMPLICIT intent, adds the textView's message as a String, and sends it to a "Chooser" window for the user to pick
    public void sendMessageToOtherApp() {
        String messageText = messageView.getText().toString();
        Intent intent = new Intent(Intent.ACTION_SEND); intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, messageText);
        String chooserTitle = getString(R.string.chooser);
        Intent chosenIntent = Intent.createChooser(intent, chooserTitle);
        startActivity(chosenIntent);
    }
}
