package com.ruperti.todo_app_v2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.SeekBar;

import java.util.Date;

public class CreateTaskActivity extends AppCompatActivity {

    String taskName;
    Date taskDate;
    int taskUrgency;
    int taskImportance;
    int taskDuration;

    EditText Task_NameInput;
    EditText Task_DateInput;
    EditText Task_TimeInput;
    EditText Task_DurationInputHours;
    EditText Task_DurationInputMinutes;
    SeekBar Task_ImportanceBar;
    SeekBar Task_UrgencyBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_task);

        Task_NameInput = (EditText)findViewById(R.id.Text_Task_Name);
        Task_DateInput = (EditText)findViewById(R.id.Text_Task_Date);
        Task_TimeInput = (EditText)findViewById(R.id.Text_Task_Time);
        Task_DurationInputHours = (EditText) findViewById(R.id.editText5);
        Task_DurationInputMinutes = (EditText) findViewById(R.id.editText4);
        Task_ImportanceBar = (SeekBar) findViewById(R.id.seekBarImportance);
        Task_UrgencyBar = (SeekBar) findViewById(R.id.seekBarUrgency);


    }

    public void saveTaskButton(View view){

        //create Task
        taskName = Task_NameInput.toString();
        taskDate = new Date(Task_DateInput.toString());
        taskDuration = Integer.parseInt(Task_DurationInputHours.toString()) * 60 + Integer.parseInt(Task_DurationInputMinutes.toString());
        taskImportance = Task_ImportanceBar.getProgress();
        taskUrgency = Task_UrgencyBar.getProgress();

        Task task = new Task(taskName, false, taskDuration, taskImportance, taskUrgency, taskDate);
        


        //go back to the main activity
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }



}
