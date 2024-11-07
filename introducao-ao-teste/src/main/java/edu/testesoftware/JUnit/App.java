package edu.testesoftware.JUnit;

public class App {
    private double a, b;

    public App(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double somar(){
        return this.a + this.b;
    }

    public boolean conferirDiferenca(){
        return a != b;
    }
}
