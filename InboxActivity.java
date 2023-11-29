package com.example.personaltutoringservice;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class InboxActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private EditText inputMessage;
   // private ChatAdapter chatAdapter; // Add this line
    private List<String> chatMessages; // Add this line


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inbox);

        // Initialize views
        recyclerView = findViewById(R.id.chatRecycler);
        inputMessage = findViewById(R.id.inputMessage);

        // Initialize chat messages list
        chatMessages = new ArrayList<>();

        // Initialize RecyclerView and adapter
       // chatAdapter = new ChatAdapter(chatMessages); // Add this line
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //recyclerView.setAdapter(chatAdapter);

        // Handle send button click
        findViewById(R.id.layoutSend).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMessage();
            }
        });
    }

    private void sendMessage() {
        // Get the text from the input field
        String messageText = inputMessage.getText().toString().trim();

        // Check if the message is not empty
        if (!messageText.isEmpty()) {
            // Add the message to the list
            chatMessages.add("You: " + messageText);

            // Notify the adapter that the data set has changed
            //chatAdapter.notifyDataSetChanged();

            // Clear the input field
            inputMessage.setText("");
        }
    }

}