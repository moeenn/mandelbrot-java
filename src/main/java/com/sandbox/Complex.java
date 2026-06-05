package com.sandbox;

public class Complex {
    public final double real;
    final double imaginary;

    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double absolute() {
        return Math.hypot(real, imaginary);
    }

    public Complex add(Complex other) {
        return new Complex(
                this.real + other.real,
                this.imaginary + other.imaginary);
    }

    public Complex subtract(Complex other) {
        return new Complex(
                this.real - other.real,
                this.imaginary - other.imaginary);
    }

    public Complex multiply(Complex other) {
        double realPart = this.real * other.real - this.imaginary * other.imaginary;
        double imagPart = this.real * other.imaginary + this.imaginary * other.real;
        return new Complex(realPart, imagPart);
    }
}