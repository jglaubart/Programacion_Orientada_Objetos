package talleres.taller3.ej2;


public class SubeTester {
    public static void main(String[] args) {
        Central sc = new Central(25);

        TarjetaFija fsc = new TarjetaFija(sc, 2);
        try{
            fsc.viajar();
        }catch(CannotRideException ex){
            System.err.println(ex.getMessage());
        }

        try{
            fsc.viajar();
        }catch(CannotRideException ex){
            System.err.println(ex.getMessage());
        }

        try{
            fsc.viajar();
        }catch(CannotRideException ex){
            System.err.println(ex.getMessage());
        } // Imprime un mensaje de error

        TarjetaRecargable rsc = new TarjetaRecargable(sc);
        rsc.Recargar(50);
        try{
            rsc.viajar();
        }catch(CannotRideException ex){
            System.err.println(ex.getMessage());
        }

        sc.CambiarPrecio(30);
        try{
            rsc.viajar();
        }catch(CannotRideException ex){
            System.err.println(ex.getMessage());
        } // Imprime un mensaje de error

        RecargableDescuento drsc = new RecargableDescuento(sc, 0.50);
        drsc.Recargar(30);
        try{
            drsc.viajar();
        }catch(CannotRideException ex){
            System.err.println(ex.getMessage());
        }

        try{
            drsc.viajar();
        }catch(CannotRideException ex){
            System.err.println(ex.getMessage());
        }

        try{
            drsc.viajar();
        }catch(CannotRideException ex){
            System.err.println(ex.getMessage());
        } // Imprime un mensaje de error
    }
}
