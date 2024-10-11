package Parcial1.Rec27_06_24.Ej3_Garage;

import java.util.Arrays;
import java.util.Comparator;

public abstract class Garage {
    private final int IN_DIM = 5;
    private int dim=0;
    private Stay[] stays = new Stay[IN_DIM];
    private final Comparator<Stay> cmp;

    protected Garage (Comparator<Stay> cmp){
        this.cmp = cmp;
    }

    public Stay[] getStaysCopy(){
        Stay[] ans = Arrays.copyOf(stays, dim);
        Arrays.sort(ans, cmp);
        return ans;
    }

    private void resize(){
        stays = Arrays.copyOf(stays, dim + IN_DIM);
    }
    public Garage addStay(String plate, int days){
        if(dim== stays.length){
            resize();
        }
        stays[dim++] = new Stay(plate, days);
        return this;
    }
}
