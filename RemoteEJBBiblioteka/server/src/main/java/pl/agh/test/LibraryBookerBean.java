package pl.agh.test;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateful;
import java.util.ArrayList;
import java.util.List;

@Stateful
@Remote(LibraryBooker.class)
public class LibraryBookerBean implements LibraryBooker {
    List<Book> reservedBooks;
    @EJB
    LibraryBox libraryBox;

    @PostConstruct
    public void createCustomer() {
        this.reservedBooks = new ArrayList<>();
    }

    @Override
    public void borrowBook(int bookId) throws BookException {
        try {
            Book book = libraryBox.getBooksList().get(bookId);
            Boolean isYourReservation = false;
            for (int i = 0; i < reservedBooks.size(); i++) {
                if (book.getId() == reservedBooks.get(i).getId())
                    isYourReservation = true;
            }
            //nie twoja rezerwacja
            if (book.isReserved()) {
                if (!isYourReservation) {
                    throw new BookException("Nie można wypożyczyć tej książki!");
                }
            } else {
                if (book.isBorrowed()) {
                    throw new BookException("Nie można wypożyczyć tej książki!");
                }
                //wypozyczenie bez wczesniejszej rezerwacji
                if (!reservedBooks.contains(book)) {
                    reservedBooks.add(book);
                }
            }
        } catch (IndexOutOfBoundsException e) {
            throw new BookException("Niepoprawne ID!");
        }
        libraryBox.bookBook(bookId);
        System.out.println("Książka wypożyczona.");
    }

    @Override
    public void reserveBook(int bookId) throws BookException {
        try {
            Book book = libraryBox.getBooksList().get(bookId);
            if (book.isBorrowed() || book.isReserved()) {
                throw new BookException("Nie można zarezerwować tej książki!");
            }
            reservedBooks.add(book);
            libraryBox.reserveBook(bookId);
            System.out.println(reservedBooks.toString());
        } catch (IndexOutOfBoundsException e) {
            throw new BookException("Niepoprawne ID!");
        }
        System.out.println("Rezerwacja przyjęta.");
    }

    @Override
    public void returnBook(int bookId) throws BookException {
        try {
            Book book = libraryBox.getBooksList().get(bookId);
            Boolean isYourReservation = false;
            for (int i = 0; i < reservedBooks.size(); i++) {
                if (book.getId() == reservedBooks.get(i).getId())
                    isYourReservation = true;
            }
            //nie twoja rezerwacja
            if (book.isReserved()) {
                if (!isYourReservation) {
                    throw new BookException("Nie można oddać tej książki!");
                }
            } else
                //niewypozyczona
                if (!book.isBorrowed() || !isYourReservation) {
                    throw new BookException("Nie można oddać tej książki!");
                }
            reservedBooks.remove(book);
        } catch (IndexOutOfBoundsException e) {
            throw new BookException("Niepoprawne ID");
        }
        libraryBox.returnBook(bookId);
        System.out.println("Zwrot przyjęty / rezerwacja zakończona.");
    }
}
