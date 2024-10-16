package Guias.guia7.ej1_FilterList;

public class ArrayFilterListTester {
    public static void main(String[] args) {
        FilterList<Integer> intList = new ArrayFilterList<>();

        for(int i = 0; i < 10; i++){
            intList.add(i);
        }

        System.out.println(intList.getFilterList(n -> n % 2 == 0));
    }
}
