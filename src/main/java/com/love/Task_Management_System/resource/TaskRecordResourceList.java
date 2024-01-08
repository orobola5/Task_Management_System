package com.love.Task_Management_System.resource;

import com.love.Task_Management_System.model.TaskRecord;

import java.util.List;

public class TaskRecordResourceList {
    public List<TaskRecord> getTaskRecordList() {
        return taskRecordList;
    }

    public void setTaskRecordList(List<TaskRecord> taskRecordList) {
        this.taskRecordList = taskRecordList;
    }

    private List<TaskRecord> taskRecordList;

}
