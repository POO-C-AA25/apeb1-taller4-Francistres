public class Problema5_Ejecutor {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Juan Perez", "Cardio", 45, true);
        Cliente cliente2 = new Cliente("Ana Gomez", "Fuerza", 30, false);

        Gimnasio gimnasio = new Gimnasio(cliente1, cliente2);
        gimnasio.mostrarResumen();
    }
}

class Cliente {
    public String nombre;
    public String tipoEjercicio;
    public int duracion;
    public boolean cumplioRutina;

    public Cliente(String nombre, String tipoEjercicio, int duracion, boolean cumplioRutina) {
        this.nombre = nombre;
        this.tipoEjercicio = tipoEjercicio;
        this.duracion = duracion;
        this.cumplioRutina = cumplioRutina;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipoEjercicio() {
        return tipoEjercicio;
    }

    public int getDuracion() {
        return duracion;
    }

    public boolean isCumplioRutina() {
        return cumplioRutina;
    }

    public String toString() {
        return "Cliente: " + nombre + ", Ejercicio: " + tipoEjercicio + ", Duración: " + duracion + " min, Completó: " + cumplioRutina;
    }
}

class Gimnasio {
    public Cliente cliente1;
    public Cliente cliente2;

    public Gimnasio(Cliente cliente1, Cliente cliente2) {
        this.cliente1 = cliente1;
        this.cliente2 = cliente2;
    }

    public double calcularPromedioTiempo() {
        return (cliente1.getDuracion() + cliente2.getDuracion()) / 2.0;
    }

    public int contarCumplieronRutina() {
        int contador = 0;
        if (cliente1.isCumplioRutina()) contador++;
        if (cliente2.isCumplioRutina()) contador++;
        return contador;
    }

    public void mostrarResumen() {
        System.out.println("Resumen del Gimnasio:");
        System.out.println(cliente1);
        System.out.println(cliente2);
        System.out.println("Clientes que completaron la rutina: " + contarCumplieronRutina());
        System.out.println("Promedio de tiempo invertido: " + calcularPromedioTiempo() + " min");
    }
}