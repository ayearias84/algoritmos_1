import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Abrir {
    protected String path;
    protected String delimitador;

    public Abrir(String p, String d) {
        path = p;
        delimitador = d;
    }

    public FilaColumna getTamañoCsv() throws IOException {
        FilaColumna tamañoCsv = new FilaColumna();
        try (BufferedReader lector = new BufferedReader(new FileReader(path))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                if (tamañoCsv.columna == 0) {
                    tamañoCsv.columna = linea.split(delimitador).length;
                }
                tamañoCsv.fila++;
            }
        }
        return tamañoCsv;
    }

    public String[][] leerCsv() throws IOException {
        FilaColumna tamañoCsv = getTamañoCsv();
        String[][] data = new String[tamañoCsv.fila][tamañoCsv.columna];
        try (BufferedReader lector = new BufferedReader(new FileReader(path))) {
            String linea;
            int fila = 0;
            while ((linea = lector.readLine()) != null) {
                data[fila++] = linea.split(delimitador);
            }
        }
        return data;
    }
}