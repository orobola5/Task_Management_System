package com.love.Task_Management_System.resource;

import com.love.Task_Management_System.model.Tasks;

import java.util.List;

public class TaskResourceList {
    private List<Tasks> taskList;

    public List<Tasks> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Tasks> taskList) {
        this.taskList = taskList;
    }
}
