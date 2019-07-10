package com.ruperti.todo_app_v2;

import com.ruperti.todo_app_v2.SortingTree.Tree;

import java.util.ArrayList;
import java.util.List;


public class Sort {

    public static ArrayList<Task> sort(ArrayList<Task> inputList, int index){

        //index 0 sorts by importance
        //index 1 sorts by urgency
        //index 2 sorts by duration
        //index 3 sorts by priority

        Tree temporaryTree = new Tree();
        for (Task task: inputList
             ) {
            temporaryTree.add(task, index);
        }

        return temporaryTree.inorderAusgabe(inputList);

        //Hier kommt Roberts Code rein!!!!!!

    }

}
