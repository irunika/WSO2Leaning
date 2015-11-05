package wso2.xmlLearning.src;

/**
 * Created by irunika on 11/4/15.
 */

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;

public class MyStaxParser {

    public static void main(String[] args){


        boolean bName = false;
        boolean bAge = false;

        try {
            String filePath = "/home/irunika/IdeaProjects/WSO2Learning/src/wso2/xmlLearning/xmlFiles/data.xml";
            FileReader file = new FileReader(filePath);

            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLEventReader reader = factory.createXMLEventReader(file);

            while (reader.hasNext()){
                XMLEvent event = reader.nextEvent();

                switch (event.getEventType()){
                    case XMLStreamConstants.START_ELEMENT:
                        StartElement startElement = event.asStartElement();
                        String qName = startElement.getName().getLocalPart();
                        if(qName.equalsIgnoreCase("person")){
                            Iterator<Attribute> attributes = startElement.getAttributes();
                            while (attributes.hasNext()){
                                String index = attributes.next().getValue();
                                System.out.println("Index : " + index);
                            }
                        }else if(qName.equalsIgnoreCase("name")) bName = true;
                        else if(qName.equalsIgnoreCase("age")) bAge = true;
                        break;

                    case XMLStreamConstants.CHARACTERS:
                        Characters characters = event.asCharacters();
                        if(bName){
                            System.out.println("Name : " + characters.getData());
                            bName = false;
                        }
                        if(bAge){
                            System.out.println("Age : " + characters.getData());
                            bAge = false;
                            System.out.println();
                        }
                        break;

                    case XMLStreamConstants.END_ELEMENT:
                        EndElement endElement = event.asEndElement();
//                        System.out.println();
                        break;
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }
}
