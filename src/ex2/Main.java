package ex2;

import java.util.Scanner;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.transform.TransformerFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter student id: ");
        String id = scanner.nextLine();
        System.out.println("Enter student name: ");
        String name = scanner.nextLine();
        System.out.println("Enter student class: ");
        String className = scanner.nextLine();
        System.out.println("Enter student score: ");
        double score = scanner.nextDouble();

        Student student = new Student(id, name, className, score);

        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            File inputFile = new File("student.xml");
            Document doc;

            if (inputFile.exists()) {
                doc = dBuilder.parse(inputFile);
                doc.getDocumentElement().normalize();
            } else {
                doc = dBuilder.newDocument();
                Element rootElement = doc.createElement("students");
                doc.appendChild(rootElement);
            }

            Element rootElement = doc.getDocumentElement();

            Element studentElement = doc.createElement("student");
            rootElement.appendChild(studentElement);

            Element idElement = doc.createElement("id");
            idElement.appendChild(doc.createTextNode(student.getId()));
            studentElement.appendChild(idElement);

            Element nameElement = doc.createElement("name");
            nameElement.appendChild(doc.createTextNode(student.getName()));
            studentElement.appendChild(nameElement);

            Element classElement = doc.createElement("class");
            classElement.appendChild(doc.createTextNode(student.getClassName()));
            studentElement.appendChild(classElement);

            Element scoreElement = doc.createElement("score");
            scoreElement.appendChild(doc.createTextNode(Double.toString(student.getScore())));
            studentElement.appendChild(scoreElement);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("student.xml"));
            transformer.transform(source, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}