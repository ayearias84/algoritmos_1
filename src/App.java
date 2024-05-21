import java.io.IOException;
import java.util.List;

public class App {
    public static void main(String[] args) {
        String rutaArchivo1 = "C:/Users/Olivia/Documents/algoritmos 1/tp final/productos.csv";
        String rutaArchivo2 = "C:/Users/Olivia/Documents/algoritmos 1/tp final/ventas.csv";
        String delimitador = ";";
        String id_key = "id_producto";

        // Abrir lector = new Abrir(rutaArchivo, delimitador);

        // try {
        //     String[][] datos = lector.leerCsv();
        //     Imprimir impresor = new Imprimir();
        //     impresor.imprimirTabla(datos);
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }

        try {
            AbrirCubo lector1 = new AbrirCubo(rutaArchivo1, delimitador);
            AbrirCubo lector2 = new AbrirCubo(rutaArchivo2, delimitador); 
            List<List<String>> datos1 = lector1.leerCsv();
            List<List<String>> datos2 = lector2.leerCsv();
            // Fusionar las dos tablas
            List<List<String>> tablaFusionada = Merge.fusionarTablas(datos1, datos2,id_key);
            Imprimir impresor = new Imprimir();
            impresor.imprimirTabla(tablaFusionada);
        }   catch (IOException e)  {
            e.printStackTrace();
        }
    }
    

}