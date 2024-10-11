package Parcial1.P22_04_21.Ej2_TVCatalog;

public interface TVCatalog extends Iterable<TVResponse>{
    TVCatalog addTVShow(String name, double rating);

    void setRatingRange(double min, double max);
}
