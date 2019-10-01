package com.hfad.mymessenger;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CreateMessageActivity extends Activity {

    //TODO: Declare instance variables for EditText and two Button Views
    EditText messageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_message);
        //TODO: assign findViewById values to all View variables
        messageView = (EditText)findViewById(R.id.message);


        //TODO: Add an Event Listener to each Button

    }

    //TODO: Create a "to Activity" method that uses an explicit Intent
    //      to call the ReceiveMessageActivity
    public void onSendMessageToActivity(View view){

    }

    //Call onSendMessage() when the "to App" button is clicked
    public void onSendMessageToApp(View view) {
        String messageText = messageView.getText().toString();
        Intent intent = new Intent(Intent.ACTION_SEND); intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, messageText);
        String chooserTitle = getString(R.string.chooser);
        Intent chosenIntent = Intent.createChooser(intent, chooserTitle);
        startActivity(chosenIntent);
    }
}
