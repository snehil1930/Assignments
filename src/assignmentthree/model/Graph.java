package assignmentthree.model;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

import assignmentthree.constants.ErrorConstants;
import assignmentthree.dfs.DfsOperator;
import assignmentthree.exceptions.InvalidInput;

/*
 * Class having all functions related to tree
 */
public class Graph {

    /*
     * dependency of from parent to child relations
     */
    private Map<Integer, ArrayList<Integer>> child=new ConcurrentHashMap<>();

    /*
     * Reverse Dependency of from child to parent
     */
    private Map<Integer, ArrayList<Integer>> parents=new ConcurrentHashMap<>();

    /*
     * adding node details of a node
     */
    private Map<Integer, Node> nodeList=new ConcurrentHashMap<>();

    /*
     * Getter function of the child map
     * @return  child hashmap of the graph
     */
    public Map<Integer, ArrayList<Integer>> getChild() {
        if (Objects.isNull(child)) {
            child = new ConcurrentHashMap<>();
        }
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
        if (Objects.isNull(parents)) {
            parents = new ConcurrentHashMap<>();
        }
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
        if (Objects.isNull(nodeList)) {
            nodeList = new ConcurrentHashMap<>();
        }
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
    public ArrayList<Integer> getImmediateParent(final Integer nodeId) {
        if (!nodeList.containsKey(nodeId)) {
            throw new InvalidInput(ErrorConstants.NODE_IS_NOT_PRESENT);
        } else {
            return parents.get(nodeId);
        }
    }

    /*
     *it will put the node in the record
     * @param nodeId unique id of node
     * @param node type class
     */
    public void addNode(final Integer nodeId, final Node node) {
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
    public ArrayList<Integer> getImmediateChild(final Integer node) {
        if (!nodeList.containsKey(node)) {
            throw new InvalidInput(ErrorConstants.NODE_IS_NOT_PRESENT);
        } else {
            return child.get(node);
        }
    }

    /*
     * find all the ancestors from given node
     * @param nodeId source id of node
     * @return ArrayList of all Ancestors
     */
    public ArrayList<Integer> getAllAncestors(final Integer nodeId) {
        if (!nodeList.containsKey(nodeId)) {
            throw new InvalidInput(ErrorConstants.NODE_IS_NOT_PRESENT);
        } else {
            return DfsOperator.dfs(nodeId, parents);
        }
    }

    /*
     * find all the descendendants from given node
     * @param nodeId source id of node
     * @return ArrayList of all Descendendants
     */
    public ArrayList<Integer> getAllDescendendants(final Integer node) {
        if (!nodeList.containsKey(node)) {
            throw new InvalidInput(ErrorConstants.NODE_IS_NOT_PRESENT);
        } else {
            return DfsOperator.dfs(node, child);
        }
    }

    /*
     * remove the connection between the node ids if they are present
     * @paran parentId id of parent node
     * @param  childId id of child node
     */
    public void deleteDependency(final Integer parentId, final Integer childId) {
        if (!nodeList.containsKey(parentId) || !nodeList.containsKey(childId)) {
            throw new InvalidInput(ErrorConstants.NODE_IS_NOT_PRESENT);
        } else {
            child.get(parentId).remove(childId);
            parents.get(childId).remove(parentId);
        }
    }

    /*
     * delete the node from graph and all connections to it
     * @param id node which is to be deleted
     */
    public void deleteNode(final Integer nodeId) {
        if (!nodeList.containsKey(nodeId)) {
            throw new InvalidInput(ErrorConstants.NODE_IS_NOT_PRESENT);
        } else {
            parents.get(nodeId).forEach(it -> child.get(it).remove(nodeId));
            parents.remove(nodeId);
            child.get(nodeId).forEach(it -> parents.get(it).remove(nodeId));
            child.remove(nodeId);
            nodeList.remove(nodeId);
        }
    }

    /*
     * it is used to add connection between nodes if it does not
     * form cycle
     * @param parentId parent id of connection
     * @param childId child node of connection
     * */
    public void addDependency(final Integer parentId, final Integer childId) {
        if (!nodeList.containsKey(parentId) || !nodeList.containsKey(childId)) {
            throw new InvalidInput(ErrorConstants.NODE_IS_NOT_PRESENT);
        } else {
            child.get(parentId).add(childId);
            parents.get(childId).add(parentId);
            if (DfsOperator.checkCycle(child)) {
                child.get(parentId).remove(childId);
                parents.get(childId).remove(parentId);
            }
        }
    }
}
