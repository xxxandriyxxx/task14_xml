package com.epam.model.parser;

import com.epam.model.CallPrices;
import com.epam.model.Parameters;
import com.epam.model.Tariff;
import com.epam.model.Tariffing;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

public class DOMReader {

    public List<Tariff> readDoc(Document doc) {
        doc.getDocumentElement().normalize();
        List<Tariff> tariffList = new ArrayList<>();

        NodeList nodeList = doc.getElementsByTagName("tariff");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Tariff tariff = new Tariff();
            CallPrices callPrices;
            Parameters parameters;
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                tariff.setTariffNo(Integer.parseInt(element.getAttribute("tariffNo")));
                tariff.setName(element.getElementsByTagName("name").item(0).getTextContent());
                tariff.setOperatorName(element.getElementsByTagName("operator_name").item(0).getTextContent());
                tariff.setPayroll(Double.parseDouble(element.getElementsByTagName("payroll").item(0).getTextContent()));
                tariff.setSmsPrice(Integer.parseInt(element.getElementsByTagName("sms_price").item(0).getTextContent()));

                callPrices = readCallPrices(element.getElementsByTagName("call_prices"));
                parameters = readParameters(element.getElementsByTagName("parameters"));

                tariff.setCallPrices(callPrices);
                tariff.setParameters(parameters);
                tariffList.add(tariff);
            }
        }
        return tariffList;
    }

    private CallPrices readCallPrices(NodeList node) {
        CallPrices callPrices = new CallPrices();
        if (node.item(0).getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node.item(0);
            callPrices.setInside(Integer.parseInt(element.getElementsByTagName("inside").item(0).getTextContent()));
            callPrices.setOutside(Integer.parseInt(element.getElementsByTagName("outside").item(0).getTextContent()));
            callPrices.setLandlinePhone(Integer.parseInt(element.getElementsByTagName("landline_phone").item(0).getTextContent()));
        }
        return callPrices;
    }

    private Parameters readParameters(NodeList node) {
        Parameters parameters = new Parameters();
        if (node.item(0).getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node.item(0);
            parameters.setFavoriteNumbers(Integer.parseInt(element.getElementsByTagName("favorite_numbers").item(0).getTextContent()));
            parameters.setConnectionPayment(Double.parseDouble(element.getElementsByTagName("connection_payment").item(0).getTextContent()));
            if (element.getElementsByTagName("tariffing").item(0).getTextContent().equals("per_15_seconds")) {
                parameters.setTariffing(Tariffing.PER_15_SECONDS);
            } else if (element.getElementsByTagName("tariffing").item(0).getTextContent().equals("per_1_minute")) {
                parameters.setTariffing(Tariffing.PER_1_MINUTE);
            }
        }
        return parameters;
    }

}
