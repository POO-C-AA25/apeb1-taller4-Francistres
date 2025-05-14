public class Problema1_EjecutorProducto {
    public static void main(String[] args) {
        Producto producto1 = new Producto(1000,10);
        producto1.calcularDescuento(producto1.precioP,producto1.cantP);
        producto1.calcularPrecioFinal();
        System.out.println(producto1);
        
    }
}
class Producto{
    public double precioP;
    public int cantP;
    public double descuento;
    public double precioF;
    public double montoD;

    public Producto() {
    }

    public Producto(double precioP, int cantP) {
        this.precioP = precioP;
        this.cantP = cantP;
    }
    public double calcularDescuento(double precioP, double cantP){
        if(this.precioP >= 1000 && this.cantP >= 10){
            this.descuento = this.precioP * 0.10;
        } else{
            this.descuento = this.precioP * 0.5;
        }
        this.montoD = this.descuento;
        return this.montoD;
    }
    public double calcularPrecioFinal(){
        this.precioF = this.precioP - this.montoD;
        return this.precioF;
    }
    public String toString(){
        return "El precio final a pagar es: " + this.calcularPrecioFinal();
    }
}
