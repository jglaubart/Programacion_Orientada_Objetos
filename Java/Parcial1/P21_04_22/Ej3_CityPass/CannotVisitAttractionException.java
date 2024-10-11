package Parcial1.P21_04_22.Ej3_CityPass;

public class CannotVisitAttractionException extends RuntimeException {
    public CannotVisitAttractionException(Attraction att) {
        super("Cannot Visit Attraction %s".formatted(att));
    }
}
