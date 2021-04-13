package pr3.org.dominio;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph{
   
    
    public static void addVertex(String vertice1, String vertice2, String vertice3, String vertice4, String vertice5, String vertice6){
        //AÑADIR VERTICE
        HashMap<String, String> adjacenyList =new HashMap<String, String>();
        ArrayList<String> union = new ArrayList<String>();
        
        
        adjacenyList.put(vertice1, vertice2);
        adjacenyList.put(vertice3, vertice4);
        adjacenyList.put(vertice5, vertice6);

        for (String i : adjacenyList.keySet()) {
            System.out.println("Vertice " + i + " relacionado " + adjacenyList.get(i));
        }
        
        if (vertice1.equals(vertice3)){
            adjacenyList.put(vertice2, vertice4);
        }
        if (vertice1.equals(vertice5)){
            adjacenyList.put(vertice2, vertice6);
        }
        if (vertice1.equals(vertice4)){
            adjacenyList.put(vertice2, vertice3);
        }
        if (vertice1.equals(vertice6)){
            adjacenyList.put(vertice2, vertice5);
        }
        

        if (vertice2.equals(vertice3)){
            adjacenyList.put(vertice1, vertice4);
        }
        if (vertice2.equals(vertice5)){
            adjacenyList.put(vertice1, vertice6);
        }
        if (vertice2.equals(vertice4)){
            adjacenyList.put(vertice1, vertice3);
        }
        if (vertice2.equals(vertice6)){
            adjacenyList.put(vertice1, vertice5);
        }

        if (vertice3.equals(vertice5)){
            adjacenyList.put(vertice4, vertice6);
        }
        if (vertice3.equals(vertice6)){
            adjacenyList.put(vertice4, vertice5);
        }
        if (vertice2.equals(vertice4)){
            adjacenyList.put(vertice1, vertice3);
        }
        if (vertice2.equals(vertice6)){
            adjacenyList.put(vertice1, vertice5);
        }
        for (String i : adjacenyList.keySet()) {
            System.out.println("Vertice " + i + " relacionado " + adjacenyList.get(i));
        }


    

    }

}
