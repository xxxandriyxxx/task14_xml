package com.epam;

import com.epam.parser.XmlToHtmlTransformer;
import com.epam.parser.dom.DOMReader;
import com.epam.parser.dom.DOMValidator;
import com.epam.parser.sax.SAXHandler;
import com.epam.parser.sax.SAXValidator;
import com.epam.parser.stax.StAXReader;
import com.epam.parser.stax.StAXValidator;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.*;


public class Application {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {

        File xmlFile = new File("src/main/resources/xml/tariffs.xml");

        DOMReader domReader = new DOMReader();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(xmlFile);
        System.out.println(domReader.readDoc(document).toString());
//        ----------------------------
        SAXParserFactory factory2 = SAXParserFactory.newInstance();
        SAXParser parser = factory2.newSAXParser();
        SAXHandler saxHandler = new SAXHandler();
        parser.parse(xmlFile, saxHandler);
        System.out.println(saxHandler.getTariffList().toString());
//        ----------------------------
        System.out.println(StAXReader.getTariffList(xmlFile).toString());
//        ----------------------------
        String schemaPath = "src/main/resources/xml/tariffs.xsd";
        String xmlPath = "src/main/resources/xml/tariffs.xml";
        String xslPath = "src/main/resources/xml/tariffs.xsl";
        SAXValidator.validate(schemaPath, xmlPath);
        StAXValidator.validate(schemaPath, xmlPath);
//        DOMValidator.validate(schemaPath, xmlPath);
        XmlToHtmlTransformer.transform(xslPath, xmlPath);
    }
}
