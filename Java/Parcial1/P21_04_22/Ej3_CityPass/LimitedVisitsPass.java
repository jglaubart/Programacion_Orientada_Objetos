package Parcial1.P21_04_22.Ej3_CityPass;

import java.time.LocalDate;

public class LimitedVisitsPass extends IlimitedPass{
    private final int limit;

    public LimitedVisitsPass(Attraction[] att, String name, LocalDate date, int limit){
        super(att, name, date);
        this.limit = limit;
    }

    @Override
    public void visit(Attraction attraction, LocalDate date){
        if(getTimesUsed() == limit){
            throw new CannotVisitAttractionException(attraction);
        }
        super.visit(attraction, date);
    }
}
