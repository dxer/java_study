package org.dxer.xml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XDom {

	private Element e;

	private XDom(Element e) {
		this.e = e;
	}

	public void print() {
		NodeList nodeList = e.getChildNodes();
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			System.out.println("Node: " + node.getNodeName() + " = value: "
					+ node.getNodeValue() + " [type: " + node.getNodeType()
					+ "]");
		}
	}

	public Element getDomElement() {
		return e;
	}

	/**
	 * 创建新的xml文档
	 * 
	 * @param rootName
	 * @return
	 * @throws Exception
	 */
	public static XDom newXDom(String rootName) throws Exception {
		Document doc = null;
		DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance()
				.newDocumentBuilder();
		doc = documentBuilder.newDocument();
		doc.setXmlStandalone(true);

		Element root = doc.createElement(rootName);
		doc.appendChild(root);
		return new XDom(root);
	}

	public static XDom getRoot(InputStream is) throws Exception {
		Document doc = null;
		DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance()
				.newDocumentBuilder();
		doc = documentBuilder.parse(is);
		Element root = doc.getDocumentElement();
		return new XDom(root);
	}

	public static XDom getRoot(String xmlFile) {
		InputStream is = null;
		XDom root = null;
		try {
			is = new FileInputStream(xmlFile);
			root = getRoot(is);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return root;
	}

	/**
	 * 根据属性名获得属性值
	 * 
	 * @param attributeName
	 * @return
	 */
	public String getAttributeValue(String attributeName) {
		return e.getAttribute(attributeName);
	}

	/**
	 * 判断节点是否存在
	 * 
	 * @param elemantName
	 * @return
	 */
	public boolean isExist(String elemantName) {
		NodeList nodeList = e.getElementsByTagName(elemantName);
		if (nodeList == null || nodeList.getLength() < 1) {
			return false;
		}
		return true;
	}

	/**
	 * 含有指定的属性名和属性值的节点是否存在
	 * 
	 * @param elemantName
	 * @param attributeName
	 * @param value
	 * @return
	 */
	public boolean isExist(String elemantName, String attributeName,
			String value) {
		NodeList nodeList = e.getElementsByTagName(elemantName);
		if (nodeList == null || nodeList.getLength() < 1) {
			return false;
		}

		boolean flag = false;
		for (int i = 0; i < nodeList.getLength(); i++) {
			Element ele = (Element) nodeList.item(i);
			if (!ele.getAttribute(attributeName).equals(value)) {
				continue;
			} else {
				flag = true;
			}
		}
		return flag;
	}

	/**
	 * 获得节点的内容
	 * 
	 * @param elementName
	 * @return
	 */
	public String getElementText(String elementName) {
		Element element = (Element) e.getElementsByTagName(elementName).item(0);
		Node textNode = element.getFirstChild();
		if (textNode == null) {
			return "";
		}
		return textNode.getNodeValue();
	}

	/**
	 * 获得节点的内容
	 * 
	 * @return
	 */
	public String getElementText() {
		Node textNode = e.getFirstChild();
		return textNode.getNodeValue();
	}

	/**
	 * 根据节点名称查找节点,如果存在多个节点，返回第一个
	 * 
	 * @param elementName
	 * @return
	 */
	public XDom getElement(String elementName) {
		NodeList nodeList = e.getElementsByTagName(elementName);
		if (nodeList == null || nodeList.getLength() < 1) {
			return null;
		}
		Element element = (Element) nodeList.item(0);
		return new XDom(element);
	}

	/**
	 * 根据属性名和属性值定位节点
	 * 
	 * @param elementName
	 * @param attributeName
	 * @param value
	 * @return
	 */
	public XDom getElement(String elementName, String attributeName,
			String value) {
		NodeList nodeList = e.getElementsByTagName(elementName);
		if (nodeList == null || nodeList.getLength() < 1) {
			return null;
		}

		Element ele = null;
		for (int i = 0; i < nodeList.getLength(); i++) {
			Element element = (Element) nodeList.item(i);
			if (!element.getAttribute(attributeName).equals(value)) {
				continue;
			} else {
				ele = element;
			}
		}
		return new XDom(ele);
	}

	public List<XDom> getAllElements(String elementName) {
		List<XDom> doms = null;
		NodeList nodeList = e.getElementsByTagName(elementName);
		if (nodeList == null) {
			return null;
		}
		doms = new ArrayList<XDom>();

		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) node;
				doms.add(new XDom(element));
			}
		}
		return doms;
	}

	/**
	 * 添加节点
	 * 
	 * @param name
	 * @return
	 */
	public XDom addElement(String name) {
		Document document = e.getOwnerDocument();
		Element element = document.createElement(name);
		e.appendChild(element);
		return new XDom(element);
	}

	/**
	 * 添加节点和值
	 * 
	 * @param name
	 * @param value
	 * @return
	 */
	public XDom addElement(String name, String value) {
		Document document = e.getOwnerDocument();
		Element element = document.createElement(name);
		e.appendChild(element);
		element.appendChild(document.createTextNode(value));
		return new XDom(element);
	}

	/**
	 * 给节点添加属性
	 * 
	 * @param name
	 * @param value
	 * @return
	 */
	public XDom setAttribute(String name, String value) {
		e.setAttribute(name, value);
		return this;
	}

	/**
	 * 给节点添加属性
	 * 
	 * @param name
	 * @param value
	 * @return
	 */
	public XDom setAttribute(String name, int value) {
		setAttribute(name, String.valueOf(value));
		return this;
	}

	/**
	 * 删除节点名字为name的所有节点
	 * 
	 * @param name
	 */
	public void removeElement(String name) {
		NodeList nodeList = e.getElementsByTagName(name);
		if (nodeList == null) {
			return;
		}

		for (int i = 0; i < nodeList.getLength(); i++) {
			e.removeChild(nodeList.item(i));
		}
	}

	/**
	 * 删除节点的属性
	 * 
	 * @param name
	 */
	public void removeAttribute(String name) {
		e.removeAttribute(name);
	}

	/**
	 * 更新节点内容
	 * 
	 * @param name
	 * @param value
	 * @return
	 */
	public XDom updateElementText(String name, String value) {
		Element element = (Element) e.getElementsByTagName(name).item(0);
		Node textNode = element.getFirstChild();
		textNode.setNodeValue(value);
		return this;
	}

	public XDom updateElementText(String value) {
		Node textNode = e.getFirstChild();
		textNode.setNodeValue(value);
		return this;
	}

	public void write(OutputStream os, String encoding) {
		try {
			TransformerFactory factory = TransformerFactory.newInstance();
			factory.setAttribute("indent-number", 2);
			Transformer transformer = factory.newTransformer();
			transformer.setOutputProperty(OutputKeys.ENCODING, encoding);
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");
			transformer.transform(new DOMSource(e.getOwnerDocument()),
					new StreamResult(new OutputStreamWriter(os)));
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (TransformerFactoryConfigurationError e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}

	public void write(OutputStream os) {
		write(os, "UTF-8");
	}

	public void write(String xmlFile, String encoding) throws IOException {
		OutputStream os = null;
		try {
			os = new FileOutputStream(xmlFile);
			write(os, encoding);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (os != null) {
				os.close();
			}
		}
	}

	public void write(String xmlFile) {
		try {
			write(xmlFile, "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
