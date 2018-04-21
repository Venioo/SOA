package zadanie5;

import java.util.ArrayList;

public class Film {
    private String title;
    private String genre;
    private String year;
    private String revenue;

    public Film(String title, String genre, String year, String revenue) {
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.revenue = revenue;
    }

    public String getTitle() {
        return this.title;
    }

    public String getGenre() {
        return this.genre;
    }

    public String getYear() {
        return this.year;
    }

    public String getRevenue() {
        return this.revenue;
    }
}
