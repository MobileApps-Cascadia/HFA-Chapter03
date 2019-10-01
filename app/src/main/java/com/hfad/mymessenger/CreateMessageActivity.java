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
        messageView = (EditText)findViewById(R.id.message);
        buttonToApp = (Button)findViewById(R.id.sendImplicit);
        buttonToActivity = (Button)findViewById(R.id.sendExplicit);

        //TODO: Add a setOnClickListener to each Button
        buttonToActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessageToActivity();
            }
        });

        buttonToApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessageToApp();
            }
        });
    }

    //Call sendMessageToActivity when the "to Activity" button is clicked
    public void sendMessageToActivity(){
        //TODO: Use an explicit Intent to invoke the ReceiveMessageActivity with the message
        Intent intent = new Intent(this, ReceiveMessageActivity.class);
        intent.putExtra("message", getTextFromEditView());
        startActivity(intent);
    }

    private String getTextFromEditView(){
        return messageView.getText().toString();
    }

    //Call sendMessageToApp() when the "to App" button is clicked
    public void sendMessageToApp() {
        Intent intent = new Intent(Intent.ACTION_SEND); intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, getTextFromEditView());
        String chooserTitle = getString(R.string.chooser);
        Intent chosenIntent = Intent.createChooser(intent, chooserTitle);
        startActivity(chosenIntent);
    }
}
