package Guias.guia6.ej5_Function;

import java.util.ArrayList;
import java.util.List;

public class CompositeFunction implements Function {
    private List<Function> functions = new ArrayList<>();

    public void addFunction(Function f){
        functions.add(f);
    }

    @Override
    public double evaluate(double x) {
        double ans = x;
        if(functions.isEmpty()){
            throw new IllegalStateException();
        }

        for(Function f : functions){
            ans = f.evaluate(ans);
        }
        return ans;
    }
}
