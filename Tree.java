public class Tree {
    private Node root;

    //Encoding the letters
    public Tree(Node nd){
        root = nd;
    }
    public String cipheringLetters(String s){
        Node node = root;
        StringBuilder sb = new StringBuilder();
        while(node!=null){
            if(node.getLeft().getC().contains(s)){
                sb.append(0);
                node = node.getLeft();
            }
            else if (node.getRight().getC().contains(s)){
                sb.append(1);
                node= node.getRight();
            }
            if (node.getLeft() == null &&  node.getRight()==null)
                break;
        }
        return sb.toString();
    }

//    void printPreorder(Node node)
//    {
//        if (node == null)
//            return;
//
//        System.out.print(node.getC() + " ");
//        printPreorder(node.getLeft());
//        printPreorder(node.getRight());
//    }

    public Node getRoot() {
        return root;
    }
    //Calculate the height of the tree
    public int treeSize(Node node)
    {
        if (node == null)
            return 0;
        else
            return(Math.max(treeSize(node.getLeft()),treeSize(node.getRight()))+1);
    }

}

