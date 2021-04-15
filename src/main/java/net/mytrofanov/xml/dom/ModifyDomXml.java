package net.mytrofanov.xml.dom;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import java.io.File;

public class ModifyDomXml {
    public static void main(String[] args) {
        
        try {
            Document doc = DomXmlReader.createDocument(new File("src/main/resources/input_cars.txt"));
            Node cars = doc.getFirstChild();
            Node supercar = doc.getElementsByTagName("supercars").item(0);

            // update supercar attribute
            NamedNodeMap attr = supercar.getAttributes();
            Node nodeAttr = attr.getNamedItem("company");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
