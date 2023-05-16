package com.example.mpnn;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView notificationTextView;
    private Button sendNotificationButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notificationTextView = findViewById(R.id.notificationTextView);
        sendNotificationButton = findViewById(R.id.sendNotificationButton);


        FirebaseMessaging.getInstance().setAutoInitEnabled(true);

        // Registrar MyFirebaseMessagingService
        FirebaseMessaging.getInstance().subscribeToTopic("notifications");


        sendNotificationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FirebaseMessaging.getInstance().send(new RemoteMessage.Builder("956145438371" + "@gcm.googleapis.com")
                        .setMessageId(Integer.toString(new Random().nextInt(9999)))
                        .addData("my_key", "my_value")
                        .build());
            }
        });
    }
}
