package leetcode.problems.Graph;

import java.util.*;

class GraphNode {
    public int val;
    public List<GraphNode> neighbors;

    public GraphNode() {}

    public GraphNode(int _val, List<GraphNode> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
public class CloneGraph {

    private Map<Integer, GraphNode> created = new HashMap<>();
    public GraphNode cloneGraph(GraphNode node) {
        Set<Integer> visited = new HashSet<>();
        if(node == null){
            return null;
        }
        Stack<GraphNode> stk = new Stack<>();
        stk.push(node);
        GraphNode start = null;
        while(!stk.isEmpty()){
            GraphNode exNode = stk.pop();
            if(visited.contains(exNode.val)){
                continue;
            }else {
                GraphNode cloneNode = createOrGetNode(exNode.val);
                if(start == null){
                    start = cloneNode;
                }
                List<GraphNode> clonedNei = createNei(exNode.neighbors);
                cloneNode.neighbors = clonedNei;
                for(GraphNode nei: exNode.neighbors){
                    if(visited.contains(nei.val)){
                        continue;
                    }
                    stk.push(nei);
                }
                visited.add(exNode.val);
            }
        }
        return start;
    }
    public List<GraphNode> createNei(List<GraphNode> exNei){
        List<GraphNode> cloneNei = new ArrayList<>();
        for(GraphNode n:exNei){
            cloneNei.add(createOrGetNode(n.val));
        }
        return cloneNei;
    }

    private GraphNode createOrGetNode(int val){
        if(created.containsKey(val)){
            return created.get(val);
        }else {
            GraphNode newNode = new GraphNode(val,new ArrayList<>());
            created.put(val,newNode);
            return newNode;
        }
    }
}
