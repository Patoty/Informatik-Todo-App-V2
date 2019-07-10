package com.ruperti.todo_app_v2;


import android.content.Intent;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.support.v4.app.NotificationCompat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Task> taskList = new ArrayList<Task>();
    private ImageButton PlusButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        PlusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivityCreateTask();
            }
        });

    }
    private void openActivityCreateTask() {
        Intent intent = new Intent(this,CreateTaskActivity.class);
        startActivity(intent);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, NotificationChannel.DEFAULT_CHANNEL_ID)
                .setContentTitle("")
                .setContentText("")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

    }

    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "To-Do App";
            String description = "Task reminders";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(NotificationChannel.DEFAULT_CHANNEL_ID, name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }

    }

    public void sortByDurationButton(View view){
        this.taskList = Sort.sort(taskList, 2);
    }
    public void sortByUrgencyButton(View view){
        this.taskList = Sort.sort(taskList, 1);
    }

    public void sortByImportanceButton(View view){
        this.taskList = Sort.sort(taskList, 0); }

    public void sortByTimeButton(View view){
        this.taskList = Sort.sort(taskList, 3);
    }
}
