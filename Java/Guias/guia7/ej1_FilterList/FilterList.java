package Guias.guia7.ej1_FilterList;

import java.util.List;

public interface FilterList<T> extends List<T> {
    FilterList<T> getFilterList(Criteria<T> criteria);
}
