package Parcial1.P22_09_2022.Ej2_StockInventory;

public class StockResult {
    private final StockProduct product;
    private final boolean lowStock;

    public StockResult(final StockProduct product, final boolean lowStock) {
        this.product = product;
        this.lowStock = lowStock;
    }

    @Override
    public String toString() {
        return "%s <> %s".formatted(product, lowStock ? "Low Stock!" : "Stock OK");
    }
}
