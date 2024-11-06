package Parcial2.RepasoParcial2.Ej7_Library;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class Library {

    private final Map<String, BookInfo> booksStock = new HashMap<>();
    private final Map<Person,Loan> loans = new HashMap<>();

    public Library addBook(String name, int stock){
        booksStock.put(name, new BookInfo(name, stock));
        return this;
    }

    public void borrowBook(Person person, String book, LocalDate date){
        if(loans.containsKey(person)){
            throw new IllegalArgumentException("Person already has a loan");
        }
        BookInfo toBorrowBook = booksStock.get(book);
        if (toBorrowBook == null){
            throw new NoSuchElementException("Book not found");
        }
        toBorrowBook.borrowBook();
        loans.put(person, new Loan(book, person, date));
    }

    public void printDueLoansBooks(LocalDate date){
        System.out.printf("Due loans at %s\n", date);
        for(Map.Entry<Person,Loan> entry: loans.entrySet()){
            Person person = entry.getKey();
            Loan loan = entry.getValue();
            if (loan.vencido(date)){
                System.out.println(loan);
            }
        }
        System.out.println();
    }

    public void returnBook(Person person){
        Loan loan = loans.get(person);
        loans.remove(person);
        if(loan == null){
            throw new IllegalArgumentException();
        }
        BookInfo bookInfo = booksStock.get(loan.getBook());  //no puede ser null, si se hizo el prestamo es que existe. Como mucho tendra 0 de stock
        bookInfo.returnBook();
    }
}
