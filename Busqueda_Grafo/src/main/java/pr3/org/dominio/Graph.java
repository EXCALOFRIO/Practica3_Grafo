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

public class Graph<V>{
   
    private Map<V, Set<V>> adjacenyList = new HashMap();
    
    public boolean addVertex(V v){

        if (adjacenyList.keySet().contains(v)) {
            System.out.println("No se puede meter el vertice "+"{"+ v +"}"+ " porque ya esta en el grafo.");
            return false;
        }
        else{
            adjacenyList.put(v, new HashSet()); 
            System.out.println(toString());
            return true;
        }
    }

    public boolean addEdge(V v1, V v2){
        Set<V> verticesConectados = adjacenyList.get(v1);
        verticesConectados.add(v2);

        verticesConectados = adjacenyList.get(v2);
        verticesConectados.add(v1);
        return true;
    }

    public Set<V> obtainAdjacents(V v) throws Exception{
        System.out.println("Vertice adyacentes" + " del vertice " + v + " " + adjacenyList.get(v));
        addArchivo("Vertice adyacentes" + adjacenyList.get(v));
        return null;
    }

    public void addArchivo(String verticesAdycentes){
        //AÑADIR VERTICE

        try {
			String NOMBRE_FICHERO = "Grafo.txt";

			FileWriter fw=new FileWriter(NOMBRE_FICHERO);
			BufferedWriter bw = new BufferedWriter(fw);

            bw.write(verticesAdycentes);
            bw.newLine();
            bw.close();


		} catch (IOException e) {
			System.out.println("NO SE HA PODIDO GENERAR EL GRAFO");
			e.printStackTrace();
        }
	
    }

    public String toString(){
       String datos = "";
       for(V v : this.adjacenyList.keySet()){
        datos = ("Vertice " + "{" + v + "}"  + " metido en el grafo");
       }
       return datos;
    }

    public List<V> onePath(V v1, V v2) {
        return null;
    }
    
        

				
	
}
