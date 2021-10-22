package com.hfad.mymessenger;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateMessageActivity extends Activity {
    public static final String MESSAGE = "MESSAGE";

    //Declare instance variables for EditText and two Button Views
    EditText messageView;
    Button buttonSendToOtherApp;
    Button buttonSendToActivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_message);
        //assign findViewById values to all instance variables for all widgets
        messageView = findViewById(R.id.message);
        buttonSendToOtherApp = findViewById(R.id.sendImplicit);
        buttonSendToActivity = findViewById(R.id.sendExplicit);
        
        //Add a setOnClickListener to each Button
        buttonSendToOtherApp.setOnClickListener(v -> sendMessageToOtherApp());
        buttonSendToActivity.setOnClickListener(v -> sendMessageToActivity());

    }

    //Call sendMessageToActivity when the "to Activity" button is clicked
    public void sendMessageToActivity(){
        //Create an explicit Intent for ReceiveMessageActivity; add the TextView message and start the new Activity
        String messageText = messageView.getText().toString();
        Intent ReceiveMessageActivity = new Intent(this, com.hfad.mymessenger.ReceiveMessageActivity.class);
        ReceiveMessageActivity.putExtra(MESSAGE, messageText);
        ReceiveMessageActivity.putExtra("urgent", true);
        startActivity(ReceiveMessageActivity);


    }

    //Creates an IMPLICIT intent, adds the textView's message as a String, and sends it to a "Chooser" window for the user to pick
    public void sendMessageToOtherApp() {
        String messageText = messageView.getText().toString();
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, messageText);
        String chooserTitle = getString(R.string.chooser);
        Intent chosenIntent = Intent.createChooser(intent, chooserTitle);
        startActivity(chosenIntent);
    }
}
