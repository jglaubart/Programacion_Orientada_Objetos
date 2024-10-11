package Parcial1.P22_09_2022.Ej2_StockInventory;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class StockInventory implements Iterable<StockResult>{
    private int INI_DIM = 5;
    private StockProduct[] products;
    private int dim;

    private Predicate<Integer> minStock;

    public StockInventory() {
        this.products = new StockProduct[INI_DIM];
        setMinimumStock(cant -> cant <= 1);
    }

    public void setMinimumStock(Predicate<Integer> minStock) {
        this.minStock = minStock;
    }

    public void add(String name, int cant) {
        if(cant < 0){
            throw new IllegalArgumentException("Stock cannot be negative.");
        }
        if(dim == products.length) {
            resize();
        }
        products[dim++] = new StockProduct(name, cant);
    }

    private void resize() {
        products = Arrays.copyOf(products, dim + INI_DIM);
    }

    public void reduceStock(String name){
        for (int i = 0; i < dim; i++) {
            if(products[i].getProduct().equals(name)) {
                products[i].reduceStock();
                return;
            }
        }
        throw new IllegalArgumentException("Product not found");
    }

    @Override
    public Iterator<StockResult> iterator() {
        return new StockResultIt();
    }

    private class StockResultIt implements Iterator<StockResult> {
        private int current = 0;
        private final Predicate<Integer> currentStock = minStock;

        @Override
        public boolean hasNext() {
            return current < dim;
        }

        @Override
        public StockResult next() {
            if(!hasNext()) {
                throw new NoSuchElementException();
            }
            StockProduct prod = products[current++];
            boolean low = currentStock.test(prod.getStock());
            return new StockResult(prod, low);
        }
    }
}
