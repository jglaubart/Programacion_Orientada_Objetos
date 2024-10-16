package Guias.guia7.ej4_Ranker;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Ranker {
    private final Set<RankedBook> books = new TreeSet<>();  //los debe tener ordenados segun orden natural (ranking descendente)

    public Ranker add(Genre genre, Book book){
        books.add(new RankedBook(book, genre));
        return this;
    }

    public void rateUp(Book book) {
        boolean found = false;
        /**
         * Busco el libro de la colección para removerlo,
         * aumentar en uno el ranking y volverlo a insertar.
         */
        Iterator<RankedBook> iterator = books.iterator();
        while (iterator.hasNext() && !found) {
            RankedBook rankedBook = iterator.next();
            if(rankedBook.getBook().equals(book)) {
                iterator.remove();
                books.add(new RankedBook(rankedBook));
                found = true;
            }
        }
        if(!found) {
            books.add(new RankedBook(book));
        }
    }


    public void printRanking() {
        System.out.println("General Ranking");
        for(RankedBook rankedBook : books) {
            System.out.println(rankedBook);
        }
    }


    public void printRanking(Genre genre) {
        System.out.println("Ranking of " + genre);
        for(RankedBook rankedBook : books) {
            if(genre.equals(rankedBook.getGenre())) {
                System.out.println(rankedBook);
            }
        }
    }

}
