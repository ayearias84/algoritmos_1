import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dimension {

    private String nombre;
    private int indiceFKEnHechos;
    private Map<String, List<Integer>> valoresIndice;
    private Map<Integer, String> pksToValor;
    
    public Dimension(String n, int colFk) {
        nombre = n;
        indiceFKEnHechos = colFk;
        valoresIndice = new HashMap<>();
    }

    public void agregarValor(int pk, String valor) {
        pksToValor.put(pk, valor);
        valoresIndice.put(valor, new ArrayList<>());
    }

    public void agregarIndice(int pk, Integer indice) {
        valoresIndice.get(pksToValor.get(pk)).add(indice);
    }

    public int obenterColumnaHechos() {
        return indiceFKEnHechos;
    }

}
