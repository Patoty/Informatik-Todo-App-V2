package com.ruperti.todo_app_v2.SortingTree;


import com.ruperti.todo_app_v2.Task;

import java.util.ArrayList;

public class Tree{

    private Knoten root;

    public Tree () {
        setRoot(new Knoten());
    }

    public Tree (Task wert) {
        setRoot(new Knoten(new Abschluss(), new Abschluss(), wert));
    }

    public Knoten getRoot() {
        return root;
    }

    public void setRoot(Knoten root) {
        this.root = root;
    }

    public ArrayList<Task> inorderAusgabe(ArrayList<Task> arrayList) {
        return root.inorderAusgabe(arrayList);

    }

    private void preorderAusgabe() {

    }

    private void postorderAusgabe() {

    }

    public void add(Task d, int index) {
        root.add(d, index);
    }

    private void delete(Task d) {
        root.delete(d);
    }



}
