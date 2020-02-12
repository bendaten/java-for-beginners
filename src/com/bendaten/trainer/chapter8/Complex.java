package com.bendaten.trainer.chapter8;

public abstract class Complex {

    double re;
    double im;

    public Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public Complex(Complex that) {
        this.re = that.re;
        this.im = that.im;
    }

    @Override
    public String toString() {
        String rel = im >= 0.0 ? "+" : "-";
        return String.format("%s %s i*%s", re, rel, Math.abs(im));
    }

    public abstract double absolute();
    public abstract double phase();
    public abstract Complex add(Complex that);
    public abstract Complex subtract(Complex that);
    public abstract Complex multiply(Complex that);
    public abstract Complex divide(Complex that);
}
