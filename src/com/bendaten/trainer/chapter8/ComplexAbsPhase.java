package com.bendaten.trainer.chapter8;

public abstract class ComplexAbsPhase extends Complex {

    public ComplexAbsPhase(double re, double im) {
        super(re, im);
    }

    public ComplexAbsPhase(Complex that) {
        super(that);
    }

    public double absolute() {
        return Math.sqrt(re * re + im * im);
    }

    public double phase() {
        return Math.atan2(im, re);
    }
}
