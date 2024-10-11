package Parcial1.P21_04_22.Ej3_CityPass;

import java.time.LocalDate;

public class DueDatePass extends IlimitedPass{
    private final LocalDate dueDate;

    public DueDatePass(Attraction[] att, String name, LocalDate date, LocalDate dueDate){
        super(att, name, date);
        this.dueDate = dueDate;
    }

    @Override
    public void visit(Attraction attraction, LocalDate date){
        if(date.isAfter(dueDate)){
            throw new CannotVisitAttractionException(attraction);
        }
        super.visit(attraction, date);
    }
}
