package com.ruperti.todo_app_v2;

import android.content.Context;

import java.util.Date;

public class Task extends Datenelement {
    private int id;
    private String taskName;
    private boolean isDone;
    private int duration, importance, urgency, priority;
    Date dueDate;

    public Task (String taskName){
        setTaskName(taskName);
    }

    public Task(int id, String taskName, boolean isDone, int duration, int importance, int urgency,  Date dueDate){
        setTaskName(taskName);
        setDone(isDone);
        setDuration(duration); // 1 = eine Minute, für eine Stunde 60, ...
        setImportance(importance);
        setUrgency(urgency);
        setPriority(this.importance, this.urgency);
        setDueDate(dueDate);
        TaskDatabase db = TaskDatabase.getInstance(new String(Context.STORAGE_SERVICE));//TODO: learn about android context, get context right, maybe in Activity-class
        db.createTask(this);
    }



    public int getId() {
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getImportance() {
        return importance;
    }

    public void setImportance(int importance) {
        if (importance>100) this.importance = 100;
        else if (importance < 0 ) this.importance = 0;
        else this.importance = importance;
    }

    public int getUrgency() {
        return urgency;
    }

    public void setUrgency(int urgency) {
        if (urgency>100) this.urgency = 100;
        if (urgency<0) this.urgency = 0;
        else this.urgency = urgency;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int importance, int urgency) {
        try{
            this.priority = (int) Math.sqrt(importance * importance + urgency * urgency);
        }catch (Exception e) {
            this.priority = 0;
        }
    }

    public Date getDueDate(){
        return this.dueDate;
    }

    public void setDueDate(Date dueDate){
        this.dueDate = dueDate;
    }


    //The methods relevant to the tree for sorting
    @Override
    public void setValue(int value) {
        // TODO Auto-generated method stub
        super.setValue(value);
    }

    @Override
    public int getValue() {
        // TODO Auto-generated method stub
        return super.getValue();
    }

    @Override
    public int compareToImportance(Task d) {
        // TODO Auto-generated method stub
        if (this.importance > d.getImportance()) {
            return 1;
        }else if (this.importance < d.getImportance()) {
            return -1;
        }else {
            return 0;
        }
    }

    public int compareToUrgency(Task d) {
        // TODO Auto-generated method stub
        if (this.urgency > d.getUrgency()) {
            return 1;
        }else if (this.urgency < d.getUrgency()) {
            return -1;
        }else {
            return 0;
        }
    }

    public int compareToPriority(Task d) {
        // TODO Auto-generated method stub
        if (this.priority > d.getPriority()) {
            return 1;
        }else if (this.priority < d.getPriority()) {
            return -1;
        }else {
            return 0;
        }
    }

    public int compareToDuration(Task d) {
        // TODO Auto-generated method stub
        if (this.duration > d.getDuration()) {
            return 1;
        }else if (this.duration < d.getDuration()) {
            return -1;
        }else {
            return 0;
        }
    }



}
