package Parcial1.P28_09_2023.Ej3_Report;

public interface ReportCollection<R> {

    void add(R report);


    R get(int index);


    R[] reports();
}
