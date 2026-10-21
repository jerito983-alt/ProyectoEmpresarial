package modelos;

public class EmpleadoTiempoCompleto extends Empleado {
    private double salarioBase;
    private double bonoAnual;

    public EmpleadoTiempoCompleto(String id, String nombre, String departamento, double salarioBase, double bonoAnual) {
        super(id, nombre, departamento);
        this.salarioBase = salarioBase;
        this.bonoAnual = bonoAnual;
    }

    @Override
    public double calcularSalario() {
        return salarioBase + (bonoAnual / 12.0);
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Tipo: Tiempo Completo | Salario Mensual Estimado: $%.2f", calcularSalario());
    }
}