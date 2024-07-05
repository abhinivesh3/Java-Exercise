
// XML Document Creating and Parsing
// Learn about different types of parsers and difference between them.
// Create a XML document, insert multiple nodes of your choice and save it in a XML file.
// Parse the above created XML file and print the nodes and their values.
// Tips:
// Go through Element, DocumentBuilder, Document for XML related apis in java
// Go through the example here to parse a XML file using these apis

package XMLDocument;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class CreatingXMLDocument {

    private static Element createBookElement(Document document,String title,String author){
        Element book = document.createElement("book");
        
        Element titleElement = document.createElement("title");
        titleElement.appendChild(document.createTextNode(title));
        book.appendChild(titleElement);
        
        Element authorElement = document.createElement("author");
        authorElement.appendChild(document.createTextNode(author));
        book.appendChild(authorElement);
        
        return book;
    }

    public static void main(String[] args) {
        try{
            DocumentBuilderFactory documentBuilderFactory= DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder=documentBuilderFactory.newDocumentBuilder();
            Document document=documentBuilder.newDocument();

            Element rootElement = document.createElement("catalog");
            document.appendChild(rootElement);
            
            Element book1 = createBookElement(document, "The Hobbit", "J.R.R. Tolkien");
            rootElement.appendChild(book1);
            
            Element book2 = createBookElement(document, "1984", "George Orwell");
            rootElement.appendChild(book2);
            
            Element book3 = createBookElement(document, "Pride and Prejudice", "Jane Austen");
            rootElement.appendChild(book3);
            
            
            File xmlFile = new File("books.xml");
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(xmlFile);
            transformer.transform(source, result);
            
            System.out.println("XML file saved successfully!");
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
