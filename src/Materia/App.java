import Controllers.AVLTree;
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
       
       // System.out.println("Pre Order");
      //  ab.imprimirPreOrder();
        System.out.println("Peso: " + ab.getPeso());
        System.out.println("Altura total del arbol: " + ab.getHeightTree());
        System.out.println("In Order");
        ab.imprimirInOrderNormal();
        System.out.println("In Order Altura");
        ab.imprimirInOrderAltura();
        System.out.println("In Order Equilibrio");
        ab.imprimirInOrderRecEquilibrio();

        boolean balanceado = ab.estaBalanceado();
        System.out.println("Arbol esta equilibrado = " + balanceado);

        System.out.println("Existe el nodo 15 = " + ab.finddeValue(15));
        System.out.println("Agrega Nodo 15");
        ab.insert(15);
        System.out.println("Existe el nodo 15 = " + ab.finddeValue(15));
        ab.imprimirInOrderConEquilibrioYNodosDesequilibrados();

        AVLTree arbol = new AVLTree();

        arbol.insert(5);
        arbol.insert(20);
        arbol.insert(15);

        System.out.println("\nAltura final del arbol: " + arbol.getHeightTree());
      //  System.out.println("Post Order");
       // ab.imprimirPostOrder();

      //  if (ab.finddeValue(23)){
       //     System.out.println("Encontro el valor 23"); 
       // }else{
         //   System.out.println("No se encontro el valor 23");
      //  }
        //f (ab.finddeValue(77)){
         //   System.out.println("Encintro el valor 77");
        //}else{
       //     System.out.println("No se encontro el valor 77");
       // }
        

        
    }
}
