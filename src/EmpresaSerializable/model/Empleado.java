package EmpresaSerializable.model;

import lombok.Data;

@Data
public class Empleado implements Persistible {

    private Integer id;

    private String name;

    private Double salary;

    private static int idAux;


    public Empleado(String name, Double salary){

        id = ++idAux;
        this.name = name;
        this.salary = salary;

    }

    public String getRegister(){
        return ""+id+" "+name+" "+salary+"\n";
    }
}
