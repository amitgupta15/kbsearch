package com.ats.kbsearch.fixtures;

/**
 * Created by amit on 5/11/17.
 */
public class SimpleCalc {
    private double first, second;

    public void setFirst(double first) {
        this.first = first;
    }

    public void setSecond(double second) {
        this.second = second;
    }

    public double sum() {
        return first + second;
    }
}
