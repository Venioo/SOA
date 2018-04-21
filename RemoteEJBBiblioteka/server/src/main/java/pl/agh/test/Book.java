package pl.agh.test;

public class Book {
    private int id;
    private String author;
    private String title;
    private boolean borrowed;
    private boolean reserved;


    public Book(int id, String author, String title) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.borrowed = false;
        this.reserved = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }
}