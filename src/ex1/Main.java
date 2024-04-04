package ex1;

import java.io.File;
import java.io.IOException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Main {
    public static void main(String[] args) throws SAXException, TransformerConfigurationException, TransformerException {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = docFactory.newDocumentBuilder();
            Document document = builder.parse(new File("Library.xml"));
            NodeList bookList = document.getElementsByTagName("book");
            System.out.println("Number of books: " + bookList.getLength());
            for (int i = 0; i < bookList.getLength(); i++) {
                Node book = bookList.item(i);
                Element BookEle = (Element) book;
                System.out.println("ID: " + BookEle.getAttribute("id"));
                System.out.println("Title: " + BookEle.getElementsByTagName("title").item(0).getTextContent());
                System.out.println("Author: " + BookEle.getElementsByTagName("author").item(0).getTextContent());
                System.out.println("Year: " + BookEle.getElementsByTagName("year").item(0).getTextContent());
                System.out.println();
            }

        } catch (ParserConfigurationException | IOException e) {
            e.printStackTrace();
        }
    }
}
