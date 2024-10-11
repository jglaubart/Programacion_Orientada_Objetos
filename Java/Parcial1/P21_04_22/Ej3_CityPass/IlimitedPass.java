package Parcial1.P21_04_22.Ej3_CityPass;

import org.w3c.dom.Attr;

import java.time.LocalDate;

public class IlimitedPass implements CityPass{
    private Attraction[] attractions;
    private String name;
    private LocalDate issueDate;
    private int timesUsed = 0;

    public IlimitedPass(Attraction[] att, String name, LocalDate date){
        this.attractions = att;
        this.name = name;
        this.issueDate = date;
    }

    private boolean findAttraction(Attraction att){
       for (Attraction attr : attractions){
           if(attr.equals(att)){
               return true;
           }
       }
       return false;
    }

    // Registra una visita a la atracción en una fecha
    public void visit(Attraction attraction, LocalDate date){
        if(date.isBefore(issueDate) || !findAttraction(attraction)){
            throw new CannotVisitAttractionException(attraction);
        }
        System.out.printf("%s visited %s\n", name, attraction);
        timesUsed++;
    }

    // Retorna las atracciones aceptadas por el pase
    public Attraction[] getAttractions(){
        return attractions;
    }

    @Override
    public String toString(){
        return "CityPass for %s used for %d attractions".formatted(name, timesUsed);
    }

    protected int getTimesUsed(){
        return timesUsed;
    }
}
