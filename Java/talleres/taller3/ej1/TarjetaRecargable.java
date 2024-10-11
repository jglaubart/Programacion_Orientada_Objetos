package talleres.taller3.ej1;

public class TarjetaRecargable extends TarjetaSube {
    private double saldo;

    public TarjetaRecargable(Central central){
        super(central);
        saldo = 0;
    }

    public void Recargar(int n){
        this.saldo += n;
    }

    public double ConsultarSaldo(){
        return this.saldo;
    }

    @Override
    public double ConsultarPrecio(){
        return super.ConsultarPrecio();
    }

    @Override
    protected boolean PuedeViajar(){
        return this.saldo >= this.ConsultarPrecio();
    }

    @Override
    public void viajar(){
        if(PuedeViajar()){
            this.saldo -= this.ConsultarPrecio();
            System.out.println("Viaje exitoso!");
        } else {
            System.out.println("Error, saldo insuficiente.");
        }
    }
}
