package EmpresaSerializable.serializable;

import EmpresaSerializable.model.Persistible;

import java.io.IOException;
import java.util.ArrayList;

public class Persistencia {


    public static void serializarArrayList(ArrayList<? extends Persistible> array, String archivo){

        StringBuilder texto = new StringBuilder();
        for (Persistible persistible : array) {

            texto.append(persistible.getRegister());
        }

        try {
            ArchivoUtil.escribir(texto, archivo);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }



}
