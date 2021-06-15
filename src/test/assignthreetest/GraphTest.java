package test.assignthreetest;

import assignmentthree.model.Graph;
import assignmentthree.model.Node;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static org.junit.Assert.*;

/*
 * It is use to test all test the function on data structure
 */
public class GraphTest {

    private final Graph graph = new Graph();
    private Map<Integer, ArrayList<Integer>> child;
    private Map<Integer, ArrayList<Integer>> parent;
    private Map<Integer, Node> nodeList;

    /*
     * preparing the graph for under the test
     */

    public void init() {
        child = new ConcurrentHashMap<>();
        parent = new ConcurrentHashMap<>();
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
        nodeList = new ConcurrentHashMap<>();
        nodeList.put(1, new Node(1, "a"));
        nodeList.put(2, new Node(2, "b"));
        nodeList.put(3, new Node(3, "c"));
        nodeList.put(4, new Node(4, "d"));
        nodeList.put(5, new Node(5, "e"));
        graph.setChild(child);
        graph.setParents(parent);
        graph.setNodeList(nodeList);
    }

    /*
     * verifying graph formed is correct in edge linkage
     * and number of unique id present
     */
    @Test
    public void graphFormationTest() {
        init();
        final Map<Integer, ArrayList<Integer>> childTest = child;
        final Map<Integer, ArrayList<Integer>> parentTest = parent;
        final Map<Integer, Node> nodeListTest = nodeList;
        assertEquals("Graph of parents should be made exactly same", parentTest, graph.getParents());
        assertEquals("Graph of child should be made exactly same", childTest, graph.getChild());
        assertEquals("Graph of node list must be same", nodeListTest, graph.getNodeList());
    }

    /*
     * immediate child testing
     */
    @Test
    public void immediateChildTest() {
        init();
        graph.setChild(child);
        graph.setParents(parent);
        graph.setNodeList(nodeList);
        System.out.println(graph.getChild());
        final var list = new ArrayList<>();
        list.add(2);
        list.add(3);
        assertEquals(graph.getImmediateChild(1), list);
    }

    /*
     * immediate parent testing
     */
    @Test
    public void immediateParentTest() {
        init();
        assertNotNull(graph.getImmediateParent(1));
        final ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        assertEquals(list1, graph.getImmediateParent(2));
    }

    /*
     * all subtree element at given node
     */
    @Test
    public void allDescendendantsTest() {
        init();
        final ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(2);
        list3.add(4);
        list3.add(3);
        list3.add(5);
        assertEquals(graph.getAllDescendendants(1), list3);
    }

    /*
     * all ancestor from the node
     */
    @Test
    public void allAncestors() {
        init();
        final ArrayList<Integer> list4 = new ArrayList<>();
        list4.add(3);
        list4.add(1);
        assertEquals(list4, graph.getAllAncestors(5));
    }

    /*
     * match the node in the graph
     */
    @Test
    public void nodelistTest() {
        init();
        nodeList.put(6, new Node(6, "f"));
        graph.addNode(6, new Node(6, "f"));
        assertEquals(nodeList, graph.getNodeList());
        assertNull(graph.getChild().get(6));
    }

    /*
     * delete the dummy data dependency and matching with actual graph
     */

    @Test
    public void deleteDependencyTest() {
        init();
        final Map<Integer, ArrayList<Integer>> childTest = child;
        final Map<Integer, ArrayList<Integer>> parentTest = parent;
        final Integer childId = 5;
        final Integer parentId = 3;
        childTest.get(3).remove(childId);
        parentTest.get(5).remove(parentId);
        graph.deleteDependency(3, 5);
        assertEquals(childTest, graph.getChild());
        assertEquals(parentTest, graph.getParents());
    }

    /*
     * add the dummy data dependency and matching with actual graph
     */
    @Test
    public void addDependencyTest() {
        init();
        final Map<Integer, ArrayList<Integer>> childTest = child;
        final Map<Integer, ArrayList<Integer>> parentTest = parent;
        final Integer childId = 6;
        final Integer parentId = 3;
        graph.addNode(6, new Node(6, "test"));
        childTest.put(6, new ArrayList<>());
        parentTest.put(6, new ArrayList<>());
        childTest.get(3).add(childId);
        parentTest.get(6).add(parentId);
        graph.addDependency(3, 6);
        assertEquals(childTest, graph.getChild());
        assertEquals(parentTest, graph.getParents());
    }

    /*
     * adding the new component in graph
     */
    @Test
    public void addNode() {
        init();
        graph.addNode(6, new Node(6, "test"));
        assertEquals(new ArrayList<>(), graph.getChild().get(6));
    }
}