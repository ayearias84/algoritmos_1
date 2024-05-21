import java.util.ArrayList;
//import java.util.Arrays;
import java.util.List;

public class Merge {
    protected List<List<String>> tabla1;
    protected List<List<String>> tabla2;
    protected String key;

    //CONSTRUCTOR
    public Merge(List<List<String>> t1, List<List<String>> t2, String k) {
        tabla1 = t1;
        tabla2 = t2;
        key = k;
    }

    public static List<List<String>> fusionarTablas(List<List<String>> tabla1, List<List<String>> tabla2, String key) {
        // Verificar si las tablas son nulas o vacías
        if (tabla1 == null || tabla1.isEmpty()) {
            System.out.println("La tabla 1 es nula o vacía.");
            return null;
        }

        if (tabla2 == null || tabla2.isEmpty()) {
            System.out.println("La tabla 2 es nula o vacía.");
            return null;
        }

        // Crear una nueva lista para la tabla fusionada
        List<List<String>> tablaFusionada = new ArrayList<>();

        // Agregar encabezados de la tabla 1 a la tabla fusionada
       // tablaFusionada.add(new ArrayList<>(tabla1.get(0)));
       tablaFusionada.add((tabla1.get(0)));

        // Agregar encabezados de la tabla 2 a la tabla fusionada (excepto el key)
        for (int i = 1; i < tabla2.get(0).size(); i++) {
            if (!tabla2.get(0).get(i).equals(key)) {
                tablaFusionada.get(0).add(tabla2.get(0).get(i));
             } //else {
            //     int id2 = i;

            // }
        } //PREGUNTAR i = 1?

        // Iterar sobre los datos de la tabla 1 para fusionar con la tabla 2
        for (int i = 1; i < tabla1.size(); i++) {
            List<String> filaTabla1 = tabla1.get(i);
            String idTabla1 = filaTabla1.get(filaTabla1.indexOf("id_producto"));
            //Antes decía: String idTabla1 = filaTabla1.get("id_producto");
            
            // Buscar la fila correspondiente en la tabla 2
            List<String> filaFusionada = new ArrayList<>(filaTabla1);
            for (int j = 1; j < tabla2.size(); j++) {
                List<String> filaTabla2 = tabla2.get(j);
                String idTabla2 = filaTabla2.get(filaTabla1.indexOf("id_producto"));
             //Antes decía: String idTabla2 = filaTabla2.get("id_producto");

                if (idTabla1.equals(idTabla2)) {
                    // Fusionar las filas (excepto el key)
                    for (int h = 1; h < filaTabla2.size(); h++) {
                        if (!tabla2.get(0).get(h).equals(key)) {
                            filaFusionada.add(filaTabla2.get(h));
                        }
                    }
                    break;
                } 
            }
            tablaFusionada.add(filaFusionada);
        }

        return tablaFusionada;
    }
}