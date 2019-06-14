public class TreeBin {
    private NodeTree root;
    private int size;

    private void out(NodeTree now){

        if(now.getLess() != null){
            out(now.getLess());
        }
        System.out.print(" " + now.getData());

        if(now.getMore() != null){
            out(now.getMore());
        }
    }

    private void addDel(NodeTree element){

        if(element.getLess() != null){
            addDel(element.getLess());
        }
        this.add(element.getData());
        size--;

        if(element.getMore() != null){
            addDel(element.getMore());
        }
    }

    private NodeTree searchNode(int num){
        NodeTree required = null;
        NodeTree current = this.root;
        NodeTree prev = null;
        while(true){
            prev = current;
            if(num==prev.getData()){
                required=prev;
                break;
            }if(num<prev.getData()){
                current=current.getLess();
            }if(current==null) {
                prev.setLess(new NodeTree(num));
                continue;
            }if(num>prev.getData()){
                current=current.getMore();
                if(current==null){
                    prev.setMore(new NodeTree(num));
                    continue;
                }
            }
        }
        return required;
    }


    public int getSize(){
        return this.size;
    }

    public void print() {
        this.out(this.root);
        System.out.println("");
    }

    public void add(int num){
        if(this.root==null){
            this.root = new NodeTree(num);
            size++;
        }else{
            NodeTree current = this.root;
            NodeTree prev = null;
            while(true){
                prev = current;
                if(num==prev.getData())
                    break;
                if(num<prev.getData()){
                    current=current.getLess();
                }if(current==null) {
                    prev.setLess(new NodeTree(num,prev));
                    size++;
                    return;
                }if(num>prev.getData()){
                    current=current.getMore();
                    if(current==null){
                        prev.setMore(new NodeTree(num,prev));
                        size++;
                        return;
                    }
                }
            }
        }
    }

    public void delete(int element){
        NodeTree deleted = this.searchNode(element);
        if(deleted.getParent() != null){
            NodeTree parentDelElem = deleted.getParent();
            if(deleted.getData() > parentDelElem.getData()){
                parentDelElem.setMore(null);
                deleted.setParent(null);
            }
            if(deleted.getData() < parentDelElem.getData()){
                parentDelElem.setLess(null);
                deleted.setParent(null);
            }
            this.addDel(deleted.getLess());
            this.addDel(deleted.getMore());
            size--;
        }else{
            this.root=root.getLess();
            this.addDel(deleted.getMore());
            size--;
        }
    }

}
