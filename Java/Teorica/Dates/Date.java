package Teorica.Dates;

import java.util.Objects;

public class Date {
    private int day, month, year;
    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }
    public int getMonth() {
        return month;
    }
    public int getYear() {
        return year;
    }
    public void setDay(int day) {
        this.day = day;
    }
    public void setMonth(int month) {
        this.month = month;
    }
    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Date Aux) //si instanceof true, directamente crea la variable aux de obj casteado a Date
                && (day == Aux.day && month == Aux.month && year == Aux.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(day, month, year);
    }

    @Override
    public String toString() {
        return "%d/%d/%d".formatted(day, month, year);
        // return day + "/" + month + "/" + year; OTRA OPCION
    }



}
