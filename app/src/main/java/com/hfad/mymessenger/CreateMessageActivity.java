package com.hfad.mymessenger;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateMessageActivity extends Activity {

    //Declare instance variables for EditText and two Button Views
    EditText messageView;
    Button buttonToApp;
    Button buttonToActivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_message);
        //TODO: assign findViewById values to all instance variables
        buttonToApp = (Button) findViewById(R.id.sendExplicit);
        buttonToActivity = (Button) findViewById(R.id.sendImplicit);
        messageView = (EditText) findViewById(R.id.message);


        //TODO: Add a setOnClickListener to each Button
        buttonToApp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            }
        });

        buttonToActivity.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sendMessageToActivity();
            }
        });
    }

//test test test test

    //Call sendMessageToActivity when the "to Activity" button is clicked
    public void sendMessageToActivity(){
        //TODO: Use an explicit Intent to invoke the ReceiveMessageActivity with the message
        Intent Activity2Intent = new Intent(getApplicationContext(), CreateMessageActivity.class);
        startActivity(Activity2Intent);
        Activity2Intent.getStringExtra("message");
    }

    //Call sendMessageToApp() when the "to App" button is clicked
    public void sendMessageToApp() {
        String messageText = messageView.getText().toString();
        Intent intent = new Intent(Intent.ACTION_SEND); intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, messageText);
        String chooserTitle = getString(R.string.chooser);
        Intent chosenIntent = Intent.createChooser(intent, chooserTitle);
        startActivity(chosenIntent);
    }
}
