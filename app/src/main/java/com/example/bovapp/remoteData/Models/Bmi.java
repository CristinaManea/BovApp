package com.example.bovapp.remoteData.Models;

public class Bmi {
    private String value;
    private String status;
    private String risk;
    private String prime;

    @Override
    public String toString() {
        return "Bmi{" +
                "value='" + value + '\'' +
                ", status='" + status + '\'' +
                ", risk='" + risk + '\'' +
                ", prime='" + prime + '\'' +
                '}';
    }

    public Bmi(String value, String status, String risk, String prime) {
        this.value = value;
        this.status = status;
        this.risk = risk;
        this.prime = prime;
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

    public String getRisk() {
        return risk;
    }

    public void setRisk(String risk) {
        this.risk = risk;
    }

    public String getPrime() {
        return prime;
    }

    public void setPrime(String prime) {
        this.prime = prime;
    }
}
