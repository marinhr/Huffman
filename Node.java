class Node implements Comparable<Node>
{
    private String c;
    private Integer data;
    private Node left;
    private Node right;

    public Node(String c, Integer data)
        {
        this.c = c; this.data = data;
        }

    public Node(String c, Integer data, Node left, Node right)
        {
        this.c = c; this.data = data; this.left = left; this.right = right;
        }

    @Override
    public int compareTo(Node n)
        {
        return Integer.compare(data, n.getData());
        }

    @Override
    public String toString()
        {
        return "Node [c=" + c + ", data=" + data + "]";
        }

    public Node getLeft()
        {
        return left;
        }

    public Node getRight()
        {
        return right;
        }

    public Integer getData()
        {
        return data;
        }

    public String getC()
        {
        return c;
        }
}
