package com.example.bovapp.remoteData.RequestModel;

import com.google.gson.annotations.SerializedName;

public class HeightR {
    @SerializedName("value")
    private String value;
    @SerializedName("unit")
    private String unit;

    @Override
    public String toString() {
        return "WeightR{" +
                "value='" + value + '\'' +
                ", unit='" + unit + '\'' +
                '}';
    }

    public HeightR(String value, String unit) {
        this.value = value;
        this.unit = unit;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
