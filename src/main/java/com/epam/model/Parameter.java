package com.epam.model;

public class Parameter {

    private int fvoriteNumbers;
    private Tariffing tariffing;
    private double connectionPayment;

    public Parameter() {
    }

    public Parameter(int fvoriteNumbers, Tariffing tariffing, double connectionPayment) {
        this.fvoriteNumbers = fvoriteNumbers;
        this.tariffing = tariffing;
        this.connectionPayment = connectionPayment;
    }

    public int getFvoriteNumbers() {
        return fvoriteNumbers;
    }

    public void setFvoriteNumbers(int fvoriteNumbers) {
        this.fvoriteNumbers = fvoriteNumbers;
    }

    public Tariffing getTariffing() {
        return tariffing;
    }

    public void setTariffing(Tariffing tariffing) {
        this.tariffing = tariffing;
    }

    public double getConnectionPayment() {
        return connectionPayment;
    }

    public void setConnectionPayment(double connectionPayment) {
        this.connectionPayment = connectionPayment;
    }

    @Override
    public String toString() {
        return "Parameter{" +
                "fvoriteNumbers=" + fvoriteNumbers +
                ", tariffing=" + tariffing +
                ", connectionPayment=" + connectionPayment +
                '}';
    }
}
