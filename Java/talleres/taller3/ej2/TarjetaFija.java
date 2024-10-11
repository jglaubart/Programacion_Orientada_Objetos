package talleres.taller3.ej2;


public class TarjetaFija extends TarjetaSube {
    private int viajes;

    public TarjetaFija(Central central, int viajes) {
        super(central);
        this.viajes = viajes;
    }

    int ConsultarViajes(){
        return this.viajes;
    }

    @Override
    protected boolean PuedeViajar(){
        return this.viajes >= 1;
    }

    @Override
    public void viajar() throws CannotRideException{
        if(this.PuedeViajar()){
            this.viajes--;
            System.out.println("Viaje exitoso!");
        } else{
            throw new CannotRideException();
        }
    }
}
