package EmpresaSerializable.model;

import EmpresaSerializable.serializable.Persistencia;
import lombok.Data;

import java.util.ArrayList;

@Data
public class Empresa {

    private static Empresa empresa;

    private ArrayList<Empleado> listaEmpleados;
    private ArrayList<Producto> listaProductos;

    private Empresa(){

        listaEmpleados = new ArrayList<>();
        listaProductos = new ArrayList<>();

        listaEmpleados.add(new Empleado("Jose", 1000.0));
        listaEmpleados.add(new Empleado("Alejandro", 1000.0));

        listaProductos.add(new Producto("arroz", 100.0));
        while (true){
            Persistencia.serializarArrayList(listaEmpleados, "Empleados");
            Persistencia.serializarArrayList(listaProductos, "Productos");
        }


    }

    /**
     * SINGLETON PARA OBTENER SOLO UNA UNICA INSTANCIA DE EMPRESA
     * @return empresa
     */
    public static Empresa getInstance(){

        if (empresa != null ) return empresa;

        empresa = new Empresa();
        return empresa;

    }

}
