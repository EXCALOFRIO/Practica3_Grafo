package pr3.org;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
        Graph<Integer> g = new Graph();
        assertTrue(g.addVertex(3));
        assertTrue(g.addVertex(3));
        
        Graph<String> gs = new Graph();
        assertTrue(gs.addVertex("a"));
    }

    @Test
    public void annadirEdge(){
        Graph<Integer> g = new Graph();
        g.addVertex(3);
        g.addVertex(9);
        g.addVertex(4);
        assertTrue(g.addEdge(3,9));
        assertTrue(g.addEdge(3,4));
        
        Graph<String> gs = new Graph();
        assertTrue(gs.addEdge("a","b"));
    }

    @Test
    public void obtainAdjacents(){
        Graph<Integer> g = new Graph();
        assertTrue(g.addEdge(3,9));
        assertTrue(g.addEdge(3,4));
        
        Graph<String> gs = new Graph();
        assertTrue(gs.addEdge("a","b"));
    }
}
