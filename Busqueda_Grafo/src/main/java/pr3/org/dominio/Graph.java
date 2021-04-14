package pr3.org.dominio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Graph<V>{
   
    private Map<V, Set<V>> adjacenyList = new HashMap();
    
    public boolean addVertex(V v){
        adjacenyList.put(v, new HashSet());
        //no se pueden poner dos vertices iguales
        for (V i : adjacenyList.keySet()) {
            System.out.println("Vertice " + i + " añadido." /*+ adjacenyList.get(i).toString()*/);
        }
        return true;
    }

    public boolean addEdge(V v1, V v2){
        Set<V> verticesConectados = adjacenyList.get(v1);
        verticesConectados.add(v2);

        verticesConectados = adjacenyList.get(v2);
        verticesConectados.add(v1);
        return true;
    }

    public Set<V> obtainAdjacents(V v) throws Exception{
        
        System.out.println("Vertice adyacentes" + adjacenyList.get(v));
        return null;
    }

    public static void addVertexOld(String vertice1, String vertice2, String vertice3, String vertice4, String vertice5, String vertice6){
        //AÑADIR VERTICE

        try {
			String NOMBRE_FICHERO = "Grafo.txt";
			
			FileWriter fw=new FileWriter(NOMBRE_FICHERO);
			BufferedWriter bw = new BufferedWriter(fw);
			HashMap<String, String> adjacenyList =new HashMap<String, String>();
        
        System.out.println("\n"+"Relacion entre vertices:"+"\n");
        adjacenyList.put(vertice1, vertice2);
        adjacenyList.put(vertice3, vertice4);
        adjacenyList.put(vertice5, vertice6);

        for (String i : adjacenyList.keySet()) {
            if(i.equalsIgnoreCase("NO")){
                
            }if(adjacenyList.get(i).equalsIgnoreCase("NO")){
                System.out.println("Vertice " + i + " no tiene relacion directa con nigun vertice");
                bw.write("Vertice " + i + " relacionado " + adjacenyList.get(i));
                bw.newLine();
            }else{
                System.out.println("Vertice " + i + " relacionado " + adjacenyList.get(i));
                bw.write("Vertice " + i + " relacionado " + adjacenyList.get(i));
                bw.newLine();
            }
            
        }
        
        HashMap<String, String> adjacenyListNew =new HashMap<String, String>();
        if (vertice1.equals(vertice3)){
            adjacenyListNew.put(vertice2, vertice4);
        }
        if (vertice1.equals(vertice5)){
            adjacenyListNew.put(vertice2, vertice6);
        }
        if (vertice1.equals(vertice4)){
            adjacenyListNew.put(vertice2, vertice3);
        }
        if (vertice1.equals(vertice6)){
            adjacenyListNew.put(vertice2, vertice5);
        }
        

        if (vertice2.equals(vertice3)){
            adjacenyListNew.put(vertice1, vertice4);
        }
        if (vertice2.equals(vertice5)){
            adjacenyListNew.put(vertice1, vertice6);
        }
        if (vertice2.equals(vertice4)){
            adjacenyListNew.put(vertice1, vertice3);
        }
        if (vertice2.equals(vertice6)){
            adjacenyListNew.put(vertice1, vertice5);
        }

        if (vertice3.equals(vertice5)){
            adjacenyListNew.put(vertice4, vertice6);
        }
        if (vertice3.equals(vertice6)){
            adjacenyListNew.put(vertice4, vertice5);
        }
        if (vertice2.equals(vertice4)){
            adjacenyListNew.put(vertice1, vertice3);
        }
        if (vertice2.equals(vertice6)){
            adjacenyListNew.put(vertice1, vertice5);
        }

        if (vertice4.equals(vertice6)){
            adjacenyListNew.put(vertice3, vertice5);
        }
        
        for (String i : adjacenyListNew.keySet()) {
            if(i.equalsIgnoreCase("NO")){
                
            }if(adjacenyListNew.get(i).equalsIgnoreCase("NO")){
                System.out.println("Vertice " + i + " no tiene relacion directa con nigun vertice");
                bw.write("Vertice " + i + " no tiene relacion directa con nigun vertice");
                bw.newLine();
            }else{
                System.out.println("Vertice " + i + " relacionado " + adjacenyListNew.get(i));
                bw.write("Vertice " + i + " relacionado " + adjacenyListNew.get(i));
                bw.newLine();
            }  
        }
					
					bw.flush();
			
			bw.close();
		} catch (IOException e) {
			System.out.println("NO SE HA PODIDO GENERAR EL GRAFO");
			e.printStackTrace();
        }
	
    }
        

				
	
}
