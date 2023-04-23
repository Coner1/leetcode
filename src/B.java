import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class B {
    public static void main(String[] args) {
        B.Node assemble = new B().assemble();
        
        System.out.println(new B().levelOrder(assemble));
        
    }

    public Node assemble(){
        Node root = new Node(1);

        Node node11 = new Node(3);
        Node node12 = new Node(5);
        Node node21 = new Node(6);
        Node node22 = new Node(7);
        Node node23 = new Node(2);
        Node node24 = new Node(1);
        Node[] array = new Node[]{node11, node12, node21, node22, node23, node24};
        root.children = Arrays.asList(array);
        return root;
    }

    public List<Integer> levelOrder(Node root) {
        List<Integer> list = new ArrayList<>();

        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                System.out.println(queue.stream().map(item -> item.val).collect(Collectors.toList()));
                Node node = queue.poll();
                list.add(node.val);
                System.out.println("list"+list);
                if(node.children  == null) node.children = Collections.emptyList();
                for(Node tmp : node.children){
                    queue.offer(tmp);
                }
                
            }
            
        }
        

        
        



        return list;
    }
    // public Integer int(){
    // }
    class Node {
        public int val;
        public List<Node> children;
    
        public Node() {}
    
        public Node(int _val) {
            val = _val;
        }
    
        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
