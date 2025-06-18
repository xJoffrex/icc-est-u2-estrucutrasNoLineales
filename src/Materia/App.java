import Controllers.BinaryTree;

public class App {
    public static void main(String[] args) {
        BinaryTree ab = new BinaryTree();

        ab.insert(50);
        ab.insert(17);
        ab.insert(76);
        ab.insert(9);
        ab.insert(23);
        ab.insert(54);
        ab.insert(14);
        ab.insert(19);
       
        System.out.println("Pre Order");
        ab.imprimirPreOrder();
        System.out.println("In Order");
        ab.imprimirInOrder();
        System.out.println("Post Order");
        ab.imprimirPostOrder();
        
    }
}
