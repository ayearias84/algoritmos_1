import java.util.List;

public class Imprimir {
    public void imprimirTabla(List<List<String>> tabla) {
        for (List<String> fila : tabla) {
            for (String elemento : fila) {
                System.out.print(elemento + "\t"); // \t para separar columnas
            }
            System.out.println(); // Nueva línea para cada fila
        }
    }

}


