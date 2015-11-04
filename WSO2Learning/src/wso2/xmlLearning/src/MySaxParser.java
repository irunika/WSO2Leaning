package wso2.xmlLearning.src;

import org.xml.sax.SAXException;

import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Source;
import java.io.File;
import java.io.IOException;

/**
 * Created by irunika on 11/4/15.
 */
public class MySaxParser {
    public static void main(String[] args){

        try {
            String filePath = "/home/irunika/IdeaProjects/WSO2Learning/src/wso2/xmlLearning/xmlFiles/data.xml";
            File file = new File(filePath);

            SAXParserFactory factory = SAXParserFactory.newInstance();
            factory.setValidating(true);
            factory.setNamespaceAware(false);
            SAXParser parser = factory.newSAXParser();
            My_SAX_XmlHandler handler = new My_SAX_XmlHandler();
            parser.parse(file, handler);

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
