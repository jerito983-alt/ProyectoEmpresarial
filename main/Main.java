package main;

import modelos.Empleado;
import modelos.EmpleadoPorHoras;
import modelos.EmpleadoTiempoCompleto;
import servicios.GestorEmpresa;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestorEmpresa gestor = new GestorEmpresa();

        // Carga inicial de datos para prueba
        gestor.guardar(new EmpleadoTiempoCompleto("EMP01", "Ana Martínez", "Sistemas", 3500.0, 6000.0));
        gestor.guardar(new EmpleadoPorHoras("EMP02", "Carlos Gómez", "Diseño", 120, 25.0));

        int opcion;

        do {  
            System.out.println("   SIMULADOR FRONTEND - GESTOR DE EMPRESA   ");
            System.out.println("1. Registrar Empleado Tiempo Completo");
            System.out.println("2. Registrar Empleado Por Horas");
            System.out.println("3. Listar todos los empleados");
            System.out.println("4. Generar reporte de nómina (Polimorfismo)");
            System.out.println("5. Buscar empleado por ID");
            System.out.println("6. Eliminar empleado");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                opcion = -1;
            }

            switch (opcion) {
                case 1:
                    System.out.print("ID: ");
                    String idTC = scanner.nextLine();
                    System.out.print("Nombre: ");
                    String nomTC = scanner.nextLine();
                    System.out.print("Departamento: ");
                    String depTC = scanner.nextLine();
                    System.out.print("Salario Base Mensual ($): ");
                    double salTC = Double.parseDouble(scanner.nextLine());
                    System.out.print("Bono Anual ($): ");
                    double bonoTC = Double.parseDouble(scanner.nextLine());

                    gestor.guardar(new EmpleadoTiempoCompleto(idTC, nomTC, depTC, salTC, bonoTC));
                    System.out.println("✓ Empleado registrado correctamente.");
                    break;

                case 2:
                    System.out.print("ID: ");
                    String idPH = scanner.nextLine();
                    System.out.print("Nombre: ");
                    String nomPH = scanner.nextLine();
                    System.out.print("Departamento: ");
                    String depPH = scanner.nextLine();
                    System.out.print("Horas trabajadas: ");
                    int horasPH = Integer.parseInt(scanner.nextLine());
                    System.out.print("Tarifa por hora ($): ");
                    double tarifaPH = Double.parseDouble(scanner.nextLine());

                    gestor.guardar(new EmpleadoPorHoras(idPH, nomPH, depPH, horasPH, tarifaPH));
                    System.out.println("✓ Empleado registrado correctamente.");
                    break;

                case 3:
                    if (gestor.listar().isEmpty()) {
                        System.out.println("No hay empleados en el sistema.");
                    } else {
                        System.out.println("\n--- LISTA DE EMPLEADOS ---");
                        for (Empleado e : gestor.listar()) {
                            System.out.println(e);
                        }
                    }
                    break;

                case 4:
                    if (gestor.listar().isEmpty()) {
                        System.out.println("No hay empleados registrados para calcular la nómina.");
                    } else {
                        gestor.generarReporteNomina();
                    }
                    break;

                case 5:
                    System.out.print("Ingrese ID a buscar: ");
                    String idBuscar = scanner.nextLine();
                    Empleado encontrado = gestor.buscar(idBuscar);
                    if (encontrado != null) {
                        System.out.println("Empleado Encontrado:\n" + encontrado);
                    } else {
                        System.out.println("✕ No se encontró un empleado con ese ID.");
                    }
                    break;

                case 6:
                    System.out.print("Ingrese ID a eliminar: ");
                    String idEliminar = scanner.nextLine();
                    if (gestor.eliminar(idEliminar)) {
                        System.out.println("✓ Empleado eliminado correctamente.");
                    } else {
                        System.out.println("✕ No se encontró un empleado con ese ID.");
                    }
                    break;

                case 7:
                    System.out.println("Saliendo del simulador de empresa...");
                    break;

                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 7);

        scanner.close();
    }
}