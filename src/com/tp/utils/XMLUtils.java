/**
 * 
 */
package com.tp.utils;

import java.io.StringReader;
import java.util.AbstractList;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
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
	
	/**
	 * @param tagName
	 * @param element
	 * @return
	 */
	private static String getString(String tagName, Element element, String innerTagName) {
        NodeList list = element.getElementsByTagName(tagName);
        return getString(innerTagName,(Element)list.item(0));
    }
	/**
	 * @param response
	 * @param root
	 * @param elementToRead
	 * @param position
	 * @return
	 */
	public static String getElement(String response,String root,String elementToRead,int position, String innerElement) {
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
		NodeList nodes = doc.getElementsByTagName(elementToRead);
		List<Node> asList = asList(nodes);
		int i=0;
		for(Node n: asList) {
			//System.out.println("i="+i+" nodeSize:"+asList.size()+" position:"+position);
			i++;
			if(i==position) {
				Element ele = (Element) n;
				//System.out.println("This:"+ele.getElementsByTagName(innerElement).item(0).getTextContent());
			    return (ele.getElementsByTagName(innerElement).item(0).getTextContent());
			 }
			 
		}
		return "";
		//return getString(elementToRead,(Element)nodes.item(position),innerElement);
	}
	
	  /**
	 * @param n
	 * @return
	 */
	private static List<Node> asList(NodeList n) {
		    return n.getLength()==0?
		      Collections.<Node>emptyList(): new NodeListWrapper(n);
		  }
		  static final class NodeListWrapper extends AbstractList<Node>
		  implements RandomAccess {
		    private final NodeList list;
		    NodeListWrapper(NodeList l) {
		      list=l;
		    }
		    public Node get(int index) {
		      return list.item(index);
		    }
		    public int size() {
		      return list.getLength();
		    }
		  }
}
