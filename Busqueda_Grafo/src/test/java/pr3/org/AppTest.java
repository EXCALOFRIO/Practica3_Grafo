package pr3.org;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import pr3.org.dominio.Graph;

/**
 * Unit test for simple App.
 */
public class AppTest 
{

    private void inicializarGrafo() {
        // añadir vertices
        // añadir aristas
    
    }
    /*
    @Before
    public void inicializar(){
        Graph<Integer> g = new Graph();
        g.addVertex(3);
        g.addVertex(9);
        g.addVertex(4);

        Graph<String> gs = new Graph();
        gs.addVertex("a");
        gs.addVertex("b");
    }
    */
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void annadirVertice(){
        System.out.println("\n\n------TEST------");
        System.out.println("-------1-------");
        Graph<Integer> g = new Graph();
        assertTrue(g.addVertex(3));
        assertFalse(g.addVertex(3));
        g.toString();

        Graph<String> gs = new Graph();
        assertTrue(gs.addVertex("a"));
        String miTexto = "Vertice [a] metido en el grafo";
        gs.toString();

        System.out.println("Prueba to String");
        assertEquals(miTexto, gs.toString());
        
        
    }

    @Test
    public void annadirEdge(){
        System.out.println("\n\n------TEST------");
        System.out.println("-------2-------");
        Graph<Integer> g = new Graph();
        g.addVertex(3);
        g.addVertex(9);
        g.addVertex(4);
        assertTrue(g.addEdge(3,9));
        assertTrue(g.addEdge(3,4));
        g.toString();

        Graph<String> gs = new Graph();
        gs.addVertex("a");
        gs.addVertex("b");
        assertTrue(gs.addEdge("a","b"));
       
        gs.toString();
    }

    @Test
    public void obtainAdjacents() throws Exception{
        System.out.println("\n\n------TEST------");
        System.out.println("-------3-------");
        Graph<Integer> g = new Graph();
        g.addVertex(3);
        g.addVertex(9);
        g.addVertex(4);
        g.addVertex(7);
        assertTrue(g.addEdge(3,9));
        assertTrue(g.addEdge(4,7));
        g.obtainAdjacents(3);
        g.obtainAdjacents(9);
        g.obtainAdjacents(4);
        g.obtainAdjacents(7);
        g.toString();

        Graph<String> gs = new Graph();
        gs.addVertex("a");
        gs.addVertex("b");
        gs.addVertex("c");
        gs.addVertex("j");
        assertTrue(gs.addEdge("a","b"));
        assertTrue(gs.addEdge("a","c"));
        assertTrue(gs.addEdge("j","c"));
        assertTrue(gs.addEdge("c","b"));
        assertTrue(gs.addEdge("c","c"));
        gs.obtainAdjacents("a");
        gs.obtainAdjacents("j");
        gs.obtainAdjacents("c");
       
        gs.toString();
    }

    /*
    @Test
    public void onePathFindsAPath(){
    System.out.println("\nTest onePathFindsAPath");
    System.out.println("----------------------");
    // Se construye el grafo.
    Graph<Integer> g = new Graph<>();
    g.addEdge(1, 2);
    g.addEdge(3, 4);
    g.addEdge(1, 5);
    g.addEdge(5, 6);
    g.addEdge(6, 4);
    // Se construye el camino esperado.
    List<Integer> expectedPath = new ArrayList<>();
    expectedPath.add(1);
    expectedPath.add(5);
    expectedPath.add(6);
    expectedPath.add(4);
    //Se comprueba si el camino devuelto es igual al esperado.
    assertEquals(expectedPath, g.onePath(1, 4));
    }
    */
}
