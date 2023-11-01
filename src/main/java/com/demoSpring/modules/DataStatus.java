package com.demoSpring.modules;

import java.util.List;

public class DataStatus {
    private String status;
    private List<Student> data;


    public DataStatus() {
    }

    public DataStatus(String status, List<Student> data) {
        this.status = status;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Student> getData() {
        return data;
    }

    public void setData(List<Student> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "{" +
                "status='" + status + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
