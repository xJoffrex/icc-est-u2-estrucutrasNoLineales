package Controllers;
import java.util.ArrayList;
import java.util.List;

import Models.Nodes;

public class BinaryTree {
    private Nodes root;
    private int peso;

    public BinaryTree() {
        this.root = null;
        this.peso = 0;
      
    }

    public void insert(int value) {
        root = insertRec(root, value);
        peso++;
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

   
    public void imprimirInOrderNormal() {
        imprimirInOrderRecNormal(root);
        System.out.println();
    }
       
    public void imprimirInOrderAltura() {
        imprimirInOrderRecHeight(root);
        System.out.println();
    }
       
    public void imprimirInOrderRecEquilibrio() {
        imprimirInOrderRecEquilibrio(root);
        System.out.println();
    }

    private void imprimirInOrderRecNormal(Nodes nodo) {
        if (nodo != null) {
            imprimirInOrderRecNormal(nodo.getNodoiz());
            System.out.print(nodo.getValor() + " ");
            imprimirInOrderRecNormal(nodo.getNododere());
        }
    }

    private void imprimirInOrderRecHeight(Nodes nodo) {
        if (nodo != null) {
            imprimirInOrderRecHeight(nodo.getNodoiz());
            System.out.print(nodo.getValor() + "[h=" + getHeightRec(nodo) + "], ");
            imprimirInOrderRecHeight(nodo.getNododere());
        }
    }

    private void imprimirInOrderRecEquilibrio(Nodes nodo) {
        if (nodo != null) {
            imprimirInOrderRecEquilibrio(nodo.getNodoiz());
            System.out.print(nodo.getValor() + "[bf=" + getHeightFactorRec(nodo) + "], ");

    
            imprimirInOrderRecEquilibrio(nodo.getNododere());
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

    public boolean finddeValue(int value) {
        return buscarValorRec(root, value);
    }

    private boolean buscarValorRec(Nodes nodo, int value) {
        if (nodo == null) {
            return false;
        }
        if (value == nodo.getValor()) {
            return true;
        }
        return value < nodo.getValor() ? buscarValorRec(nodo.getNodoiz(), value) : buscarValorRec(nodo.getNododere(), value);
    }

    public int getHeightTree(){
        return getHeightRec(root);
    }

    private int getHeightRec(Nodes node){
        if (node == null){
            return 0;
        }
        int leftheight = getHeightRec(node.getNodoiz());
        int rightheight = getHeightRec(node.getNododere());

        return Math.max(leftheight, rightheight) + 1;

    }

    public int getHeightFactor(){
        return getHeightFactorRec(root);
    }

    private int getHeightFactorRec(Nodes node){
        if (node == null){
            return 0;
        }
        int leftheight = getHeightRec(node.getNodoiz());
        int rightheight = getHeightRec(node.getNododere());

        return (leftheight - rightheight);

    }

    public int getPeso() {
        return peso;
    }

    public boolean estaBalanceado() {
    return estaBalanceadoRec(root);
    }

    private boolean estaBalanceadoRec(Nodes nodo) {
        if (nodo == null) {
            return true;
        }

        int izquierda = getHeightRec(nodo.getNodoiz());
        int derecha = getHeightRec(nodo.getNododere());

    
        if (izquierda - derecha > 1 || derecha - izquierda > 1) {
            return false;
        }

        return estaBalanceadoRec(nodo.getNodoiz()) && estaBalanceadoRec(nodo.getNododere());
    }


    public void imprimirInOrderConEquilibrioYNodosDesequilibrados() {
        List<String> desequilibrados = new ArrayList<>();
        System.out.println("In Order con equilibrio");
        imprimirYDetectarDesequilibrados(root, desequilibrados);
        System.out.println(); 

        if (!desequilibrados.isEmpty()) {
            System.out.print("Nodos desequilibrados ");
            for (int i = 0; i < desequilibrados.size(); i++) {
                System.out.print(desequilibrados.get(i));
                if (i < desequilibrados.size() - 1) {
                    System.out.print(" y ");
                }
            }
            System.out.println(); 
        }
    }

    private void imprimirYDetectarDesequilibrados(Nodes nodo, List<String> desequilibrados) {
        if (nodo != null) {
            imprimirYDetectarDesequilibrados(nodo.getNodoiz(), desequilibrados);

            int fe = getHeightFactorRec(nodo);
            System.out.print(nodo.getValor() + "(bf=" + fe + "), ");

            if (fe > 1 || fe < -1) {
                desequilibrados.add(nodo.getValor() + "(fE = " + fe + ")");
            }

            imprimirYDetectarDesequilibrados(nodo.getNododere(), desequilibrados);
        }
}


    
}
