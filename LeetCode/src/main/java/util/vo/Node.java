package vo;

import java.util.ArrayList;
import java.util.List;

public class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
    public static Node loadNode(int[][] adjList){
        List<Node> nodeList = new ArrayList<>();

        if(adjList==null){
            return null;
        }

        for(int i = 0 ; i < adjList.length ; i++ ){
            nodeList.add(new Node(i+1));
        }

        for(Node node : nodeList){
            int[] neighbors = adjList[node.val-1];
            List<Node> neighborList = new ArrayList<>();
            for(int i = 0 ; i < neighbors.length ; i++){
                neighborList.add(nodeList.get(neighbors[i]-1));
            }
            node.neighbors = neighborList;
        }

        return nodeList.get(0);
    }
}
