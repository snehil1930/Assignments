package assign3.util;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/*
 * This class will perform all the searching based option depth wise
 */
public class DfsOperator {

    /*
     * dfs util function for the searching the node subtree
     * @param src source node for the search
     * @param child hashmap for nodeid to list
     * @param res list for adding all node collected
     * @param visited boolean array for visited array
     */
    public static void dfsHelper(final int src, final Map<Integer, ArrayList<Integer>> child,
                                 final ArrayList<Integer> res, final boolean[] visited) {
        visited[src] = true;
        res.add(src);
        final Iterator<Integer> i = child.get(src).listIterator();
        while (i.hasNext()) {
            final int n = i.next();
            if (!visited[n])
                dfsHelper(n, child, res, visited);
        }
    }

    /*
     * searching function on depth first search
     * @param node soruce node of search
     * @param child hashmap of the integer to the arraylist
     */
    public static ArrayList<Integer> dfs(final int node, final Map<Integer, ArrayList<Integer>> child) {
        final int noOfNode = child.size();
        boolean[] visited = new boolean[noOfNode + 1];
        final ArrayList<Integer> result = new ArrayList<>();
        dfsHelper(node, child, result, visited);
        result.remove(0);
        return result;
    }

    /*
     * util method for the cycle detection in the graph using Kosaraju's Algo
     * @param node source node for the search
     * @param visited boolean array for storing the visited node
     * @param recStack boolean array for stacking the component of node
     * @param child hashmap of integer to arrayist of connected nodes
     * @return boolean value
     */
    public static boolean isCyclicUtil(final int node, final boolean[] visited,
                                       final boolean[] recStack, final Map<Integer, ArrayList<Integer>> child) {
        if (recStack[node])
            return true;
        if (visited[node])
            return false;
        visited[node] = true;
        recStack[node] = true;
        final ArrayList<Integer> children = child.get(node);
        for (final Integer c : children){
            if (isCyclicUtil(c, visited, recStack, child)){
                return true;
            }
        }
        recStack[node] = false;
        return false;
    }

    /*
     * check whether the cycle is present int the graph
     * @param child hashmap of the list of node connected to the node
     * @return boolean value of the result
     */
    public static boolean checkCycle(final Map<Integer, ArrayList<Integer>> child) {
        final int noOfNode = child.size();
        boolean[] visited = new boolean[noOfNode + 1];
        boolean[] recStack = new boolean[noOfNode + 1];
        for (int i = 1; i <= noOfNode; i++) {
            if (isCyclicUtil(i, visited, recStack, child)) {
                return true;
            }
        }
        return false;
    }
}



