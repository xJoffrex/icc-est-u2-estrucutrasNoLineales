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

        if (ab.finddeValue(23)){
            System.out.println("Encontro el valor 23"); 
        }else{
            System.out.println("No se encontro el valor 23");
        }
        if (ab.finddeValue(77)){
            System.out.println("Encintro el valor 77");
        }else{
            System.out.println("No se encontro el valor 77");
        }
        
    }
}
