package pl.agh.test;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import java.util.ArrayList;

@Stateless
@Remote(LibraryInfo.class)
public class LibraryInfoBean implements LibraryInfo {
    @EJB
    LibraryBox box;

    @Override
    public String printBookList() {
        ArrayList<Book> books = box.getBooksList();
        StringBuffer sb = new StringBuffer();
        sb.append("\n");
        sb.append("ID Autor   Tytuł Zarezerwowana\n");
        for (int i = 0; i < books.size(); i++)
            if (!books.get(i).isBorrowed()) {
                sb.append(books.get(i).getId() + ". " + books.get(i).getAuthor() + " " + books.get(i).getTitle() + " " + books.get(i).isReserved());
                sb.append("\n");
            }
        return sb.toString();
    }

}