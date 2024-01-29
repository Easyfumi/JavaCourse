package ru.marinin.math;

import java.util.Objects;

public final class Fraction extends Number implements Cloneable {
    private final int numerator;
    private final int denominator;
    public Fraction(int numerator) {
        this(numerator, 1);
    }
    public int getNumerator() {
        return numerator;
    }
    public int getDenominator() {
        return denominator;
    }
    public Fraction(int numerator, int denominator) {
        if (denominator<0) throw  new IllegalArgumentException();
        this.numerator=numerator;
        this.denominator=denominator;
    }
    public Fraction sum(Fraction fraction) {
        if (Math.abs(this.denominator)==Math.abs(fraction.denominator)) {
            return new Fraction(this.numerator+ fraction.numerator, fraction.denominator);
        } else {
            return new Fraction(
                    this.numerator* fraction.denominator+ fraction.numerator*this.denominator,
                    this.denominator* fraction.denominator);
        }
    }
    public Fraction minus(Fraction fraction) {
        return this.sum(new Fraction(-fraction.numerator, fraction.denominator));
    }
    public Fraction multiply(Fraction fraction) {
        int numerator = this.numerator * fraction.numerator;
        int denominator = this.denominator * fraction.denominator;
        return new Fraction(numerator, denominator);
    }
    public Fraction divide(Fraction fraction) {
        return this.multiply(new Fraction(fraction.denominator, fraction.numerator));
    }

    @Override
    public int intValue() {
        return numerator/denominator;
    }
    @Override
    public long longValue() {
        return numerator/denominator;
    }
    @Override
    public float floatValue() {
        return (float)numerator/denominator;
    }
    @Override
    public double doubleValue() {
        return (double)numerator/denominator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fraction fraction = (Fraction) o;
        return numerator == fraction.numerator && denominator == fraction.denominator;
    }

    @Override
    public Fraction clone() {
        try {
            return (Fraction) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerator, denominator);
    }

    @Override
    public String toString() {
        return numerator+"/"+denominator;
    }
}