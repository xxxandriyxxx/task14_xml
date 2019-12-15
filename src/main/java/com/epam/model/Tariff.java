package com.epam.model;

public class Tariff {

    private int tariffNo;
    private String name;
    private String operatorName;
    private double payroll;
    private CallPrice callPrices;
    private int smsPrice;
    private Parameter parameters;

    public Tariff() {
    }

    public int getTariffNo() {
        return tariffNo;
    }

    public void setTariffNo(int tariffNo) {
        this.tariffNo = tariffNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public double getPayroll() {
        return payroll;
    }

    public void setPayroll(double payroll) {
        this.payroll = payroll;
    }

    public CallPrice getCallPrices() {
        return callPrices;
    }

    public void setCallPrices(CallPrice callPrices) {
        this.callPrices = callPrices;
    }

    public int getSmsPrice() {
        return smsPrice;
    }

    public void setSmsPrice(int smsPrice) {
        this.smsPrice = smsPrice;
    }

    public Parameter getParameters() {
        return parameters;
    }

    public void setParameters(Parameter parameters) {
        this.parameters = parameters;
    }

    @Override
    public String toString() {
        return "Tariff{" +
                "tariffNo=" + tariffNo +
                ", name='" + name + '\'' +
                ", operatorName='" + operatorName + '\'' +
                ", payroll=" + payroll +
                ", callPrices=" + callPrices +
                ", smsPrice=" + smsPrice +
                ", parameters=" + parameters +
                '}';
    }
}
