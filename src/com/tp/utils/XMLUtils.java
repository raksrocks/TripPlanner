/**
 * 
 */
package com.tp.utils;

import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/**
 * @author RA312921
 *
 */
public class XMLUtils {

	/**
	 * @param response
	 * @param root
	 * @param elementToRead
	 * @return
	 */
	public static String getElement(String response,String root,String elementToRead) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		Document doc = null;
		
		try {
			factory.setNamespaceAware(true);
			builder = factory.newDocumentBuilder();
			doc = builder.parse(new InputSource(new StringReader(response)));
		}catch (Exception e) {
			e.printStackTrace();
		}
		NodeList nodes = doc.getElementsByTagName(root);
		return getString(elementToRead,(Element)nodes.item(0));
	}
	
	/**
	 * @param tagName
	 * @param element
	 * @return
	 */
	private static String getString(String tagName, Element element) {
        NodeList list = element.getElementsByTagName(tagName);
        if (list != null && list.getLength() > 0) {
            NodeList subList = list.item(0).getChildNodes();

            if (subList != null && subList.getLength() > 0) {
                return subList.item(0).getNodeValue();
            }
        }

        return null;
    }
}
