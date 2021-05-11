package com.example.bovapp.remoteData.RequestModel;

import com.google.gson.annotations.SerializedName;

public class AnimalRequest {
    @SerializedName("weight")
    private WeightR weight;
    @SerializedName("height")
    private HeightR height;
    @SerializedName("sex")
    private String sex;
    @SerializedName("age")
    private String age;
    @SerializedName("hip")
    private String hip;
    @SerializedName("waist")
    private String waist;

    @Override
    public String toString() {
        return "AnimalRequest{" +
                "weight=" + weight +
                ", height=" + height +
                ", sex='" + sex + '\'' +
                ", age='" + age + '\'' +
                ", waist='" + waist + '\'' +
                ", hip='" + hip + '\'' +
                '}';
    }



    public AnimalRequest(WeightR weight, HeightR height, String sex, String age, String waist, String hip) {
        this.weight = weight;
        this.height = height;
        this.sex = sex;
        this.age = age;
        this.waist = waist;
        this.hip = hip;
    }

    public WeightR getWeight() {
        return weight;
    }

    public void setWeight(WeightR weight) {
        this.weight = weight;
    }

    public HeightR getHeight() {
        return height;
    }

    public void setHeight(HeightR height) {
        this.height = height;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getWaist() {
        return waist;
    }

    public void setWaist(String waist) {
        this.waist = waist;
    }

    public String getHip() {
        return hip;
    }

    public void setHip(String hip) {
        this.hip = hip;
    }


}
