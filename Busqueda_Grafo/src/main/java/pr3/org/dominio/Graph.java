package pr3.org.dominio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class Graph<V> {

    private Map<V, Set<V>> adjacenyList = new HashMap();

    Stack st = new Stack();
    ArrayList<V> path = new ArrayList<V>();

    public boolean addVertex(V v) {

        if (adjacenyList.keySet().contains(v)) {
            System.out.println("No se puede meter el vertice " + "{" + v + "}" + " porque ya esta en el grafo.");
            return false;
        } else {
            adjacenyList.put(v, new HashSet());
            return true;
        }
    }

    public boolean addEdge(V v1, V v2) {

        Set<V> verticesConectados = adjacenyList.get(v1);
        if (verticesConectados.contains(v2)) {
            System.out.println("La arista " + v1 + "-----" + v2 + " no se puede meter en el grafo porque ya existe.");
            return false;

        } else
            verticesConectados.add(v2);

        verticesConectados = adjacenyList.get(v2);
        verticesConectados.add(v1);
        return true;

    }

    public Set<V> obtainAdjacents(V v) throws Exception {
        // System.out.println("Vertice adyacentes" + " del vertice " + v + " " +
        // adjacenyList.get(v));

        if (adjacenyList.get(v) == null) {
            throw new Exception("No existe el vértice");
        } else {
            addArchivo("Vertice adyacentes" + adjacenyList.get(v));
            return adjacenyList.get(v);
        }
        // System.out.println(toString());

    }

    public void addArchivo(String verticesAdycentes) {
        // AÑADIR VERTICE

        try {
            String NOMBRE_FICHERO = "Grafo.txt";

            FileWriter fw = new FileWriter(NOMBRE_FICHERO);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(verticesAdycentes);
            bw.newLine();
            bw.close();

        } catch (IOException e) {
            System.out.println("NO SE HA PODIDO GENERAR EL GRAFO");
            e.printStackTrace();
        }

    }

    public String toString() {
        String datos = "";
        for (V vertice : this.adjacenyList.keySet()) {
            datos += (vertice.toString() + adjacenyList.get(vertice).toString() + "\n");
        }
        // System.out.println(datos);
        return datos;
    }

    public List<V> onePath(V v1, V v2) throws Exception {
        path.add(v1);

        st.push(adjacenyList.get(v1));
        while(st!=null){
            if (String.valueOf(st.peek()).equals(v2)) {
                
                path.add((V) st.peek());
                System.out.print("PATH"+path);
            }else{
                adjacenyList.get(st.peek());
            }
        }
        System.out.print("PATHH de "+v1+" a "+ v2 +" "+path);

        return null;
    }

}
