package com.example.bovapp.remoteData.Models;

public class Whtr {
    private String value;
    private String status;

    @Override
    public String toString() {
        return "Whtr{" +
                "value='" + value + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public Whtr(String value) {
        this.value = value;
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
