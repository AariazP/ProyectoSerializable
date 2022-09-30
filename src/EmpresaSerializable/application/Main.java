package EmpresaSerializable.application;

import EmpresaSerializable.model.Empresa;

public class Main {
    public static void main(String[] args) {

        Empresa empresa = Empresa.getInstance();
        System.out.println(empresa);

    }
}