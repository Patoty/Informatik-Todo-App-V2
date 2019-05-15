package com.ruperti.todo_app_v2;

import java.util.Date;

public class Task {

    private int id;
    private String taskName;
    private boolean isDone;
    private int duration, importance, urgency, priority;
    Date dueDate;

    public Task (String taskName){
        setTaskName(taskName);
    }

    public Task(int id, String taskName, boolean isDone, int duration, int importance, int urgency, int priority, Date dueDate){
        setTaskName(taskName);
        setDone(isDone);
        setDuration(duration);
        setImportance(importance);
        setUrgency(urgency);
        setPriority(priority);
        setDueDate(dueDate);

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
        this.importance = importance;
    }

    public int getUrgency() {
        return urgency;
    }

    public void setUrgency(int urgency) {
        this.urgency = urgency;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Date getDueDate(){
        return this.dueDate;
    }

    public void setDueDate(Date dueDate){
        this.dueDate = dueDate;
    }

    

}
