package com.waylau.spring.cloud.weather.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.Reader;
import java.io.StringReader;

public class XmlBuilder {
    public static Object xmlStrToObject(Class<?> clazz, String xmlStr) throws Exception {
        Object xmlObject;

        JAXBContext context = JAXBContext.newInstance(clazz);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        Reader reader = new StringReader(xmlStr);
        xmlObject = unmarshaller.unmarshal(reader);

        reader.close();

        return xmlObject;
    }
}
