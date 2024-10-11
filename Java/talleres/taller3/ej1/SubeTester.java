package talleres.taller3.ej1;

public class SubeTester {
    public static void main(String[] args) {
        Central sc = new Central(25);

        TarjetaFija fsc = new TarjetaFija(sc, 2);
        fsc.viajar();
        fsc.viajar();
        fsc.viajar(); // Imprime un mensaje de error

        TarjetaRecargable rsc = new TarjetaRecargable(sc);
        rsc.Recargar(50);
        rsc.viajar();
        sc.CambiarPrecio(30);
        rsc.viajar(); // Imprime un mensaje de error

        RecargableDescuento drsc = new RecargableDescuento(sc, 0.50);
        drsc.Recargar(30);
        drsc.viajar();
        drsc.viajar();
        drsc.viajar(); // Imprime un mensaje de error
    }
}
