package com.ruperti.todo_app_v2.SortingTree;

import com.ruperti.todo_app_v2.Task;

import java.util.ArrayList;

public class Knoten extends TreeElement{

    private TreeElement linkerNachfolger;
    private TreeElement rechterNachfolger;
    private Task data;

    public Knoten() {

    }

    public Knoten(TreeElement linkerNachfolger, TreeElement rechterNachfolger, Task data) {
        this.linkerNachfolger = linkerNachfolger;
        this.rechterNachfolger = rechterNachfolger;
        this.data = data;
    }

    public TreeElement getLinkerNachfolger() {
        return linkerNachfolger;
    }

    public void setLinkerNachfolger(TreeElement linkerNachfolger) {
        this.linkerNachfolger = linkerNachfolger;
    }

    public TreeElement getRechterNachfolger() {
        return rechterNachfolger;
    }

    public void setRechterNachfolger(TreeElement rechterNachfolger) {
        this.rechterNachfolger = rechterNachfolger;
    }

    public Task getData() {
        return data;
    }

    public void setData(Task data) {
        this.data = data;
    }

    @Override
    public ArrayList<Task> inorderAusgabe(ArrayList<Task> arrayList) {
        arrayList = linkerNachfolger.inorderAusgabe(arrayList);
        arrayList.add(this.data);
        return rechterNachfolger.inorderAusgabe(arrayList);
    }

    @Override
    public void preorderAusgabe() {
        System.out.println(this.data.getValue());
        linkerNachfolger.preorderAusgabe();
        rechterNachfolger.preorderAusgabe();
    }

    @Override
    public void postorderAusgabe() {
        linkerNachfolger.postorderAusgabe();
        rechterNachfolger.postorderAusgabe();
        System.out.println(this.data.getValue());
    }

    @Override
    public TreeElement add(Task d, int index) {
        if(index == 0){
            if (this.data.compareToImportance(d) == 1) {
                linkerNachfolger.add(d, index);
                return this;
            }else if (this.data.compareToImportance(d) == -1) {
                rechterNachfolger.add(d, index);
                return this;
            }else {
                System.out.println("Error: Das Element ist schon vorhanden");
                return this;
            }
        }
        if(index == 1){
            if (this.data.compareToUrgency(d) == 1) {
                linkerNachfolger.add(d, index);
                return this;
            }else if (this.data.compareToUrgency(d) == -1) {
                rechterNachfolger.add(d, index);
                return this;
            }else {
                System.out.println("Error: Das Element ist schon vorhanden");
                return this;
            }
        }
        if (index == 2) {
            if (this.data.compareToDuration(d) == 1) {
                linkerNachfolger.add(d, index);
                return this;
            }else if (this.data.compareToDuration(d) == -1) {
                rechterNachfolger.add(d, index);
                return this;
            }else {
                System.out.println("Error: Das Element ist schon vorhanden");
                return this;
            }
        }
        else{
            if (this.data.compareToPriority(d) == 1) {
                linkerNachfolger.add(d, index);
                return this;
            }else if (this.data.compareToPriority(d) == -1) {
                rechterNachfolger.add(d, index);
                return this;
            }else {
                System.out.println("Error: Das Element ist schon vorhanden");
                return this;
            }
        }

    }

    @Override
    protected TreeElement delete(Task value) {

        if (this.data.compareToImportance(value) == 0) {
            this.linkerNachfolger.addRight(rechterNachfolger);
            return linkerNachfolger;
        }else if(this.data.compareToImportance(value) == 1) {
            this.linkerNachfolger.delete(value);
            return this;
        }else {
            this.rechterNachfolger.delete(value);
            return this;
        }
    }

    @Override
    protected TreeElement addRight(TreeElement t) {
        rechterNachfolger =  rechterNachfolger.addRight(t);
        return this;
    }

}
