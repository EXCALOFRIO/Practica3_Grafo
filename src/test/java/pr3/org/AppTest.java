package pr3.org;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import pr3.org.dominio.Graph;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void annadirVertice() {
        Graph<Integer> g = new Graph();
        assertTrue(g.addVertex(3));
        assertFalse(g.addVertex(3));

        Graph<String> gs = new Graph();
        assertTrue(gs.addVertex("a"));
        String miTexto = "a[]\n";
        assertEquals(miTexto, gs.toString());
    }

    @Test
    public void containsVertex() {
        Graph<Integer> g = new Graph();
        g.addVertex(3);
        assertTrue(g.containsVertex(3));
        assertFalse(g.containsVertex(69));
    }

    @Test
    public void annadirEdge() {
        Graph<String> gs = new Graph();
        gs.addVertex("a");
        gs.addVertex("b");
        assertTrue(gs.addEdge("a", "b"));

        assertEquals("a[b]\nb[a]\n", gs.toString());
    }

    @Test
    public void annadirEdgeError() {
        Graph<String> gs = new Graph();
        gs.addVertex("a");
        assertFalse(gs.addEdge("a", "b"));
        assertFalse(gs.addEdge("b", "a"));
        assertFalse(gs.addEdge("k", "j"));
    }

    @Test
    public void annadirEdgeError2() {
        Graph<Integer> g = new Graph();
        g.addVertex(3);
        g.addVertex(9);
        g.addVertex(4);
        assertTrue(g.addEdge(3, 9));
        assertTrue(g.addEdge(3, 4));
        assertFalse(g.addEdge(3, 9));
        assertFalse(g.addEdge(4, 3));
    }

    @Test(expected = Exception.class)
    public void obtenerAdyacentes() throws Exception {
        Graph<Integer> g = new Graph();
        g.addVertex(3);
        g.addVertex(9);
        g.addVertex(4);
        g.addVertex(1);
        g.addEdge(3, 9);
        g.addEdge(9, 4);
        g.obtainAdjacents(3);
        g.obtainAdjacents(1);
        assertEquals("1[]\n3[9]\n4[9]\n9[3, 4]\n", g.toString());
        g.obtainAdjacents(69);
    }

    @Test
    public void crearOnePathError() throws Exception {
        Graph<Integer> g = new Graph();
        g.addVertex(1);
        g.addVertex(2);
        g.addVertex(3);
        g.addVertex(4);
        g.addVertex(5);
        g.addVertex(6);
        g.addVertex(8);
        assertTrue(g.addEdge(1, 2));
        assertTrue(g.addEdge(1, 3));
        assertTrue(g.addEdge(3, 4));
        assertTrue(g.addEdge(4, 5));
        assertTrue(g.addEdge(4, 6));
        assertTrue(g.addEdge(2, 8));
        assertNull(g.onePath(69, 8));
        assertNull(g.onePath(69, 68));
        assertNull(g.onePath(6, 7));
    }

    @Test(expected = Exception.class)
    public void obtainAdjacentsString() throws Exception {
        Graph<String> gs = new Graph();
        gs.addVertex("a");
        gs.addVertex("b");
        gs.addVertex("c");
        gs.addVertex("j");
        gs.addVertex("ju");

        assertTrue(gs.addEdge("a", "b"));
        assertFalse(gs.addEdge("a", "b"));
        assertTrue(gs.addEdge("a", "c"));
        assertFalse(gs.addEdge("a", "c"));
        assertTrue(gs.addEdge("j", "c"));
        assertTrue(gs.addEdge("c", "b"));
        assertFalse(gs.addEdge("c", "c"));

        gs.obtainAdjacents("a");
        gs.obtainAdjacents("j");
        gs.obtainAdjacents("c");
        gs.toString();
        gs.onePath("a", "j");
        // Despues de este no se puede añadir nada por la excepcion q lanza
        gs.obtainAdjacents("op");
    }

    /**
     * Este test comprueba que el método ‘onePath(V v1, V v2)‘ encuentra un camino
     * entre ‘v1‘ y ‘v2‘ cuando existe.
     * 
     * @throws Exception
     */
    @Test
    public void onePathFindsAPath() throws Exception {
        // Se construye el grafo.
        Graph<Integer> g = new Graph<>();
        g.addVertex(1);
        g.addVertex(2);
        g.addVertex(3);
        g.addVertex(4);
        g.addVertex(5);
        g.addVertex(6);
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

        // Se comprueba si el camino devuelto es igual al esperado.
        assertEquals(expectedPath, g.onePath(1, 4));
        g.toString();
    }

}
