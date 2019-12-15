package com.epam.parser.sax;

import java.io.File;

import javax.xml.XMLConstants;
import javax.xml.transform.sax.SAXSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.InputSource;

public class SAXValidator {

    public static void validate(String schemaPath, String xmlPath) {
        Schema schema = loadSchema(schemaPath);
        validateXml(schema, xmlPath);
    }

    private static void validateXml(Schema schema, String xmlName) {
        try {
            // creating a Validator instance
            Validator validator = schema.newValidator();
            System.out.println();
            System.out.println("Validator Class: " + validator.getClass().getName());

            // preparing the XML file as a SAX source
            SAXSource source = new SAXSource(new InputSource(new java.io.FileInputStream(xmlName)));

            // validating the SAX source against the schema
            validator.validate(source);
            System.out.println("Validation passed.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Schema loadSchema(String name) {
        Schema schema = null;
        try {
            String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
            SchemaFactory factory = SchemaFactory.newInstance(language);
            schema = factory.newSchema(new File(name));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return schema;
    }

}
