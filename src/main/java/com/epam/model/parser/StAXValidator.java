package com.epam.model.parser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.validation.*;
import javax.xml.transform.stax.*;
import javax.xml.stream.*;
import javax.xml.*;
import java.io.*;
import java.util.Arrays;

public class StAXValidator {

    private static Logger logger = LogManager.getLogger(StAXValidator.class);

    public static void validate(String schemaFilePath, String xmlFilePath) {
        try {
            XMLStreamReader reader = XMLInputFactory.newInstance()
                    .createXMLStreamReader(new FileInputStream(xmlFilePath));

            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File(schemaFilePath));

            Validator validator = schema.newValidator();
            validator.validate(new StAXSource(reader));

            System.out.println("File '" + xmlFilePath + "' is valid!");
        } catch (Exception e) {
            logger.error(Arrays.toString(e.getStackTrace()));
            System.out.println("Validation failed!");
        }
    }

}
