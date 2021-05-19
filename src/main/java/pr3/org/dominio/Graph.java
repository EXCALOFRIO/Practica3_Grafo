package pr3.org.dominio;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class Graph<V> {

    private Map<V, Set<V>> adjacenyList = new HashMap();

    /******************************************************************
     * Añade el vértice ‘v‘ al grafo.
     *
     * COMPLEJIDAD | |Espacial: O(1) | |Temporal: O(1) |
     * 
     * @param v vértice a añadir.
     * @return ‘true‘ si no estaba anteriormente y ‘false‘ en caso contrario.
     ******************************************************************/
    public boolean addVertex(V v) {

        if (adjacenyList.keySet().contains(v)) {
            System.out.println("No se puede meter el vertice " + "{" + v + "}" + " porque ya esta en el grafo.");
            return false;
        } else {
            adjacenyList.put(v, new HashSet());
            return true;
        }
    }

    /******************************************************************
     * Añade un arco entre los vértices ‘v1‘ y ‘v2‘ al grafo. En caso de que no
     * exista alguno de los vértices, lo añade también.
     *
     * COMPLEJIDAD | |Espacial: O(1) | |Temporal: O(1) |
     * 
     * @param v1 el origen del arco.
     * @param v2 el destino del arco.
     * @return ‘true‘ si no existía el arco y ‘false‘ en caso contrario.
     ******************************************************************/

    public boolean addEdge(V v1, V v2) {

        Set<V> verticesConectados = adjacenyList.get(v1);

        if (!containsVertex(v1) || verticesConectados.contains(v2)) {
            System.out.println("\nLa arista " + v1 + "-----" + v2
                    + " no se puede meter en el grafo porque ya existe, o porque no ha inicializado el vertice");
            return false;

        } else
            verticesConectados.add(v2);
        verticesConectados = adjacenyList.get(v2);
        if (!containsVertex(v1) || verticesConectados.contains(v1)) {
            System.out.println("\nLa arista " + v1 + "-----" + v2
                    + " no se puede meter en el grafo porque ya existe, o porque no ha inicializado el vertice");
            return false;
        } else

            verticesConectados.add(v1);
        return true;

    }

    /******************************************************************
     * Obtiene el conjunto de vértices adyacentes a ‘v‘.
     *
     * COMPLEJIDAD | |Espacial: O(1) | |Temporal: O(1) |
     * 
     * @param v vértice del que se obtienen los adyacentes.
     * @return conjunto de vértices adyacentes.
     * @throws Exception Lanza exception
     ******************************************************************/
    public Set<V> obtainAdjacents(V v) throws Exception {
        // System.out.println("Vertice adyacentes" + " del vertice " + v + " " +
        // adjacenyList.get(v));

        if (adjacenyList.get(v) == null) {
            throw new Exception("No existe el vértice");
        } else {
            addArchivo("Vertice adyacentes" + adjacenyList.get(v));
            return adjacenyList.get(v);
        }

    }

    public void addArchivo(String verticesAdycentes) {
        // AÑADIR VERTICE

        try {
            String NOMBRE_FICHERO = "Grafo.txt";

            FileWriter fw = new FileWriter(NOMBRE_FICHERO);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(" ");
            bw.newLine();
            bw.close();

        } catch (IOException e) {
            System.out.println("NO SE HA PODIDO GENERAR EL GRAFO");
            e.printStackTrace();
        }

    }

    /******************************************************************
     * Método ‘toString()‘ reescrito para la clase ‘Grafo.java‘.
     * 
     * COMPLEJIDAD | |Espacial: O(1) | |Temporal: O(n) |
     * 
     * @return una cadena de caracteres con la lista de adyacencia.
     ******************************************************************/
    public String toString() {
        String datos = "";
        for (V vertice : this.adjacenyList.keySet()) {
            datos += (vertice.toString() + adjacenyList.get(vertice).toString() + "\n");
        }
        System.out.println(datos);
        return datos;

    }

    /******************************************************************
     * Comprueba si el grafo contiene el vértice dado.
     *
     * COMPLEJIDAD | |Espacial: O(1) | |Temporal: O(1) |
     * 
     * @param v vértice para el que se realiza la comprobación.
     * @return ‘true‘ si ‘v‘ es un vértice del grafo.
     ******************************************************************/
    public boolean containsVertex(V v) {
        if (adjacenyList.keySet().contains(v)) {
            return true;
        }
        return false;
    }

    /******************************************************************
     * Obtiene, en caso de que exista, un camino entre ‘v1‘ y ‘v2‘. En caso
     * contrario, devuelve ‘null‘.
     *
     * COMPLEJIDAD | |Espacial: O(1) | |Temporal: O(n^2) |
     * 
     * @param v1 el vértice origen.
     * @param v2 el vértice destino.
     * @return lista con la secuencia de vértices desde ‘v1‘ hasta ‘v2‘ pasando por
     *         arcos del grafo.
     ******************************************************************/
    public List<V> onePath(V v1, V v2) throws Exception {
        Stack<V> st = new Stack<V>();

        ArrayList<V> path = new ArrayList<V>();
        Set<V> verticesVisitados = new HashSet<>();

        path.add(v1);
        for (V adyacente : adjacenyList.get(v1)) {
            st.add(adyacente);
        }
        boolean encontrado = false;

        while (!st.empty() && !encontrado) {
            V verticeVisitando = st.pop();

            verticesVisitados.add(verticeVisitando);
            path.add(verticeVisitando);
            if (verticeVisitando.equals(v2) || verticeVisitando == v2) {
                // System.out.println("SE VUELVE TRUE CON " + verticeVisitando);
                encontrado = true;

            } else {
                for (V adyacente : adjacenyList.get(verticeVisitando)) {
                    if (path.contains(adyacente)) {

                    } else {

                        st.add(adyacente);

                    }

                }
            }

        }
        // System.out.println(path);
        if (path.get(path.size() - 1).equals(v2)) {
            ArrayList<V> pathfinal = new ArrayList<V>();

            pathfinal.add(path.get(path.size() - 1));
            for (int i = 1; i < path.size(); i++) {

                if (adjacenyList.get(path.get(path.size() - i)).contains(path.get(path.size() - (i + 1)))) {
                    // System.out.println("PARA I "+ i + "===>"+path.get(path.size() - i) + " TIENE
                    // RELACION CON " + path.get(path.size() - (i + 1)));
                    pathfinal.add(path.get(path.size() - (i + 1)));
                } else {
                    if (path.get(i).equals(v1)) {

                    } else {
                        // System.out.println("el que quito " + path.get(path.size() - (i+1)));
                        path.remove(path.size() - (i + 1));
                        i--;
                        // System.out.println(path);
                    }

                }

            }
            Collections.reverse(pathfinal);
            // System.out.println("EL PATH FINAL " + pathfinal);

            return pathfinal;
        } else {
            return null;
        }
    }
}
