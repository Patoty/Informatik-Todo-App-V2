package com.ruperti.todo_app_v2.SortingTree;


import com.ruperti.todo_app_v2.Task;

import java.util.ArrayList;

public abstract class TreeElement {

    public abstract ArrayList<Task> inorderAusgabe(ArrayList<Task> al);
    public abstract void preorderAusgabe();
    public abstract void postorderAusgabe();
    public abstract TreeElement add(Task d);
    protected abstract TreeElement addRight(TreeElement t);
    protected abstract TreeElement delete(Task value);
}