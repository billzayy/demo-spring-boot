package com.demoSpring.modules;

import java.util.List;

public class ResponseStatus {
    private String status;
    private String data;

    public ResponseStatus() {
    }

    public ResponseStatus(String status, String data) {
        this.status = status;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
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
