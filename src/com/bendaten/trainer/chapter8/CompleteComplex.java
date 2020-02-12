package com.bendaten.trainer.chapter8;

public class CompleteComplex extends ComplexAbsPhase {

    public CompleteComplex(double re, double im) {
        super(re, im);
    }

    public CompleteComplex(Complex that) {
        super(that);
    }

    public Complex add(Complex that) {
        return new CompleteComplex(this.re + that.re, this.im + that.im);
    }

    public Complex subtract(Complex that) {
        return new CompleteComplex(this.re - that.re, this.im - that.im);
    }

    public Complex multiply(Complex that) {
        return new CompleteComplex(this.re * that.re - this.im * that.im, this.re * that.im + this.im * that.re);
    }

    public Complex divide(Complex that) {
        double denominator = that.re * that.re + that.im * that.im;
        if (denominator < Double.MIN_VALUE) {
            throw new ArithmeticException("The absolute values of both real and imaginary are very small");
        }
        return new CompleteComplex((this.re * that.re + this.im * that.im) / denominator, (this.im * that.re - this.re * that.im) / denominator);
    }
}
