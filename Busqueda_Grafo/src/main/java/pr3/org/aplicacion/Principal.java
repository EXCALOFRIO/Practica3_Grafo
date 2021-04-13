package pr3.org.aplicacion;


import java.util.Scanner;

import pr3.org.dominio.Graph;

public class Principal {

 

    public static void main(String[] args){
        System.out.println("Introduce un vertice");
        Scanner sc = new Scanner(System.in);
        String vertice1 = sc.next();
        System.out.println("Introduce otro vertice");
        String vertice2 = sc.next();
        System.out.println("Introduce otro vertice");
        String vertice3 = sc.next();
        System.out.println("Introduce otro vertice");
        String vertice4 = sc.next();
        System.out.println("Introduce otro vertice");
        String vertice5 = sc.next();
        System.out.println("Introduce otro vertice");
        String vertice6 = sc.next();
        Graph.addVertex(vertice1, vertice2, vertice3, vertice4, vertice5, vertice6);
    }
}