package com.ruperti.todo_app_v2;

import com.ruperti.todo_app_v2.SortingTree.Tree;

import java.util.ArrayList;
import java.util.List;


public class Sort {

    public static List<Task> sort(ArrayList<Task> inputList){
        Tree temporaryTree = new Tree();
        for (Task task: inputList
             ) {
            temporaryTree.add(task);
        }

        return temporaryTree.inorderAusgabe(inputList);

        //Hier kommt Roberts Code rein!!!!!!

    }

}
