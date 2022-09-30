package EmpresaSerializable.serializable;

import lombok.Data;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

@Data
public class ArchivoUtil {

    private static ArrayList<File> listaArchivos = new ArrayList<>();
    private static String rutaBase = "/Users/alejandroarias/IdeaProjects/EmpresaSerializable/src/EmpresaSerializable/serializable";

    public static void escribir(StringBuilder texto, String archivo) throws IOException {

        if(existeArchivo(archivo)){
            serializar(texto, archivo);
        }else{

            File file = new File(rutaBase+"/"+archivo);
            listaArchivos.add(file);
            serializar(texto, archivo);
        }

    }

    private static void serializar(StringBuilder texto, String archivo) {
        
        File file = obtenerFile(rutaBase+"/"+archivo);

        if( file != null){
            try {
                FileWriter fileWriter = new FileWriter((rutaBase+"/"+archivo), true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write(texto.toString());
                bufferedWriter.close();
                fileWriter.close();
            }catch (Exception e ){
                System.out.println(" Algo salió mal");
            }

        }
    }

    private static File obtenerFile(String path) {

        for (File listaArchivo : listaArchivos) {
            if (listaArchivo.getPath().equals(path)) return listaArchivo;
        }
        return null;

    }

    /**
     * METODO QUE VERIFICA SI EXISTE UN ARCHIVO DADO SU NOMBRE
     * @param path EL NOMBRE DEL ARCHIVO QUE SE DESEA BUSCAR
     * @return TRUE || FALSE
     */
    private static boolean existeArchivo(String path) {

        for (File listaArchivo : listaArchivos) {
            if (listaArchivo.getPath().equals(path)) return true;
        }
        return false;
    }
}
