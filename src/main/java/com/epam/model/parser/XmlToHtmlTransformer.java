package com.epam.model.parser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Arrays;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class XmlToHtmlTransformer {

    private static Logger logger = LogManager.getLogger(XmlToHtmlTransformer.class);

    public static void transform(String xslFilePath, String xmlFilePath) {
        try {
            TransformerFactory tFactory = TransformerFactory.newInstance();
            Source xslDoc = new StreamSource(xslFilePath);
            Source xmlDoc = new StreamSource(xmlFilePath);
            String outputFileName = "src/main/resources/html/tariffs.html";
            OutputStream htmlFile = new FileOutputStream(outputFileName);
            Transformer transform = tFactory.newTransformer(xslDoc);
            transform.transform(xmlDoc, new StreamResult(htmlFile));
            System.out.println("New file created: 'src/main/resources/html/tariffs.html'");
        } catch (Exception e) {
            logger.error(Arrays.toString(e.getStackTrace()));
            System.out.println("Transform failed!");
        }
    }

}
