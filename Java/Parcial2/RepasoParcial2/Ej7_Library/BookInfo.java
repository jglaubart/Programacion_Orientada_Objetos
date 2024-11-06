package Parcial2.RepasoParcial2.Ej7_Library;

public class BookInfo {
    private final String name;
    private int stock;

    public BookInfo(String name, int stock) {
        this.name = name;
        this.stock = stock;
    }

    public void borrowBook() {
        if (stock == 0) {
            throw new IllegalStateException();
        }
        stock--;
    }

    public void returnBook() {
        stock++;
    }

}
