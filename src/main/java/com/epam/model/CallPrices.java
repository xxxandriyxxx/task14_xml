package com.epam.model;

public class CallPrices {

    private int inside;
    private int outside;
    private int landlinePhone;

    public CallPrices() {
    }

    public CallPrices(int inside, int outside, int landlinePhone) {
        this.inside = inside;
        this.outside = outside;
        this.landlinePhone = landlinePhone;
    }

    public int getInside() {
        return inside;
    }

    public void setInside(int inside) {
        this.inside = inside;
    }

    public int getOutside() {
        return outside;
    }

    public void setOutside(int outside) {
        this.outside = outside;
    }

    public int getLandlinePhone() {
        return landlinePhone;
    }

    public void setLandlinePhone(int landlinePhone) {
        this.landlinePhone = landlinePhone;
    }

    @Override
    public String toString() {
        return "CallPrices{" +
                "inside=" + inside +
                ", outside=" + outside +
                ", landlinePhone=" + landlinePhone +
                '}';
    }
}
