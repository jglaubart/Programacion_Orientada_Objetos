package talleres.taller3.ej1;

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
    public void viajar(){
        if(this.PuedeViajar()){
            this.viajes--;
            System.out.println("Viaje exitoso!");
        } else{
            System.out.println("Error, saldo insuficiente");
        }
    }
}
