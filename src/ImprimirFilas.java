public class ImprimirFilas {
    public void imprimirTabla(List<List<String>> tabla, int cantidadFilas) {
        int contadorFilas = 0;
        for (List<String> fila : tabla) {
            for (String elemento : fila) {
                System.out.print(elemento + "\t"); // \t para separar columnas
            }
            System.out.println(); // Nueva línea para cada fila
            contadorFilas++;
            if (contadorFilas >= cantidadFilas) {
                break;
            }
        }
    }
}
