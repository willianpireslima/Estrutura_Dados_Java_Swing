package pacotegrafo;
import java.util.*;
public class Grafo {
   class Graph<T> {
 
    // Usamos Hashmap para armazenar as arestas no gráfico
    private Map<T, List<T> > map = new HashMap<>();
 
    // Esta função adiciona um novo vértice ao gráfico
    public void addVertex(T s)
    {
        map.put(s, new LinkedList<T>());
    }
 
    //Esta função adiciona a borda
     //entre a origem e o destino
    public void addEdge(T source,
                        T destination,
                        boolean bidirectional)
    {
 
        if (!map.containsKey(source))
            addVertex(source);
 
        if (!map.containsKey(destination))
            addVertex(destination);
 
        map.get(source).add(destination);
        if (bidirectional == true) {
            map.get(destination).add(source);
        }
    }
 
    //Esta função fornece a contagem de vértices
    public String getVertexCount(){
        String buff = "";
        
    return buff = "O grafo tem "
            + map.keySet().size()
            + " vertice";
    }
 
    // Esta função fornece a contagem de arestas
    public String getEdgesCount(boolean bidirection)
    {
        String buff = "";
        int count = 0;
        for (T v : map.keySet()) {
            count += map.get(v).size();
        }
        if (bidirection == true) {
            count = count / 2;
        }
    return buff = "O grafo tem "+ count + " arestas.";
    }
 
    // Esta funcao fornece se
     // um vertice está presente ou nao.
    public String hasVertex(T s)
    {
        String buff ="";
        if (map.containsKey(s)) {
            return buff ="O grafo tem contem "
                               + s + " como um vertice.";
        }
        else {
            return buff ="O grafo nao tem contem "
                               + s + " como um vertice.";
        }
  
    }
 
    // Esta funcao informa se uma aresta esta presente ou nao.
    public String hasEdge(T s, T d)
    {
        String buff ="";
        if (map.get(s).contains(d)) {
            return buff ="O grafo tem uma aresta entre "
                               + s + " e " + d + ".";
        }
        else {
            return buff ="O grafo nao tem uma aresta entre "
                               + s + " e " + d + ".";
        }
    }
 
    // Imprime a lista de adjacencias de cada vertice.
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
 
        for (T v : map.keySet()) {
            builder.append(v.toString() + ": ");
            for (T w : map.get(v)) {
                builder.append(w.toString() + " ");
            }
            builder.append("\n");
        }
 
        return (builder.toString());
    }
} 
}
