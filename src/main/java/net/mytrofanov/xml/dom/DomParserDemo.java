package net.mytrofanov.xml.dom;

import org.w3c.dom.*;

import java.io.File;

public class DomParserDemo {
    public static void main(String[] args) {
        try {
            File studentsFile = new File("src/main/resources/input.txt");
            File carsFile = new File("src/main/resources/input_cars.txt");
            Document studentDocument = DomXmlReader.createDocument(studentsFile);
            Document carsDocument = DomXmlReader.createDocument(carsFile);
            studentDocument.getDocumentElement().normalize();
            carsDocument.getDocumentElement().normalize();


            System.out.println("Root element :" + studentDocument.getDocumentElement().getNodeName());
            NodeList nodeList = studentDocument.getElementsByTagName("student");
            System.out.println("--------------------");

            for (int temp = 0; temp < nodeList.getLength(); temp++) {
                Node node = nodeList.item(temp);
                System.out.println("\nCurrent Element :" + node.getNodeName());
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    System.out.println("Student roll no : " + element.getAttribute("rollno"));
                    System.out.println("First name : " + element.getElementsByTagName("firstname").item(0).getTextContent());
                    System.out.println("Last name : " + element.getElementsByTagName("lastname").item(0).getTextContent());
                    System.out.println("Nick name : " + element.getElementsByTagName("nickname").item(0).getTextContent());
                    System.out.println("Marks : " + element.getElementsByTagName("marks").item(0).getTextContent());
                }
            }

            System.out.print("Root element: ");
            System.out.println(carsDocument.getDocumentElement().getNodeName());
            NodeList nList = carsDocument.getElementsByTagName("supercars");
            System.out.println("----------------------------");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("\nCurrent Element :");
                System.out.print(nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.print("company : ");
                    System.out.println(eElement.getAttribute("company"));
                    NodeList carNameList = eElement.getElementsByTagName("carname");

                    for (int count = 0; count < carNameList.getLength(); count++) {
                        Node node1 = carNameList.item(count);

                        if (node1.getNodeType() == node1.ELEMENT_NODE) {
                            Element car = (Element) node1;
                            System.out.print("car name : ");
                            System.out.println(car.getTextContent());
                            System.out.print("car type : ");
                            System.out.println(car.getAttribute("type"));
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
