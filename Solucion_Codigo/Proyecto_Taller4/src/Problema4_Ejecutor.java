public class Problema4_Ejecutor {
    public static void main(String[] args) {

        Parque parque = new Parque();

        Visitante visitante1 = new Visitante("Juan", 12, 1.45);
        Visitante visitante2 = new Visitante("Maria", 9, 1.35);
        Visitante visitante3 = new Visitante("Carlos", 7, 1.25);
        Visitante visitante4 = new Visitante("Ana", 10, 1.50);
        
        parque.registrarVisitante(visitante1);
        parque.registrarVisitante(visitante2);
        parque.registrarVisitante(visitante3);
        parque.registrarVisitante(visitante4);

        parque.verificarTodosVisitantes();

        parque.mostrarResumen();
    }
}

class Visitante {
    public String nombre;
    public int edad;
    public double altura;
    public boolean puedeJuego1;
    public boolean puedeJuego2;
    public boolean puedeJuego3;

    public Visitante() {
        this.nombre = "";
        this.edad = 0;
        this.altura = 0.0;
        this.puedeJuego1 = false;
        this.puedeJuego2 = false;
        this.puedeJuego3 = false;
    }

    public Visitante(String nombre, int edad, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.altura = altura;
        this.puedeJuego1 = false;
        this.puedeJuego2 = false;
        this.puedeJuego3 = false;
    }

    public void verificarJuego1(double minAltura, int minEdad) {
        this.puedeJuego1 = (this.altura >= minAltura) && (this.edad >= minEdad);
    }

    public void verificarJuego2(double minAltura, int minEdad) {
        this.puedeJuego2 = (this.altura >= minAltura) && (this.edad >= minEdad);
    }

    public void verificarJuego3(double minAltura, int minEdad) {
        this.puedeJuego3 = (this.altura >= minAltura) && (this.edad >= minEdad);
    }

    public boolean puedeTodo() {
        return this.puedeJuego1 && this.puedeJuego2 && this.puedeJuego3;
    }

    public String toString() {
        return String.format("%-15s | Edad: %2d | Altura: %.2fm | J1: %-3s | J2: %-3s | J3: %-3s | Todos: %-3s",
                           nombre, edad, altura,(puedeJuego1 ? "Si" : "No"),(puedeJuego2 ? "Si" : "No"),(puedeJuego3 ? "Sí" : "No"),
                           (puedeTodo() ? "Si" : "No"));
    }
}

class Parque {
    public double juego1MinAltura = 1.30;
    public int juego1MinEdad = 8;
    public double juego2MinAltura = 1.40;
    public int juego2MinEdad = 10;
    public double juego3MinAltura = 1.20;
    public int juego3MinEdad = 6;
    
    public Visitante[] visitantes = new Visitante[100];
    public int totalVisitantes = 0;
    public int aprobadosTotal = 0;

    public Parque() {
    }

    public void registrarVisitante(Visitante v) {
        if (totalVisitantes < visitantes.length) {
            visitantes[totalVisitantes++] = v;
        } else {
            System.out.println("No hay capacidad para mas visitantes");
        }
    }

    public void verificarTodosVisitantes() {
        aprobadosTotal = 0;
        for (int i = 0; i < totalVisitantes; i++) {
            Visitante v = visitantes[i];
            v.verificarJuego1(juego1MinAltura, juego1MinEdad);
            v.verificarJuego2(juego2MinAltura, juego2MinEdad);
            v.verificarJuego3(juego3MinAltura, juego3MinEdad);
            
            if (v.puedeTodo()) {
                aprobadosTotal++;
            }
        }
    }

    public void mostrarResumen() {
        System.out.println("\n REQUISITOS DE LOS JUEGOS");
        System.out.println("Juego 1: Altura ≥ " + juego1MinAltura + "m y Edad ≥ " + juego1MinEdad);
        System.out.println("Juego 2: Altura ≥ " + juego2MinAltura + "m y Edad ≥ " + juego2MinEdad);
        System.out.println("Juego 3: Altura ≥ " + juego3MinAltura + "m y Edad ≥ " + juego3MinEdad);
        
        System.out.println("\n LISTA DE VISITANTES");
        for (int i = 0; i < totalVisitantes; i++) {
            System.out.println(visitantes[i]);
        }
        
        System.out.println("\n RESUMEN FINAL ");
        System.out.println("Total visitantes: " + totalVisitantes);
        System.out.println("Aprobados para todos los juegos: " + aprobadosTotal);
        System.out.printf("Porcentaje de aprobados: %.1f%%\n", 
                         (totalVisitantes > 0 ? (double)aprobadosTotal/totalVisitantes*100 : 0));
    }

    public String toString() {
        return "Parque de Diversiones | Visitantes: " + totalVisitantes + 
               " | Aprobados: " + aprobadosTotal;
    }
}
