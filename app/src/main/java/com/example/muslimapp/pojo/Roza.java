package com.example.muslimapp.pojo;

public class Roza {

    private int rozaNum;
    private int day;
    private int month;
    private boolean isPassed;

    public Roza(int rozaNum, int day, int month, boolean isPassed) {
        this.rozaNum = rozaNum;
        this.day = day;
        this.month = month;
        this.isPassed = isPassed;
    }

    public int getRozaNum() {
        return rozaNum;
    }

    public void setRozaNum(int rozaNum) {
        this.rozaNum = rozaNum;
    }

    public int getDay() {
        return day;
    }

    public boolean isPassed() {
        return isPassed;
    }

    public void setPassed(boolean passed) {
        isPassed = passed;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    @Override
    public String toString() {
        return "Roza{" +
                "rozaNum=" + rozaNum +
                ", day=" + day +
                ", month=" + month +
                ", isPassed=" + isPassed +
                '}';
    }
}
