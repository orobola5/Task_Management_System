package com.love.Task_Management_System.resource;

public class TaskRecordResource {
    private long id;
    private long user;
    private long program;
    private long task;
    private String status;
    private double score;
    private double max;
    private String remarks;
    private String work;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUser() {
        return user;
    }

    public void setUser(long user) {
        this.user = user;
    }

    public long getProgram() {
        return program;
    }

    public void setProgram(long program) {
        this.program = program;
    }

    public long getTask() {
        return task;
    }

    public void setTask(long task) {
        this.task = task;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }
}
