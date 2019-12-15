package com.epam.parser.stax;

import com.epam.model.CallPrices;
import com.epam.model.Parameters;
import com.epam.model.Tariff;
import com.epam.model.Tariffing;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class StAXReader {

    public static List<Tariff> getTariffList(File xmlFile) {
        List<Tariff> tariffList = new ArrayList<>();
        Tariff tariff = null;
        CallPrices callPrices = null;
        Parameters parameters = null;
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();

        try {
            XMLEventReader xmlEventReader = xmlInputFactory
                    .createXMLEventReader(new FileInputStream(xmlFile));
            while (xmlEventReader.hasNext()) {
                XMLEvent xmlEvent = xmlEventReader.nextEvent();
                if (xmlEvent.isStartElement()) {
                    StartElement startElement = xmlEvent.asStartElement();
                    String name = startElement.getName().getLocalPart();
                    switch (name) {
                        case "tariff":
                            tariff = new Tariff();
                            Attribute tariffNoAttr = startElement.getAttributeByName(new QName("tariffNo"));
                            if (tariffNoAttr != null) {
                                tariff.setTariffNo(Integer.parseInt(tariffNoAttr.getValue()));
                            }
                            break;
                        case "name":
                            xmlEvent = xmlEventReader.nextEvent();
                            assert tariff != null;
                            tariff.setName(xmlEvent.asCharacters().getData());
                            break;
                        case "operator_name":
                            xmlEvent = xmlEventReader.nextEvent();
                            assert tariff != null;
                            tariff.setOperatorName(xmlEvent.asCharacters().getData());
                            break;
                        case "payroll":
                            xmlEvent = xmlEventReader.nextEvent();
                            assert tariff != null;
                            tariff.setPayroll(Double.parseDouble(xmlEvent.asCharacters().getData()));
                            break;
                        case "call_prices":
                            xmlEvent = xmlEventReader.nextEvent();
                            callPrices = new CallPrices();
                            break;
                        case "inside":
                            xmlEvent = xmlEventReader.nextEvent();
                            assert callPrices != null;
                            callPrices.setInside(Integer.parseInt(xmlEvent.asCharacters().getData()));
                            break;
                        case "outside":
                            xmlEvent = xmlEventReader.nextEvent();
                            assert callPrices != null;
                            callPrices.setOutside(Integer.parseInt(xmlEvent.asCharacters().getData()));
                            break;
                        case "landline_phone":
                            xmlEvent = xmlEventReader.nextEvent();
                            assert callPrices != null;
                            callPrices.setLandlinePhone(Integer.parseInt(xmlEvent.asCharacters().getData()));
                            break;
                        case "sms_price":
                            xmlEvent = xmlEventReader.nextEvent();
                            assert tariff != null;
                            tariff.setSmsPrice(Integer.parseInt(xmlEvent.asCharacters().getData()));
                            break;
                        case "parameters":
                            xmlEvent = xmlEventReader.nextEvent();
                            parameters = new Parameters();
                            break;
                        case "favorite_numbers":
                            xmlEvent = xmlEventReader.nextEvent();
                            assert parameters != null;
                            parameters.setFavoriteNumbers(Integer.parseInt(xmlEvent.asCharacters().getData()));
                            break;
                        case "tariffing":
                            xmlEvent = xmlEventReader.nextEvent();
                            assert parameters != null;
                            String tariffing = xmlEvent.asCharacters().getData();
                            if (tariffing.equalsIgnoreCase("per_15_seconds")) {
                                parameters.setTariffing(Tariffing.PER_15_SECONDS);
                            } else if (tariffing.equalsIgnoreCase("per_1_minute")) {
                                parameters.setTariffing(Tariffing.PER_1_MINUTE);
                            }
                            break;
                        case "connection_payment":
                            xmlEvent = xmlEventReader.nextEvent();
                            assert parameters != null;
                            parameters.setConnectionPayment(Double.parseDouble(xmlEvent.asCharacters().getData()));
                            break;
                    }
                }

                if (xmlEvent.isEndElement()) {
                    EndElement endElement = xmlEvent.asEndElement();
                    if (endElement.getName().getLocalPart().equals("tariff")) {
                        tariff.setCallPrices(callPrices);
                        tariff.setParameters(parameters);
                        tariffList.add(tariff);
                    }
                }


            }


        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }

        return tariffList;
    }


}
