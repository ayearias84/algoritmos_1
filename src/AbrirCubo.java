import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class AbrirCubo {
    protected String path;
    protected String delimitador;

    public AbrirCubo(String p, String d) {
        path = p;
        delimitador = d;
    }

    public List<List<String>> cargaDimensionFromCSV(String nombreDimension, int indiceFKEnHechos) throws IOException {
        List<List<String>> data = new ArrayList<>();
        try (BufferedReader lector = new BufferedReader(new FileReader(path))) {
            String linea;
            //int fila = 0;
            Dimension dim = new Dimension(nombreDimension, indiceFKEnHechos);
            while ((linea = lector.readLine()) != null) {
                data.add(Arrays.asList(linea.split(delimitador)));
                String[] datos = Arrays.asList(linea.split(delimitador));
                int pk = datos[0];
                dim.agregarValor(pk, datos[1]);     // datos[1] es el valor (el nivel que elegimos quedarnos)
                cubo.agregarDimension(dim);


                List<Integer> indicesHechos = new ArrayList<>();
                for (int i=0; i < filasHechos.length; i++) { // filasHechos es CSV hechos (recorrer csv hechos)
                    String[] filaHecho = filasHechos[i];
                    Celda celda = new Celda(filaHecho);
                    
                    para cada dimension
                        int fk = filaHecho[dim.obenterColumnaHechos()]
                        dim.agregarIndice(fk, i);

                    cubo.agregarCelda(celda);       // cada celda en el cubo tiene el indice i (nro fila en hechos)
                }



            }
        }
        return dim;
    }



}
