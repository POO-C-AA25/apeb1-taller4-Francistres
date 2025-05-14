public class Problema3_EjecutorBuses {
    public static void main(String[] args) {
        
        Buses estudiante1 = new Buses("Ana Lopez", "5to grado", true, "Ruta Norte");
        Buses estudiante2 = new Buses("Carlos Ruiz", "3er grado", false, "Ruta Norte");
        Buses estudiante3 = new Buses("Maria Garcia", "4to grado", true, "Ruta Sur");
        Buses estudiante4 = new Buses("Juan Perez", "6to grado", true, "Ruta Norte");
        
        
        System.out.println("INFORMACION DE ESTUDIANTES");
        System.out.println(estudiante1);
        System.out.println(estudiante2);
        System.out.println(estudiante3);
        System.out.println(estudiante4);
        
        
        String rutaAutobus = "Ruta Norte";
        System.out.println("\nVERIFICACION PARA RUTA: " + rutaAutobus + " ");
        
        System.out.println("\nResultados:");
        System.out.println(estudiante1.nombre + ": " + (estudiante1.puedeSubir(rutaAutobus) ? "ACEPTADO" : "RECHAZADO"));
        System.out.println(estudiante2.nombre + ": " + (estudiante2.puedeSubir(rutaAutobus) ? "ACEPTADO" : "RECHAZADO"));
        System.out.println(estudiante3.nombre + ": " + (estudiante3.puedeSubir(rutaAutobus) ? "ACEPTADO" : "RECHAZADO"));
        System.out.println(estudiante4.nombre + ": " + (estudiante4.puedeSubir(rutaAutobus) ? "ACEPTADO" : "RECHAZADO"));
        
        
        int aceptados = 0;
        int rechazados = 0;
        
        if(estudiante1.puedeSubir(rutaAutobus)) aceptados++; else rechazados++;
        if(estudiante2.puedeSubir(rutaAutobus)) aceptados++; else rechazados++;
        if(estudiante3.puedeSubir(rutaAutobus)) aceptados++; else rechazados++;
        if(estudiante4.puedeSubir(rutaAutobus)) aceptados++; else rechazados++;
        
        System.out.println("\nRESUMEN FINAL");
        System.out.println("Total estudiantes: 4");
        System.out.println("Aceptados: " + aceptados);
        System.out.println("Rechazados: " + rechazados);
        System.out.printf("Porcentaje aceptados: %.1f%%\n", (aceptados/4.0)*100);
    }
}

class Buses {
    public String nombre;
    public String grado;
    public boolean permisoVigente;
    public String ruta;

    public Buses() {
    }

    public Buses(String nombre, String grado, boolean permisoVigente, String ruta) {
        this.nombre = nombre;
        this.grado = grado;
        this.permisoVigente = permisoVigente;
        this.ruta = ruta;
    }
    
    public boolean puedeSubir(String rutaAutobus) {
        return this.permisoVigente && this.ruta.equals(rutaAutobus);
    }
    
    public String toString() {
        return String.format("Estudiante: %-15s | Grado: %-9s | Permiso: %-5s | Ruta: %-10s",
                           nombre, grado, (permisoVigente ? "Si" : "No"), ruta);
    }
}