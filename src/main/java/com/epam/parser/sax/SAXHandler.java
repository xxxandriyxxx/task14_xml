package com.epam.parser.sax;

import com.epam.model.CallPrices;
import com.epam.model.Parameters;
import com.epam.model.Tariff;
import com.epam.model.Tariffing;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.*;

import java.util.ArrayList;
import java.util.List;

public class SAXHandler extends DefaultHandler {

    private Tariff tariff;
    private CallPrices callPrices;
    private Parameters parameters;
    private List<Tariff> tariffList = new ArrayList<>();
    private boolean bName = false;
    private boolean bOperatorName = false;
    private boolean bPayroll = false;
    private boolean bCallPrices = false;
    private boolean bInside = false;
    private boolean bOutside = false;
    private boolean bLandlinePhone = false;
    private boolean bSmsPrice = false;
    private boolean bParameters = false;
    private boolean bFavoriteNumbers = false;
    private boolean bTariffing = false;
    private boolean bConnectionPayment = false;

    public List<Tariff> getTariffList (){
        return tariffList;
    }

    @Override
    public void startDocument() throws SAXException {
//        System.out.println("Start parse XML...");
    }

    @Override
    public void startElement(String namespaceURI, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("tariff")) {
            tariff = new Tariff();
            tariff.setTariffNo(Integer.parseInt(attributes.getValue("tariffNo")));
        } else if (qName.equalsIgnoreCase("name")) {
            bName = true;
        } else if (qName.equalsIgnoreCase("operator_name")) {
            bOperatorName = true;
        } else if (qName.equalsIgnoreCase("payroll")) {
            bPayroll = true;
        } else if (qName.equalsIgnoreCase("call_prices")) {
            bCallPrices = true;
        } else if (qName.equalsIgnoreCase("inside")) {
            bInside = true;
        } else if (qName.equalsIgnoreCase("outside")) {
            bOutside = true;
        } else if (qName.equalsIgnoreCase("landline_phone")) {
            bLandlinePhone = true;
        } else if (qName.equalsIgnoreCase("sms_price")) {
            bSmsPrice = true;
        } else if (qName.equalsIgnoreCase("parameters")) {
            bParameters = true;
        } else if (qName.equalsIgnoreCase("favorite_numbers")) {
            bFavoriteNumbers = true;
        } else if (qName.equalsIgnoreCase("tariffing")) {
            bTariffing = true;
        } else if (qName.equalsIgnoreCase("connection_payment")) {
            bConnectionPayment = true;
        }
    }

    @Override
    public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("tariff")) {
            tariff.setCallPrices(callPrices);
            tariff.setParameters(parameters);
            tariffList.add(tariff);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bName) {
            tariff.setName(new String(ch, start, length));
            bName = false;
        } else if (bOperatorName) {
            tariff.setOperatorName(new String(ch, start, length));
            bOperatorName = false;
        } else if (bPayroll) {
            tariff.setPayroll(Double.parseDouble(new String(ch, start, length)));
            bPayroll = false;
        } else if (bCallPrices) {
            callPrices = new CallPrices();
            bCallPrices = false;
        } else if (bInside) {
            callPrices.setInside(Integer.parseInt(new String(ch, start, length)));
            bInside = false;
        } else if (bOutside) {
            callPrices.setOutside(Integer.parseInt(new String(ch, start, length)));
            bOutside = false;
        } else if (bLandlinePhone) {
            callPrices.setLandlinePhone(Integer.parseInt(new String(ch, start, length)));
            bLandlinePhone = false;
        } else if (bSmsPrice) {
            tariff.setSmsPrice(Integer.parseInt(new String(ch, start, length)));
            bSmsPrice = false;
        } else if (bParameters) {
            parameters = new Parameters();
            bParameters = false;
        } else if (bFavoriteNumbers) {
            parameters.setFavoriteNumbers(Integer.parseInt(new String(ch, start, length)));
            bFavoriteNumbers = false;
        } else if (bTariffing) {
            String tariffing = new String(ch, start, length);
            if(tariffing.equalsIgnoreCase("per_15_seconds")){
                parameters.setTariffing(Tariffing.PER_15_SECONDS);
            } else if(tariffing.equalsIgnoreCase("per_1_minute")){
                parameters.setTariffing(Tariffing.PER_1_MINUTE);
            }
            bTariffing = false;
        } else if (bConnectionPayment) {
            parameters.setConnectionPayment(Double.parseDouble(new String(ch, start, length)));
            bConnectionPayment = false;
        }
    }

    @Override
    public void endDocument() {
//        System.out.println("Stop parse XML...");
    }

}
