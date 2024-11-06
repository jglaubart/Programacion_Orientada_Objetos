package Parcial2.RepasoParcial2.Ej7_Library;

import java.time.LocalDate;

public class Loan {

    private final String book;
    private final Person person;
    private final LocalDate date;

    public Loan(String book, Person person, LocalDate date) {
        this.book = book;
        this.person = person;
        this.date = date;
    }

    public String getBook() {
        return book;
    }

    public boolean vencido (LocalDate date) {
        return date.isAfter(this.date.plusDays(person.getDays()));
    }

    @Override
    public String toString() {
        return "%s (%s - %s)".formatted(person.getName(), book, date);
        //Professor 3 (Book 3 - 2018-12-04)
    }
}
