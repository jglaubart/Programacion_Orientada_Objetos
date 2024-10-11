package talleres.taller3.ej2;


public class RecargableDescuento extends TarjetaRecargable {
    private final double descuento;

    public RecargableDescuento(Central central, double descuento) {
        super(central);
        this.descuento = descuento;
    }

    @Override
    public double ConsultarPrecio(){
        return super.ConsultarPrecio() * (this.descuento);
    }
}

//Solo consulto el precio, despues para viajar se usa el metodo de TarjetaRecargable
// y vuelve a consultar el metodo en esta clase entonces en cada caso resta otra cosa