package com.ruperti.todo_app_v2.List;

import com.ruperti.todo_app_v2.Task;

public class List {

    public ListElement first;

    public List(){
        first = new End();
        }
    public void insert(Task T){
     ListElement oldfirst = first;
        first = new Node(T , oldfirst);

    }
    public void sort(int i){

    }

}
