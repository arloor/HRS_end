package presentation.utility;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Qin Liu on 2016/12/11.
 */
public class XMLDao {

    /**
     * 根据某个城市的名字获取此城市的所有商圈
     *
     * @param city
     * @return
     */
    public static List<String> getCircles(String city) {
        List<String> list = new ArrayList<String>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            factory.setIgnoringElementContentWhitespace(true);

            DocumentBuilder db = factory.newDocumentBuilder();
            InputStream is = XMLDao.class.getResourceAsStream("xml/Circles.xml");
            Document xmldoc = db.parse(is);
            Element root = xmldoc.getDocumentElement();

            NodeList nodes = selectNodes("//Circle[@City='" + city + "']", root);
            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);
                String name = node.getTextContent();
                list.add(name);
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 获取所有城市
     *
     * @return
     */
    public static List<String> getCities() {
        List<String> list = new ArrayList<String>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            factory.setIgnoringElementContentWhitespace(true);

            DocumentBuilder db = factory.newDocumentBuilder();
            InputStream is = XMLDao.class.getResourceAsStream("xml/Cities.xml");
            Document xmldoc = db.parse(is);
            Element root = xmldoc.getDocumentElement();

            NodeList nodes = selectNodes("/Cities/City", root);
            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);
                String name = node.getTextContent();
                list.add(name);
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 根据商圈找到其所属城市
     *
     * @param circle
     * @return
     */
    public static String findCity(String circle) {
        ArrayList<String> cities = (ArrayList<String>) XMLDao.getCities();
        for (String city : cities) {
            ArrayList<String> circles = (ArrayList<String>) XMLDao.getCircles(city);

            for (String tempCircle : circles) {
                if (circle.equals(tempCircle)) {
                    return city;
                }
            }
        }
        return null;
    }

    /**
     * 根据xpath获取某一个节点
     *
     * @param express
     * @param source
     * @return
     */
    public static Node selectSingleNode(String express, Object source) {// 查找节点，并返回第一个符合条件节点
        Node result = null;
        XPathFactory xpathFactory = XPathFactory.newInstance();
        XPath xpath = xpathFactory.newXPath();
        try {
            result = (Node) xpath
                    .evaluate(express, source, XPathConstants.NODE);
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * 根据xpath获取符合条件的所有节点
     *
     * @param express
     * @param source
     * @return
     */
    public static NodeList selectNodes(String express, Object source) {// 查找节点，返回符合条件的节点集。
        NodeList result = null;
        XPathFactory xpathFactory = XPathFactory.newInstance();
        XPath xpath = xpathFactory.newXPath();
        try {
            result = (NodeList) xpath.evaluate(express, source,
                    XPathConstants.NODESET);
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }

        return result;
    }

}
