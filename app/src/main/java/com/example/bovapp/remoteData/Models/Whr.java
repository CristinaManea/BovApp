package com.example.bovapp.remoteData.Models;

public class Whr {
    private String value;
    private String status;

    @Override
    public String toString() {
        return "Whr{" +
                "value='" + value + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public Whr(String value, String status) {
        this.value = value;
        this.status = status;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
