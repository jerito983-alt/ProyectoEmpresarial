package interfase;

import modelos.Empleado;
import java.util.List;

public interface IOperaciones {
    void guardar(Empleado e);
    List<Empleado> listar();
    Empleado buscar(String id);
    boolean eliminar(String id);
    void generarReporteNomina();
}