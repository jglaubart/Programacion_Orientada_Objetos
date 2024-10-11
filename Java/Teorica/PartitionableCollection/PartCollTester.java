package Teorica.PartitionableCollection;

public class PartCollTester {
    public static void main(String[] args) {
        PartitionableCollection<Integer> pC = new PartitionableCollection<>();
        pC.add(6); pC.add(2); pC.add(3); pC.add(6);
        System.out.println(pC.isEmpty()); // false
        System.out.println(pC.size()); // 4
        System.out.println(pC.contains(6)); // true
        for(Integer elem : pC) {
            System.out.println(elem); // 6 2 3 6
        }
        PartitionableCollection<Integer> onlyEven = pC.getSelected(i -> i % 2 == 0);
        for(Integer elem : onlyEven) {
            System.out.println(elem); // 6 2 6
        }
        for(Integer elem : pC.getRejected(i -> i % 2 == 0)) {
            System.out.println(elem); // 3
        }

    }
}
