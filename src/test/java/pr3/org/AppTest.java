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

    }

    @Test
    public void annadirVertice() {
        System.out.println("\n\n------TEST------");
        System.out.println("-------1-------");
        Graph<Integer> g1 = new Graph();
        assertTrue(g1.addVertex(3));
        assertFalse(g1.addVertex(3));
        g1.toString();

        Graph<String> gs1 = new Graph();
        assertTrue(gs1.addVertex("a"));
        String miTexto = "a[]\n";
        gs1.toString();

        System.out.println("Prueba to String");
        assertEquals(miTexto, gs1.toString());

    }

    @Test
    public void annadirEdge() {
        System.out.println("\n\n------TEST------");
        System.out.println("-------2-------");

        Graph<String> gs2 = new Graph();
        gs2.addVertex("a");
        gs2.addVertex("b");
        assertTrue(gs2.addEdge("a", "b"));

        assertEquals("a[b]\nb[a]\n", gs2.toString());
    }

    @Test
    public void annadirEdge2() {
        System.out.println("\n\n------TEST------");
        System.out.println("-------2-------");
        Graph<Integer> g2 = new Graph();
        g2.addVertex(3);
        g2.addVertex(9);
        g2.addVertex(4);
        assertTrue(g2.addEdge(3, 9));
        assertTrue(g2.addEdge(3, 4));
        assertFalse(g2.addEdge(3, 9));
        assertFalse(g2.addEdge(4, 3));
        g2.toString();
        // Esperamos que de una excepcion por eso lo hemos puesto en el test
        g2.addEdge(69, 55);
    }

    @Test(expected = Exception.class)
    public void obtainAdjacents() throws Exception {
        System.out.println("\n\n------TEST------");
        System.out.println("-------3-------");
        Graph<Integer> g3 = new Graph();
        g3.addVertex(1);
        g3.addVertex(2);
        g3.addVertex(3);
        g3.addVertex(4);
        g3.addVertex(5);
        g3.addVertex(6);
        g3.addVertex(7);
        g3.addVertex(8);
        assertTrue(g3.addEdge(1, 2));
        assertTrue(g3.addEdge(1, 3));
        assertTrue(g3.addEdge(3, 4));
        assertTrue(g3.addEdge(4, 5));
        assertTrue(g3.addEdge(4, 6));
        // assertTrue(g3.addEdge(6, 8));
        assertTrue(g3.addEdge(2, 8));
        g3.obtainAdjacents(1);
        g3.obtainAdjacents(2);
        g3.obtainAdjacents(3);
        g3.obtainAdjacents(4);
        g3.toString();
        g3.onePath(1, 8);
        List<Integer> expectedPath = new ArrayList<>();
        expectedPath.add(1);
        expectedPath.add(2);
        expectedPath.add(8);
        assertEquals(expectedPath, g3.onePath(1, 8));
        g3.obtainAdjacents(69);

    }

    @Test(expected = Exception.class)
    public void obtainAdjacentsString() throws Exception {
        System.out.println("\n\n------TEST------");
        System.out.println("-------4-------");
        Graph<String> gs4 = new Graph();
        gs4.addVertex("a");
        gs4.addVertex("b");
        gs4.addVertex("c");
        gs4.addVertex("j");

        assertTrue(gs4.addEdge("a", "b"));
        assertFalse(gs4.addEdge("a", "b"));
        assertTrue(gs4.addEdge("a", "c"));
        assertFalse(gs4.addEdge("a", "c"));
        assertTrue(gs4.addEdge("j", "c"));
        assertTrue(gs4.addEdge("c", "b"));
        assertFalse(gs4.addEdge("c", "c"));

        gs4.obtainAdjacents("a");
        gs4.obtainAdjacents("j");

        gs4.obtainAdjacents("c");

        gs4.toString();
        gs4.onePath("a", "j");

        // Despues de este no se puede añadir nada por la excepcion q lanza
        gs4.obtainAdjacents("op");

    }

    /**
     * Este test comprueba que el método ‘onePath(V v1, V v2)‘ encuentra un camino
     * entre ‘v1‘ y ‘v2‘ cuando existe.
     * 
     * @throws Exception
     */
    @Test
    public void onePathFindsAPath() throws Exception {
        System.out.println("\nTest onePathFindsAPath");
        System.out.println("----------------------");
        System.out.println("-------5-------");
        // Se construye el grafo.
        Graph<Integer> g5 = new Graph<>();
        g5.addVertex(1);
        g5.addVertex(2);
        g5.addVertex(3);
        g5.addVertex(4);
        g5.addVertex(5);
        g5.addVertex(6);
        g5.addEdge(1, 2);
        g5.addEdge(3, 4);
        g5.addEdge(1, 5);
        g5.addEdge(5, 6);
        g5.addEdge(6, 4);
        // Se construye el camino esperado.
        List<Integer> expectedPath = new ArrayList<>();
        expectedPath.add(1);
        expectedPath.add(5);
        expectedPath.add(6);
        expectedPath.add(4);

        // Se comprueba si el camino devuelto es igual al esperado.
        assertEquals(expectedPath, g5.onePath(1, 4));
        g5.toString();
    }

    @Test
    public void containsVertex() {
        System.out.println("\n\n------TEST------");
        System.out.println("-------6-------");
        Graph<Integer> g1 = new Graph();
        g1.addVertex(3);
        assertTrue(g1.containsVertex(3));
        assertFalse(g1.containsVertex(69));
        g1.toString();
    }
}
