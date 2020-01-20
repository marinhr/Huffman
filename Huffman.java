import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Huffman
{
    String s;
    private PriorityQueue<Node> priorityQ;
    Tree tree;
    int sizeOfEncoded;

    public Huffman(String s) {
        this.s = s;
    }

    //Filling map with the chars of the string and their values
    public void fillMap()
        {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char x : s.toCharArray())
            {
            map.put(x, map.getOrDefault(x, 0) + 1);
            }

        //Add all the chars in the Priority Queue
        priorityQ = new PriorityQueue<>();
			for (Map.Entry<Character, Integer> entries : map.entrySet())
			{
				Node node = new Node(Character.toString(entries.getKey()), entries.getValue());
				priorityQ.offer(node);
			}
        }

        //Creating nodes from the Priority Queue
        public void linkElementsIntoTree()
        {
            Node node1;
            Node node2;
            while (priorityQ.size() > 1)
            {
                 node1 = priorityQ.poll();
                 node2 = priorityQ.poll();
                priorityQ.offer(new Node(node1.getC() + node2.getC(), node1.getData()+node2.getData(), node1, node2));
            }
        }

        //Put the encoded letter in a string builder
        public String encodeElements()
        {
        linkElementsIntoTree();
            tree =  new Tree(priorityQ.poll());
            StringBuilder sb = new StringBuilder();
            for (char x : s.toCharArray())
            {
                sb.append(tree.cipheringLetters(Character.toString(x)));
                sizeOfEncoded = sb.length();
            }
           return sb.toString();
        }

        public int getSize()
        {
        return sizeOfEncoded;
        }

        public int getTreeSize()
        {
        return tree.treeSize(tree.getRoot()) - 1;
        }
}