package com.ruperti.todo_app_v2.List;

import com.ruperti.todo_app_v2.Task;

public class Node extends ListElement {
    public Task content;
    public ListElement next;
    public Node (Task C , ListElement N) {
        content = C;
        next = N;
    }


}
