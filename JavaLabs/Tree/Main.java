public class Main {

    public static void main(String[] args){
        TreeBin treeBin = new TreeBin();
        treeBin.add(9);
        treeBin.add(6);
        treeBin.add(5);
        treeBin.add(3);
        treeBin.add(7);
        treeBin.add(6);
        treeBin.add(13);
        treeBin.add(11);
        treeBin.add(19);
        treeBin.add(17);
        treeBin.add(21);
        treeBin.add(6);
        treeBin.add(21);
        treeBin.print();
        System.out.println(treeBin.getSize());
        treeBin.delete(13);
        treeBin.print();
        System.out.println(treeBin.getSize());
        treeBin.delete(9);
        treeBin.print();
        System.out.println(treeBin.getSize());


    }
}

