package pl.agh.test;

public interface LibraryBooker {
    void borrowBook(int bookId) throws BookException;
    void reserveBook(int bookId) throws BookException;
    void returnBook(int bookId) throws BookException;
}
