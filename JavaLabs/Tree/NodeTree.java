public class NodeTree{
    private int data;
    private NodeTree less;
    private NodeTree more;
    private NodeTree parent;

    NodeTree(int num){
        this.data = num;
        this.less = null;
        this.more = null;
    }
    NodeTree(int num, NodeTree parent){
        this.data = num;
        this.less = null;
        this.more = null;
        this.parent = parent;
    }

    public int getData() {
        return data;
    }

    public NodeTree getLess() {
        return less;
    }

    public void setLess(NodeTree less) {
        this.less = less;
    }

    public NodeTree getMore() {
        return more;
    }

    public void setMore(NodeTree more) {
        this.more = more;
    }

    public NodeTree getParent() {
        return parent;
    }

    public void setParent(NodeTree parent) {
        this.parent = parent;
    }

}
