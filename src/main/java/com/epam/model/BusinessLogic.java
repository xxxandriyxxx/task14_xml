package com.epam.model;

import com.epam.model.parser.XmlToHtmlTransformer;
import com.epam.model.parser.DOMReader;
import com.epam.model.parser.DOMValidator;
import com.epam.model.parser.SAXHandler;
import com.epam.model.parser.SAXValidator;
import com.epam.model.parser.StAXReader;
import com.epam.model.parser.StAXValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.util.Arrays;
import java.util.List;

public class BusinessLogic implements Model {

    private static Logger logger = LogManager.getLogger(BusinessLogic.class);
    private String xmlFilePath;
    private String schemaFilePath;
    private String xslFilePath;
    private String xslFileSortPath;
    private File xmlFile;

    public BusinessLogic() {
        xmlFilePath = "src/main/resources/xml/tariffs.xml";
        schemaFilePath = "src/main/resources/xml/tariffs.xsd";
        xslFilePath = "src/main/resources/xml/tariffs.xsl";
        xslFileSortPath = "src/main/resources/xml/tariffsSort.xsl";
        xmlFile = new File(xmlFilePath);
    }

    @Override
    public void parseByDOM() {
        try {
            DOMReader domReader = new DOMReader();
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);
            List<Tariff> tariffs = domReader.readDoc(document);
            System.out.println("DOM parser --------------------------------");
            for (Tariff t : tariffs) {
                System.out.println(t.toString());
            }
        } catch (Exception e) {
            logger.error(Arrays.toString(e.getStackTrace()));
            System.out.println("Parser failed!");
        }
    }

    @Override
    public void parseBySAX() {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            SAXHandler saxHandler = new SAXHandler();
            parser.parse(xmlFile, saxHandler);
            List<Tariff> tariffs = saxHandler.getTariffList();
            System.out.println("SAX parser --------------------------------");
            for (Tariff t : tariffs) {
                System.out.println(t.toString());
            }
        } catch (Exception e) {
            logger.error(Arrays.toString(e.getStackTrace()));
            System.out.println("Parser failed!");
        }
    }

    @Override
    public void parseByStAX() {
        List<Tariff> tariffs = StAXReader.getTariffList(xmlFile);
        System.out.println("StAX parser --------------------------------");
        for (Tariff t : tariffs) {
            System.out.println(t.toString());
        }
    }

    @Override
    public void validateByDOM() {
        DOMValidator.validate(schemaFilePath, xmlFilePath);
    }

    @Override
    public void validateBySAX() {
        SAXValidator.validate(schemaFilePath, xmlFilePath);
    }

    @Override
    public void validateByStAX() {
        StAXValidator.validate(schemaFilePath, xmlFilePath);
    }

    @Override
    public void transformToHtml() {
        XmlToHtmlTransformer.transform(xslFilePath, xmlFilePath);
    }

    @Override
    public void transformToHtmlSortedByPayroll() {
        XmlToHtmlTransformer.transform(xslFileSortPath, xmlFilePath);
    }
}
