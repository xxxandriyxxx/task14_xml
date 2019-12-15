package com.epam.model;

public class Parameters {

    private int favoriteNumbers;
    private Tariffing tariffing;
    private double connectionPayment;

    public Parameters() {
    }

    public Parameters(int fvoriteNumbers, Tariffing tariffing, double connectionPayment) {
        this.favoriteNumbers = fvoriteNumbers;
        this.tariffing = tariffing;
        this.connectionPayment = connectionPayment;
    }

    public int getFavoriteNumbers() {
        return favoriteNumbers;
    }

    public void setFavoriteNumbers(int fvoriteNumbers) {
        this.favoriteNumbers = fvoriteNumbers;
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
        return "Parameters{" +
                "fvoriteNumbers=" + favoriteNumbers +
                ", tariffing=" + tariffing +
                ", connectionPayment=" + connectionPayment +
                '}';
    }
}
