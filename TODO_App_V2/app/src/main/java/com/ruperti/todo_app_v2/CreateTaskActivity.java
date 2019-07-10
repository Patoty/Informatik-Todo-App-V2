package com.ruperti.todo_app_v2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

public class CreateTaskActivity extends AppCompatActivity {

    String Task_Name;
    int Task_Date;
    int Task_Time;

    EditText Task_NameInput;
    EditText Task_DateInput;
    EditText Task_TimeInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_task);

        Task_NameInput = (EditText)findViewById(R.id.Text_Task_Name);
        Task_DateInput = (EditText)findViewById(R.id.Text_Task_Date);
        Task_TimeInput = (EditText)findViewById(R.id.Text_Task_Time);


    }

}
