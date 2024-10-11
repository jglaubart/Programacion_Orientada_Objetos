package talleres.taller3.ej1;

public class Central {
    private double precio;

    public Central(int precio){
        this.precio = precio;
    }
    public void CambiarPrecio(int n){
        this.precio = n;
    }
    public double ConsultarPrecio(){
        return this.precio;
    }
}
