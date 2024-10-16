package Guias.guia7.ej4_Ranker;

import java.util.Objects;

public class Book implements Comparable<Book> {
    private final String title, author;
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Book book&&
                title.equals(book.title) &&
                author.equals(book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author);
    }

    @Override
    public String toString() {
        return title;
    }

    @Override
    public int compareTo(Book book) {
        int cmp = title.compareTo(book.title);
        if(cmp == 0) {
            cmp = author.compareTo(book.author);
        }
        return cmp;
    }
}
