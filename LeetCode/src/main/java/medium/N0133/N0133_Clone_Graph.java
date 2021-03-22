package medium.N0133;

import vo.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Solution {
    Map<Node, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }
        //clone exists
        if(map.containsKey(node)){
            return map.get(node);
        }

        ArrayList<Node> neighbors = new ArrayList<>();
        Node clone = new Node(node.val, neighbors);
        map.put(node, clone);

        for(Node neighbor: node.neighbors){
            clone.neighbors.add(cloneGraph(neighbor));
        }

        return clone;
    }
}

//////////////////////////////////////////////////////////////////

public class N0133_Clone_Graph {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Node node = Node.loadNode(new int[][]{{2, 4}, {1, 3}, {2, 4}, {1, 3}});
        Node cloneNode = solution.cloneGraph(node);
        System.out.println(node);
        System.out.println(cloneNode);
        System.out.println("hi");
    }
}
