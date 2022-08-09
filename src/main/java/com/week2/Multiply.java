package com.week2;

public class Multiply {

    public int multiplyInt(Number arg1, Number arg2){
        return arg1.intValue()*arg2.intValue();
    }

    public float multiplyFloat(Number arg1, Number arg2){
        return arg1.floatValue()*arg2.floatValue();
    }

    public double multipleDouble(Number arg1, Number arg2){
        return arg1.doubleValue()*arg2.doubleValue();
    }

}
