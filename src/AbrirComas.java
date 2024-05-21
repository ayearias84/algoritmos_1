import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AbrirComas {
    protected String path;
    protected String delimitador;

    public AbrirComas(String p, String d) {
        path = p;
        delimitador = d;
    }

    public List<List<String>> leerCsv() throws IOException {
        List<List<String>> data = new ArrayList<>();
        try (BufferedReader lector = new BufferedReader(new FileReader(path))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                data.add(parsearLineaCsv(linea));
            }
        }
        return data;
    }

    private List<String> parsearLineaCsv(String linea) {
        List<String> valores = new ArrayList<>();
        StringBuilder valorActual = new StringBuilder();
        boolean dentroDeComillas = false;

        for (int i = 0; i < linea.length(); i++) {
            char c = linea.charAt(i);
            if (c == '\"') {
                dentroDeComillas = !dentroDeComillas;
            } else if (c == ',' && !dentroDeComillas) {
                valores.add(valorActual.toString());
                valorActual.setLength(0); // Limpiar el StringBuilder
            } else {
                valorActual.append(c);
            }
        }

        // Añadir el último valor
        valores.add(valorActual.toString());

        return valores;
    }
}
