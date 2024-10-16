package Guias.guia7.ej1_FilterList;

import java.util.ArrayList;

public class ArrayFilterList<T> extends ArrayList<T> implements FilterList<T>{

    @Override
    public FilterList<T> getFilterList(Criteria<T> criteria) {
        FilterList<T> ans = new ArrayFilterList<>();
        for(T elem : this){
            if(criteria.satisfiesCriteria(elem)){
                ans.add(elem);
            }
        }
        return ans;
    }
}
