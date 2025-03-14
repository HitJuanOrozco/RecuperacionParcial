import java.util.Scanner;
import java.util.Stack;

class vehiculo {
    String placa;
    String propietario;
    int Cilindraje;
    String Modelo;
    
    public vehiculo(String placa, String propietario, int Cilindraje, String Modelo) {
        this.placa = placa;
        this.propietario = propietario;
        this.Cilindraje = Cilindraje;
        this.Modelo = Modelo;
    }

    public String mostrarInfo() {
        return "Placa: " + placa + ", Propieterio: " + propietario + ", Cilindraje: " + Cilindraje + ", Modelo: " + Modelo; 
    }
}

public class Parqueadero {
    private static final int CAPACIDAD = 16;
    private static Stack<vehiculo> pilaParqueadero = new Stack<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while(true) {
            System.out.println("\n*** Menú del Parqueadero ***");
            System.out.println("1: Ingresar vehiculo");
            System.out.println("2: Mostrar estado del parqueadero");
            System.out.println("3: Retirar ultimo vehiculo");
            System.out.println("4: Salir");
            System.out.print("Seleccióne una opción");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    ingresarVehiculo();
                    break;
                case 2:
                    mostrarEstado();
                    break;
                case 3:
                    retirarVehiculo();
                    break;
                case 4:
                    System.out.println("Saliendo del sistema...");
                    return;
                default:
                    System.out.println("Opción no valida, intente de nuevo");
            }
        }
    }

    private static void ingresarVehiculo(){
        if(pilaParqueadero.size() >= CAPACIDAD) {
            System.out.println("El parqueadero esta lleno.");
            return;
        }
        
        System.out.println("Ingrese placa del vehiculo: ");
        String placa = scanner.nextLine();
        System.out.println("Ingrese nombre del propietario: ");
        String propietario = scanner.nextLine();
        System.out.println("Ingrese cilindraje: ");
        int Cilindraje = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Ingrese modelo del vehiculo: ");
        String Modelo = scanner.nextLine();

        vehiculo nuevoVehiculo = new vehiculo(placa, propietario, Cilindraje, Modelo);
        pilaParqueadero.push(nuevoVehiculo);
        System.out.println("Vehiculo ingresado.");
    }

    private static void mostrarEstado() {
        System.out.println("\nEstado del parqueadero: ");
        if (pilaParqueadero.isEmpty()) {
            System.out.println("El parqueadero esta vacio.");
        } else {
            int posicion = pilaParqueadero.size();
            for (vehiculo v : pilaParqueadero) {
                System.out.println("Posición " + posicion + ": " + v.mostrarInfo());
                posicion--;
            }
        }
    }

    private static void retirarVehiculo() {
        if (pilaParqueadero.isEmpty()) {
            System.out.println("No hay vehiculos para reirar.");
            return;
            
        }

        vehiculo retirado = pilaParqueadero.pop();
        System.out.println("Vehiculo retirado: " + retirado.mostrarInfo());
    }
}