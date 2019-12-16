package com.epam.model.parser;

import java.io.File;
import java.util.Arrays;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;

public class DOMValidator {

    private static Logger logger = LogManager.getLogger(DOMValidator.class);

    public static void validate(String schemaFilePath, String xmlFilePath) {
        Schema schema = loadSchema(schemaFilePath);
        Document document = parseXmlDom(xmlFilePath);
        validateXml(schema, document);
    }

    private static void validateXml(Schema schema, Document document) {
        try {
            Validator validator = schema.newValidator();
            System.out.println("Validator Class: " + validator.getClass().getName());
            System.out.println("File path: " + document.getDocumentURI());
            validator.validate(new DOMSource(document));
            System.out.println("Validation passed!");
        } catch (Exception e) {
            logger.error(Arrays.toString(e.getStackTrace()));
            System.out.println("Validation failed!");
        }
    }

    private static Schema loadSchema(String schemaFileName) {
        Schema schema = null;
        try {
            String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
            SchemaFactory factory = SchemaFactory.newInstance(language);
            schema = factory.newSchema(new File(schemaFileName));
        } catch (Exception e) {
            logger.error(Arrays.toString(e.getStackTrace()));
        }
        return schema;
    }

    private static Document parseXmlDom(String xmlName) {
        Document document = null;
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            document = builder.parse(new File(xmlName));
        } catch (Exception e) {
            logger.error(Arrays.toString(e.getStackTrace()));
        }
        return document;
    }

}
