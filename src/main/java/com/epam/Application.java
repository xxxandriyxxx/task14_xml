package com.epam;

import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.*;


public class Application {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {

        File xmlFile = new File("src/main/resources/xml/tariffs.xml");


//        ----------------------------

//        ----------------------------
//        ----------------------------
        String schemaPath = "src/main/resources/xml/tariffs.xsd";
        String xmlPath = "src/main/resources/xml/tariffs.xml";
        String xslPath = "src/main/resources/xml/tariffs.xsl";
        String xslPathSort = "src/main/resources/xml/tariffsSort.xsl";


        

    }
}
