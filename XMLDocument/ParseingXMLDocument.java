package XMLDocument;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;

public class ParseingXMLDocument {
    public static void main(String[] args) {
        try{
            DocumentBuilderFactory documentBuilderFactory= DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder=documentBuilderFactory.newDocumentBuilder();
            Document document=documentBuilder.parse("books.xml");

            document.getDocumentElement().normalize();
            System.out.println("Root element: " + document.getDocumentElement().getNodeName());

            NodeList nodeList=document.getElementsByTagName("book");
            for(int i=0;i<nodeList.getLength();i++){
                Node node=nodeList.item(i);
                if(node.getNodeType()==Node.ELEMENT_NODE){
                    Element element=(Element) node;
                    String title = element.getElementsByTagName("title").item(0).getTextContent();
                    String author = element.getElementsByTagName("author").item(0).getTextContent();

                    System.out.println("Book " + (i + 1) + " Title: " + title);
                    System.out.println("Book " + (i + 1) + " Author: " + author);
                    System.out.println(); 
                }
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}

