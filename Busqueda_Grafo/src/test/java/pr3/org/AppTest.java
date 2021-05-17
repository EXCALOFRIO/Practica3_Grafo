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
public class AppTest {

    private void inicializarGrafo() {
        // añadir vertices
        // añadir aristas

    }

    /*
     * @Before public void inicializar(){ Graph<Integer> g = new Graph();
     * g.addVertex(3); g.addVertex(9); g.addVertex(4);
     * 
     * Graph<String> gs = new Graph(); gs.addVertex("a"); gs.addVertex("b"); }
     */
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void annadirVertice() {
        System.out.println("\n\n------TEST------");
        System.out.println("-------1-------");
        Graph<Integer> g = new Graph();
        assertTrue(g.addVertex(3));
        assertFalse(g.addVertex(3));
        assertTrue(g.containsVertex(3));
        g.toString();

        Graph<String> gs = new Graph();
        assertTrue(gs.addVertex("a"));
        String miTexto = "a[]\n";
        gs.toString();

        System.out.println("Prueba to String");
        assertEquals(miTexto, gs.toString());

    }

    @Test
    public void annadirEdge() {
        System.out.println("\n\n------TEST------");
        System.out.println("-------2-------");
        Graph<Integer> g = new Graph();
        g.addVertex(3);
        g.addVertex(9);
        g.addVertex(4);
        assertTrue(g.addEdge(3, 9));
        assertTrue(g.addEdge(3, 4));
        g.toString();

        Graph<String> gs = new Graph();
        gs.addVertex("a");
        gs.addVertex("b");
        assertTrue(gs.addEdge("a", "b"));

        assertEquals("a[b]\nb[a]\n", gs.toString());
    }

    @Test(expected = Exception.class)
    public void obtainAdjacents() throws Exception {
        System.out.println("\n\n------TEST------");
        System.out.println("-------3-------");
        Graph<Integer> g = new Graph();
        g.addVertex(1);
        g.addVertex(2);
        g.addVertex(3);
        g.addVertex(4);
        g.addVertex(5);
        g.addVertex(6);
        g.addVertex(7);
        g.addVertex(8);
        assertTrue(g.addEdge(1, 2));
        assertTrue(g.addEdge(1, 3));
        assertTrue(g.addEdge(3, 4));
        assertTrue(g.addEdge(4, 5));
        assertTrue(g.addEdge(4, 6));
        assertTrue(g.addEdge(6, 7));
        assertTrue(g.addEdge(2, 8));
        g.obtainAdjacents(1);
        g.obtainAdjacents(2);
        g.obtainAdjacents(3);
        g.obtainAdjacents(4);
        
        g.toString();
        //g.onePath(1, 7);
        g.onePath(1, 5);

        Graph<String> gs = new Graph();
        gs.addVertex("a");
        gs.addVertex("b");
        gs.addVertex("c");
        gs.addVertex("j");
        assertTrue(gs.addEdge("a", "b"));
        assertFalse(gs.addEdge("a", "b"));
        assertTrue(gs.addEdge("a", "c"));
        assertTrue(gs.addEdge("j", "c"));
        assertTrue(gs.addEdge("c", "b"));
        assertTrue(gs.addEdge("c", "c"));
        gs.obtainAdjacents("a");
        gs.obtainAdjacents("j");
        gs.obtainAdjacents("c");
        gs.obtainAdjacents("op");

        System.out.println(gs.toString());
    }

    /*
     * @Test public void onePathFindsAPath(){
     * System.out.println("\nTest onePathFindsAPath");
     * System.out.println("----------------------"); // Se construye el grafo.
     * Graph<Integer> g = new Graph<>(); g.addEdge(1, 2); g.addEdge(3, 4);
     * g.addEdge(1, 5); g.addEdge(5, 6); g.addEdge(6, 4); // Se construye el camino
     * esperado. List<Integer> expectedPath = new ArrayList<>();
     * expectedPath.add(1); expectedPath.add(5); expectedPath.add(6);
     * expectedPath.add(4); //Se comprueba si el camino devuelto es igual al
     * esperado. assertEquals(expectedPath, g.onePath(1, 4)); }
     */
}
