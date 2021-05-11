package com.example.bovapp.documente.anexaVitei;

import java.io.Serializable;
import java.util.Date;

public class Vitel implements Serializable {

    private int nrMatricol;
    private String nume;
    private Date dataNastere;
    private double greutate;
    private String sex; //mascul sau femela
    private String gestatia; //insamantare artificiala sau monta naturala
    private String embriotransfer; //da sau nu
    private String usurintaFatare; //usoara fara asistenta, usoara cu asistenta, dificila, cezariana, embriotomie
    private String avort; //da sau nu
    private String fatareGemerala; //da sau nu
    private String culoare; //negru sau rosu

    public Vitel(int nrMatricol, String nume, Date dataNastere, double greutate, String sex, String gestatia, String embriotransfer,
                 String usurintaFatare, String avort, String fatareGemerala, String culoare) {
        this.nrMatricol = nrMatricol;
        this.nume = nume;
        this.dataNastere = dataNastere;
        this.greutate = greutate;
        this.sex = sex;
        this.gestatia = gestatia;
        this.embriotransfer = embriotransfer;
        this.usurintaFatare = usurintaFatare;
        this.avort = avort;
        this.fatareGemerala = fatareGemerala;
        this.culoare = culoare;
    }

    public int getNrMatricol() {
        return nrMatricol;
    }

    public void setNrMatricol(int nrMatricol) {
        this.nrMatricol = nrMatricol;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getDataNastere() {
        return dataNastere;
    }

    public void setDataNastere(Date dataNastere) {
        this.dataNastere = dataNastere;
    }

    public String getGestatia() {
        return gestatia;
    }

    public void setGestatia(String gestatia) {
        this.gestatia = gestatia;
    }

    public String getEmbriotransfer() {
        return embriotransfer;
    }

    public void setEmbriotransfer(String embriotransfer) {
        this.embriotransfer = embriotransfer;
    }

    public String getUsurintaFatare() {
        return usurintaFatare;
    }

    public void setUsurintaFatare(String usurintaFatare) {
        this.usurintaFatare = usurintaFatare;
    }

    public String getAvort() {
        return avort;
    }

    public void setAvort(String avort) {
        this.avort = avort;
    }

    public String getFatareGemerala() {
        return fatareGemerala;
    }

    public void setFatareGemerala(String fatareGemerala) {
        this.fatareGemerala = fatareGemerala;
    }

    public double getGreutate() {
        return greutate;
    }

    public void setGreutate(double greutate) {
        this.greutate = greutate;
    }

    public String getCuloare() {
        return culoare;
    }

    public void setCuloare(String culoare) {
        this.culoare = culoare;
    }

    @Override
    public String toString() {
        return "Vitel{" +
                "nrMatricol=" + nrMatricol +
                ", nume='" + nume + '\'' +
                ", sex='" + sex + '\'' +
                ", dataNastere=" + dataNastere +
                ", gestatia='" + gestatia + '\'' +
                ", embriotransfer='" + embriotransfer + '\'' +
                ", usurintaFatare='" + usurintaFatare + '\'' +
                ", avort='" + avort + '\'' +
                ", fatareGemerala='" + fatareGemerala + '\'' +
                ", greutate=" + greutate +
                ", culoare='" + culoare + '\'' +
                '}';
    }
}
