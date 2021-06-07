package assign3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import assign3.Exception.InvalidInput;
/*
 * Class having all functions related to tree
 */

public class Graph {

    /*
     * dependency of from parent to child relations
     */
    private Map<Integer, ArrayList<Integer>> child = new HashMap<>();

    /*
     * Reverse Dependency of from child to parent
     */
    private Map<Integer, ArrayList<Integer>> parents = new HashMap<>();

    /*
     * adding node details of a node
     */
    private Map<Integer, Node> nodeList = new HashMap<>();

    /*
     * Getter function of the child map
     * @return  child hashmap of the graph
     */
    public Map<Integer, ArrayList<Integer>> getChild() {
        return child;
    }

    /*
     * Setter function of the child map
     * @param child hashmap of the graph
     */
    public void setChild(final Map<Integer, ArrayList<Integer>> child) {
        this.child = child;
    }

    /*
     * Getter function of the parent map
     * @return parents hashmap of the graph reverse
     */
    public Map<Integer, ArrayList<Integer>> getParents() {
        return parents;
    }

    /*
     * Setter function of the parents map
     * @param parents hashmap of reverse of the graph
     */
    public void setParents(final Map<Integer, ArrayList<Integer>> parents) {
        this.parents = parents;
    }

    /*
     * hashmap of the node details
     * @return  nodeList
     */
    public Map<Integer, Node> getNodeList() {
        return nodeList;
    }

    /*
     * Setter function of nodelIst
     * @param nodeList hashmap of the node details
     */
    public void setNodeList(final Map<Integer, Node> nodeList) {
        this.nodeList = nodeList;
    }

    /*
     * it gets the next level  of the nodeid in parent
     * @param nodeId id of the node
     * @return ArrayList of node
     */
    public ArrayList<Integer> getImmediateParent(final int nodeId) {
        if (!nodeList.containsKey(nodeId)) {
            throw new InvalidInput(Constants.PRINT2);
        } else {
            return child.get(nodeId);
        }
    }

    /*
     *it will put the node in the record
     * @param nodeId unique id of node
     * @param node type class
     */
    public void addNode(final int nodeId, final Node node) {
        if (!nodeList.containsKey(nodeId)) {
            nodeList.put(nodeId, node);
            child.put(nodeId, new ArrayList<>());
            parents.put(nodeId, new ArrayList<>());
        } else {
            System.out.println("Node is already present");
        }
    }

    /*
     * it will get the next level of the child node
     * @param node node to be find descendendants
     * @return Arraylist of the nodes
     */
    public ArrayList<Integer> getImmediateChild(final int node) {
        if (!nodeList.containsKey(node)) {
            throw new InvalidInput(Constants.PRINT2);
        } else {
            return parents.get(node);
        }
    }

    /*
    * find all the ancestors from given node
    * */

    public ArrayList<Integer> getAllAncestors(int nodeId) {
        if (!nodeList.containsKey(nodeId)) {
            throw new InvalidInput(Constants.PRINT2);
        } else {
            return DfsOperator.dfs(nodeId, parents);
        }
    }

    public ArrayList<Integer> getAllDescendendants(int node) {
        if (!nodeList.containsKey(node)) {
            throw new InvalidInput(Constants.PRINT2);
        } else {
            return DfsOperator.dfs(node, child);
        }
    }


    public void deleteDependency(final int parid, final int childid) {
        if (!nodeList.containsKey(parid) || !nodeList.containsKey(childid))
            throw new InvalidInput(Constants.PRINT2);
        else {
            child.get(parid).remove(new Integer(childid));
            parents.get(childid).remove(new Integer(parid));
        }
    }

    public void deleteNode(final int id) {
        if (!nodeList.containsKey(id)) {
            throw new InvalidInput(Constants.PRINT2);
        } else {
            for (final Integer it : parents.get(id)) {
                child.get(it).remove(new Integer(id));
            }
            parents.remove(id);
            for (final Integer it : child.get(id)) {
                parents.get(it).remove(new Integer(id));
            }
            child.remove(id);
            nodeList.remove(id);
        }
    }

    void addDependency(final int parid, final int childid) {
        if (!nodeList.containsKey(parid) || !nodeList.containsKey(childid)) {
            throw new InvalidInput(Constants.PRINT2);
        } else {
            child.get(parid).add(childid);
            parents.get(childid).add(parid);
            boolean toAdd = DfsOperator.checkCycle(child);
            if (toAdd) {
                child.get(parid).remove(childid);
                parents.get(childid).remove(parid);
            }
        }
    }
}
