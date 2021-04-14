package pr3.org.aplicacion;


import java.util.Scanner;

import pr3.org.dominio.Graph;

public class Principal {

 static String relacion = "Si tiene relacion con otro vertice escribe el nombre del vertice sino escribe NO";

    public static void main(String[] args){
        System.out.println("Introduce un vertice");
        Scanner sc = new Scanner(System.in);
        String vertice1 = sc.next();
        System.out.println("¿Tiene relación con algun otro vertice?");
        System.out.println(relacion);
        String vertice2 = sc.next();
        System.out.println("Introduce otro vertice");
        System.out.println(relacion);
        String vertice3 = sc.next();
        System.out.println("Introduce otro vertice");
        System.out.println(relacion);
        String vertice4 = sc.next();
        System.out.println("Introduce otro vertice");
        System.out.println(relacion);
        String vertice5 = sc.next();
        System.out.println("Introduce otro vertice");
        System.out.println(relacion);
        String vertice6 = sc.next();
        Graph.addVertexOld(vertice1, vertice2, vertice3, vertice4, vertice5, vertice6);
    }
}