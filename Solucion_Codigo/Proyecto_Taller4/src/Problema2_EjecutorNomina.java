
public class Problema2_EjecutorNomina {
    public static void main(String[] args) {
        Nomina nomina1 = new Nomina("Juan Pérez", 1500, 35);
        Nomina nomina2 = new Nomina("María García", 2000, 28);
        Nomina nomina3 = new Nomina("Carlos López", 800, 42);
        System.out.println("=== INFORMACIÓN INICIAL DE EMPLEADOS ===");
        System.out.println(nomina1);
        System.out.println(nomina2);
        System.out.println(nomina3);
        double promedio = (nomina1.salario + nomina2.salario + nomina3.salario) / 3;
        System.out.printf("\nSalario promedio: $%,.2f\n", promedio);
        
        System.out.println("\n=== APLICANDO AUMENTOS ===");
        nomina1.calcularAumento(promedio, 10);
        nomina2.calcularAumento(promedio, 10);
        nomina3.calcularAumento(promedio, 10);
        System.out.println("\n=== INFORMACIÓN FINAL DE EMPLEADOS ===");
        System.out.println(nomina1);
        System.out.println(nomina2);
        System.out.println(nomina3);
    }
}

class Nomina {

    public String nombre;
    public double salario;
    public int edad;
    public double aumento;
    public double nuevoSalario;
    
    public Nomina() {
    }

    public Nomina(String nombre, double salario, int edad) {
        this.nombre = nombre;
        this.salario = salario;
        this.edad = edad;
        
    }

    public double calcularAumento(double promedioSalarial, double porcentajeAumento) {
        if(this.salario < promedioSalarial) {
            this.aumento = this.salario * (porcentajeAumento / 100);
            this.nuevoSalario = this.salario + this.aumento;
        } else {
            this.aumento = 0;
            this.nuevoSalario = this.salario;
        }
        return this.aumento;
    }
    
    public String toString() {
        if(aumento > 0) {
            return String.format("Nomina: %s | Salario original: $%,.2f | Aumento: $%,.2f (%.0f%%) | Nuevo salario: $%,.2f | Edad: %d",
                               nombre, salario, aumento, (aumento/salario*100), nuevoSalario, edad);
        } else {
            return String.format("Nomina: %s | Salario: $%,.2f (sin aumento) | Edad: %d",
                               nombre, salario, edad);
        }
    }
}
