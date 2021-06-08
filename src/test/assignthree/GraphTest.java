package test.assignthree;

import assignthree.model.Graph;
import assignthree.model.Node;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static org.junit.Assert.*;

/*
 * It is use to test all test the function on data structure
 */
public class GraphTest {
    @Test
    /*
     * unit testing
     */
    public void unitTest() {
        final Graph graph = new Graph();
        final Map<Integer, ArrayList<Integer>> child = new ConcurrentHashMap<>();
        final Map<Integer, ArrayList<Integer>> parent = new ConcurrentHashMap<>();
        child.put(1, new ArrayList<>());
        child.put(2, new ArrayList<>());
        child.put(3, new ArrayList<>());
        child.put(4, new ArrayList<>());
        child.put(5, new ArrayList<>());
        child.get(1).add(2);
        child.get(1).add(3);
        child.get(2).add(4);
        child.get(3).add(5);
        parent.put(1, new ArrayList<>());
        parent.put(2, new ArrayList<>());
        parent.put(3, new ArrayList<>());
        parent.put(4, new ArrayList<>());
        parent.put(5, new ArrayList<>());
        parent.get(2).add(1);
        parent.get(3).add(1);
        parent.get(4).add(2);
        parent.get(5).add(3);

        final Node node1 = new Node(1, "a");
        final Node node2 = new Node(2, "b");
        final Node node3 = new Node(3, "c");
        final Node node4 = new Node(4, "d");
        final Node node5 = new Node(5, "e");
        final Map<Integer, Node> nodeList = new ConcurrentHashMap<>();
        nodeList.put(1, node1);
        nodeList.put(2, node2);
        nodeList.put(3, node3);
        nodeList.put(4, node4);
        nodeList.put(5, node5);
        graph.setChild(child);
        graph.setParents(parent);
        graph.setNodeList(nodeList);
        assertEquals("Child map should be match", graph.getChild(), child);
        assertEquals("Parent map should be match", graph.getParents(), parent);
        assertEquals("nodelist map should be match", graph.getNodeList(), nodeList);
        final ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(2);
        list1.add(3);
        assertEquals(graph.getImmediateChild(1), list1);
        final ArrayList<Integer> list2 = new ArrayList<>();
        assertEquals(graph.getImmediateParent(1), list2);
        final ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(2);
        list3.add(4);
        list3.add(3);
        list3.add(5);
        assertEquals(graph.getAllDescendendants(1), list3);
        final ArrayList<Integer> list4 = new ArrayList<>();
        list4.add(3);
        list4.add(1);
        assertEquals(list4, graph.getAllAncestors(5));
        final Node node6 = new Node(6, "f");
        nodeList.put(6, node6);
        graph.addNode(6, node6);
        assertEquals(nodeList, graph.getNodeList());
        assertNull(graph.getChild().get(6));
    }

}