package wso2.xmlLearning.src;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import java.io.File;
import java.io.IOException;

/**
 * Created by irunika on 11/4/15.
 */
public class MyDomParsing {
    public static void main(String[] args){
        String filepath = "/home/irunika/IdeaProjects/WSO2Learning/src/wso2/xmlLearning/xmlFiles/data.xml";
        File file = new File(filepath);

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(file);
            printNode(doc, "");

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printNode(Document doc, String indent){
        doc.getDocumentElement().normalize();
        System.out.println("Root : " + doc.getDocumentElement().getNodeName());

        NodeList nodeList = doc.getElementsByTagName("Person");

        for(int i=0; i<nodeList.getLength() ; i++){
            Node node = nodeList.item(i);

            if(node.getNodeType() == Node.ELEMENT_NODE){
                Element element = (Element) node;
                System.out.println("Index : " + element.getAttribute("index"));

                System.out.println("Name : " + element.getElementsByTagName("name").item(0).getTextContent());
                System.out.println("Age : " + element.getElementsByTagName("age").item(0).getTextContent());
                System.out.println();
            }
        }
    }
}
