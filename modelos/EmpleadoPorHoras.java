package modelos;

public class EmpleadoPorHoras extends Empleado {
    private int horasTrabajadas;
    private double tarifaPorHora;

    public EmpleadoPorHoras(String id, String nombre, String departamento, int horasTrabajadas, double tarifaPorHora) {
        super(id, nombre, departamento);
        this.horasTrabajadas = horasTrabajadas;
        this.tarifaPorHora = tarifaPorHora;
    }

    @Override
    public double calcularSalario() {
        return horasTrabajadas * tarifaPorHora;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Tipo: Por Horas | Horas: %d | Salario Total: $%.2f", horasTrabajadas, calcularSalario());
    }
}