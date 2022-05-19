package org.sample.weather;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class ReadResources {
    private static final Logger LOGGER = LogManager.getLogger(ReadResources.class);

    Document domDocument;
    Map<String, String> elementXml;

    public Map<String, String> getValuesFromXml(String fileName, String tagName) {

        domDocument = parseXMl(fileName);
        elementXml = new HashMap<>();
        NodeList nodeList = domDocument.getElementsByTagName(tagName);

        for (int j = 0; j < nodeList.item(0).getChildNodes().getLength(); j++) {

            if (j % 2 != 0) {

                elementXml.put(nodeList.item(0).getChildNodes().item(j).getNodeName(),
                        nodeList.item(0).getChildNodes().item(j).getTextContent());
            }
        }

        return elementXml;
    }

    public Document parseXMl(String fileName) {

        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();

        try {

            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            domDocument = builder.parse(getFilePath(fileName));

        } catch (Exception e) {

            e.printStackTrace();
        }
        return domDocument;
    }

    public String getFilePath(String sFilepath) {
        String sPath = System.getProperty("user.dir") + "\\src\\main\\resources\\" + sFilepath;
        sPath = sPath.replace('\\', '/');

        File file = new File(sPath);
        if (!file.exists()) {
            LOGGER.error("File with the Path [" + sPath + "] not Found");
        }

        return sPath;
    }
}

