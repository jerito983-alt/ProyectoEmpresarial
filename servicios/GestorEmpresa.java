package servicios;

import interfase.IOperaciones;
import modelos.Empleado;
import java.util.ArrayList;
import java.util.List;

public class GestorEmpresa implements IOperaciones {
    private List<Empleado> empleados;

    public GestorEmpresa() {
        this.empleados = new ArrayList<>();
    }

    @Override
    public void guardar(Empleado e) {
        empleados.add(e);
    }

    @Override
    public List<Empleado> listar() {
        return empleados;
    }

    @Override
    public Empleado buscar(String id) {
        for (Empleado e : empleados) {
            if (e.getId().equalsIgnoreCase(id)) {
                return e;
            }
        }
        return null;
    }

    @Override
    public boolean eliminar(String id) {
        Empleado e = buscar(id);
        if (e != null) {
            return empleados.remove(e);
        }
        return false;
    }

    @Override
    public void generarReporteNomina() {
        System.out.println("\n--- REPORTE DE NÓMINA (POLIMORFISMO) ---");
        double totalNomina = 0;
        for (Empleado e : empleados) {
            double salario = e.calcularSalario();
            System.out.println(e.getNombre() + " (" + e.getId() + "): $" + String.format("%.2f", salario));
            totalNomina += salario;
        }
        System.out.println("Total Nómina Empresa: $" + String.format("%.2f", totalNomina));
    }
}