package com.epam.model.parser;

import javax.xml.validation.*;
import javax.xml.transform.stax.*;
import javax.xml.stream.*;
import javax.xml.*;
import java.io.*;

public class StAXValidator {

    public static void validate(String schemaFilePath, String xmlFilePath) {
        try {
            XMLStreamReader reader = XMLInputFactory.newInstance().createXMLStreamReader(new FileInputStream(xmlFilePath));

            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File(schemaFilePath));

            Validator validator = schema.newValidator();
            validator.validate(new StAXSource(reader));

            System.out.println("File '" + xmlFilePath + "' is valid!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
