package wso2.xmlLearning.src;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by irunika on 11/4/15.
 */
public class My_SAX_XmlHandler extends DefaultHandler{
    private boolean bName = false;
    private boolean bAge = false;


    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if(qName.equalsIgnoreCase("person")){
           String index = attributes.getValue("index");
            System.out.println("Index No : " + index);
        }
        if(qName.equalsIgnoreCase("name")){
            bName = true;
        }
        if(qName.equalsIgnoreCase("age")){
            bAge = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException{
        if(qName.equalsIgnoreCase("person")){
        System.out.println("");
        }
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException{
        if(bName){
            System.out.println("Name : " + new String(ch, start, length));
            bName = false;
        }
        else if(bAge){
            System.out.println("Age: " + new String(ch, start, length));
            bAge = false;
        }
    }
}
