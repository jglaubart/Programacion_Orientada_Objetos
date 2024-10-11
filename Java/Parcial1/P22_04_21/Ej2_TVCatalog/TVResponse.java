package Parcial1.P22_04_21.Ej2_TVCatalog;

public class TVResponse {
    private TVShow show;
    private boolean inRange;

    public TVResponse(TVShow show, boolean inRg){
        this.show = show;
        this.inRange = inRg;
    }

    @Override
    public String toString(){
        return "%s : %.2f ### %s Range".formatted(show.getName(), show.getRating(), inRange ? "In" : "Out of");
    }


}
