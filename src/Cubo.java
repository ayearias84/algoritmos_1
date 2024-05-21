import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;

public class Cubo {
    protected String path;
    protected String delimitador;

    public Cubo(String p, String d) {
        path = p;
        delimitador = d;
    }

    public FilaColumna getTamañoCsv() throws IOException {
        FilaColumna tamañoCsv = new FilaColumna();
        BufferedReader lector = new BufferedReader(new FileReader(path));
        String linea;
        while((linea = lector.readLine()) != null) {
            if (tamañoCsv.columna == 0) {
                tamañoCsv.columna = linea.split(delimitador).length;
            }
            tamañoCsv.fila++;

        }
        lector.close();
        return tamañoCsv;
    }

    public  String[][] leerCsv() throws IOException {
        FilaColumna tamañoCsv = getTamañoCsv();
        String[][] data = new String[tamañoCsv.fila][tamañoCsv.columna];
        BufferedReader lector = new BufferedReader(new FileReader(new File (path, delimitador)));
        for (int i = 0; i < tamañoCsv.fila; i++) {
            data[i] = lector.readLine().split(delimitador);
            }        

        lector.close();
        return data;
    }
    
}