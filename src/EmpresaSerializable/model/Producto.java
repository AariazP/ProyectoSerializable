package EmpresaSerializable.model;

import lombok.Data;

@Data
public class Producto implements Persistible {

    private Integer id;

    private String name;

    private Double price;

    private static int idAux;


    public Producto(String name, Double price){

        id = ++idAux;
        this.name = name;
        this.price=price;

    }

    @Override
    public String getRegister(){
        return ""+id+" "+name+" "+price+"\n";
    }

}
