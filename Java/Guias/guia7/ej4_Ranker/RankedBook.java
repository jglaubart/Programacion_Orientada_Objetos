package Guias.guia7.ej4_Ranker;

import java.util.Objects;

public class RankedBook implements Comparable<RankedBook>{  //clase interna que se crea cuando se agrega el libro a la coleccion de RankedBooks
    private final Book book;
    private int ranking;
    private Genre genre;

    public RankedBook(Book book, Genre genre) {
        this.book = book;
        this.genre = genre;
    }

    public RankedBook(Book book) {   //por si no tiene genero asignado
        this.book = book;
        ranking = 1;  //solo se usa esto si se agrega uno nuevo al usar rateUp y no exisita previamente
    }

    RankedBook(RankedBook rankedBook) {
        this.book = rankedBook.book;
        this.ranking = rankedBook.ranking + 1;
        this.genre = rankedBook.genre;
    }


    public void rateUp(){
        ranking++;
    }

    public Book getBook() {
        return book;
    }

    public Genre getGenre() {
        return genre;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof RankedBook that &&
                book.equals(that.book) &&
                genre == that.genre;
    }

    @Override
    public int hashCode() {
        return Objects.hash(book, genre);
    }

    @Override
    public String toString() {
        return "%s : %d".formatted(book, ranking);
    }

    @Override
    public int compareTo(RankedBook o) {  //orden natural ordenado segun el ranking descendente
        int rankingCompare = Integer.compare(o.ranking, ranking);
        if(rankingCompare == 0) {
            return book.compareTo(o.book);
        }
        return rankingCompare;
    }
}
