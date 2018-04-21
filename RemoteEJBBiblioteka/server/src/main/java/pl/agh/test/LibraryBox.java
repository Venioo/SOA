package pl.agh.test;

import org.jboss.logging.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.annotation.PostConstruct;
import javax.ejb.Lock;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import java.io.File;
import java.util.ArrayList;

import static javax.ejb.LockType.READ;
import static javax.ejb.LockType.WRITE;

@Singleton
@Startup
public class LibraryBox {
    private ArrayList<Book> booksList;
    private static final Logger logger =
            Logger.getLogger(LibraryBox.class);

    @PostConstruct
    public void setupLibrary() {
        booksList = new ArrayList<Book>();
        try {
            File fXmlFile = new File("D:/Informatyka/workspace/RemoteEJBBiblioteka/server/src/main/resources/books.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("book");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    int id = Integer.parseInt(eElement.getAttribute("id"));
                    String author = eElement.getElementsByTagName("author").item(0).getTextContent();
                    String title = eElement.getElementsByTagName("title").item(0).getTextContent();
                    booksList.add(new Book(id, author, title));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Lock(READ)
    public ArrayList<Book> getBooksList() {
        return booksList;
    }

    @Lock(WRITE)
    public void bookBook(int bookId) {
        Book book = getBooksList().get(bookId);
        book.setBorrowed(true);
    }

    @Lock(WRITE)
    public void reserveBook(int bookId) {
        Book book = getBooksList().get(bookId);
        book.setReserved(true);
    }

    @Lock(WRITE)
    public void returnBook(int bookId) {
        Book book = getBooksList().get(bookId);
        book.setBorrowed(false);
        book.setReserved(false);
    }
}