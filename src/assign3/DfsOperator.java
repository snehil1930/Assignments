package assign3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class DfsOperator {


    public static void dfsHelper(final int src,final  Map<Integer, ArrayList<Integer>> child,
                                 final ArrayList<Integer> res, final boolean vis[]) {
        vis[src]=true;
        res.add(src);
        Iterator<Integer> i = child.get(src).listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!vis[n])
                dfsHelper(n, child,res,vis);
        }
    }



    public static ArrayList<Integer> dfs(final int node, final Map<Integer, ArrayList<Integer>> child){
        int noOfNode= child.size();
        boolean visited[]= new boolean[noOfNode+1];
        ArrayList<Integer> result=new ArrayList<>();
        dfsHelper(node ,child,result,visited);
       result.remove(0);
        return  result;
    }

    public static boolean isCyclicUtil(final int node ,final boolean visited[],
                                       final boolean recStack[],final Map<Integer,ArrayList<Integer>> child){
        if (recStack[node])
            return true;

        if (visited[node])
            return false;

        visited[node] = true;

        recStack[node] = true;
        ArrayList<Integer> children = child.get(node);
        if(children!=null) {
            for (Integer c : children)
                if (isCyclicUtil(c, visited, recStack, child))
                    return true;
        }
        recStack[node] = false;

        return false;

    }


    public static boolean checkCycle(final Map<Integer,ArrayList<Integer> >child){
        int noOfNode= child.size();
        boolean[] visited = new boolean[noOfNode+1];
        boolean[] recStack = new boolean[noOfNode+1];
        for (int i = 1; i <= noOfNode; i++)
            if (isCyclicUtil(i, visited, recStack,child))
                return true;
        return false;
    }
}



