package Controllers;
import Models.Nodes;

public class BinaryTree {
    private Nodes root;

    public BinaryTree() {
        this.root = null;
    }

    public void insert(int value) {
        root = insertRec(root, value);
    }

    private Nodes insertRec(Nodes padre, int value) {
        if (padre == null) {  
            return new Nodes(value); 
        }
        
        if (value < padre.getValor()) {  
            padre.setNodoiz(insertRec(padre.getNodoiz(), value));
        } else if (value > padre.getValor()) {  
            padre.setNododere(insertRec(padre.getNododere(), value));
        }
        return padre;
    }

  
    public void imprimirPreOrder() {
        imprimirPreOrderRec(root);
        System.out.println();
    }

    private void imprimirPreOrderRec(Nodes nodo) {
        if (nodo != null) {
            System.out.print(nodo.getValor() + " "); 
            imprimirPreOrderRec(nodo.getNodoiz());
            imprimirPreOrderRec(nodo.getNododere());
        }
    }

   
    public void imprimirInOrder() {
        imprimirInOrderRec(root);
        System.out.println();
    }

    private void imprimirInOrderRec(Nodes nodo) {
        if (nodo != null) {
            imprimirInOrderRec(nodo.getNodoiz());
            System.out.print(nodo.getValor() + " ");
            imprimirInOrderRec(nodo.getNododere());
        }
    }

   
    public void imprimirPostOrder() {
        imprimirPostOrderRec(root);
        System.out.println();
    }

    private void imprimirPostOrderRec(Nodes nodo) {
        if (nodo != null) {
            imprimirPostOrderRec(nodo.getNodoiz());
            imprimirPostOrderRec(nodo.getNododere());
            System.out.print(nodo.getValor() + " "); 
        }
    }
}
