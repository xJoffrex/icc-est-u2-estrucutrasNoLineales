package Controllers;
import Models.Nodes;

public class AVLTree {
    private Nodes root;

    public AVLTree() {
        this.root = null;
    }

    public void insert(int value) {
        root = insertRec(root, value);
    }

    public int getHeightTree() {
        return height(root);
    }

    private Nodes insertRec(Nodes node, int value) {
        if (node == null) {
            Nodes newNode = new Nodes(value);
            newNode.setHeight(1);
            System.out.println("Nodo insertado -> " + value + " con balance 0");
            return newNode;
        }

        if (value < node.getValor()) {
            node.setNodoiz(insertRec(node.getNodoiz(), value));
        } else if (value > node.getValor()) {
            node.setNododere(insertRec(node.getNododere(), value));
        } else {
            return node;
        }

        int altura = 1 + Math.max(height(node.getNodoiz()), height(node.getNododere()));
        node.setHeight(altura);
        int balance = getBalance(node);

        System.out.println("Nodo actual -> " + node.getValor());
        System.out.println("\tAltura -> " + altura);
        System.out.println("\tBalance -> " + balance);

        if (balance > 1 && value < node.getNodoiz().getValor()) {
            System.out.println("Rotacion simple derecha");
            return rotateRight(node);
        }

        if (balance < -1 && value > node.getNododere().getValor()) {
            System.out.println("Rotacion simple izquierda");
            return rotateLeft(node);
        }

        if (balance > 1 && value > node.getNodoiz().getValor()) {
            System.out.println("Rotacion doble: izquierda-derecha");
            node.setNodoiz(rotateLeft(node.getNodoiz()));
            return rotateRight(node);
        }

        if (balance < -1 && value < node.getNododere().getValor()) {
            System.out.println("Rotacion doble: derecha-izquierda");
            node.setNododere(rotateRight(node.getNododere()));
            return rotateLeft(node);
        }

        return node;
    }

    private int height(Nodes node) {
        return (node == null) ? 0 : node.getHeight();
    }

    private int getBalance(Nodes node) {
        return (node == null) ? 0 : height(node.getNodoiz()) - height(node.getNododere());
    }

    private Nodes rotateLeft(Nodes x) {
        if (x == null || x.getNododere() == null) {
            System.out.println("Rotacion izquierda no valida");
            return x;
        }

        Nodes y = x.getNododere();
        if (y == null) return x;

        Nodes T2 = y.getNodoiz();

        System.out.println("Rotacion izq en nodo: " + x.getValor() + ", con balance = " + getBalance(x));

        y.setNodoiz(x);
        x.setNododere(T2);

        x.setHeight(Math.max(height(x.getNodoiz()), height(x.getNododere())) + 1);
        y.setHeight(Math.max(height(y.getNodoiz()), height(y.getNododere())) + 1);

        System.out.println("Nueva raiz despues de la rotacion: " + y.getValor() + "\n");
        return y;
    }

    private Nodes rotateRight(Nodes y) {
        if (y == null || y.getNodoiz() == null) {
            System.out.println("Rotacion derecha no valida");
            return y;
        }

        Nodes x = y.getNodoiz();
        if (x == null) return y;

        Nodes T2 = x.getNododere();

        System.out.println("Rotacion der en nodo: " + y.getValor() + ", con balance = " + getBalance(y));

        x.setNododere(y);
        y.setNodoiz(T2);

        y.setHeight(Math.max(height(y.getNodoiz()), height(y.getNododere())) + 1);
        x.setHeight(Math.max(height(x.getNodoiz()), height(x.getNododere())) + 1);

        System.out.println("Nueva raiz despues de la rotacion: " + x.getValor() + "\n");
        return x;
    }

    public void imprimirInOrder() {
        System.out.print("In Order: ");
        imprimirInOrderRec(root);
        System.out.println();
    }

    private void imprimirInOrderRec(Nodes node) {
        if (node != null) {
            imprimirInOrderRec(node.getNodoiz());
            System.out.print(node.getValor() + " ");
            imprimirInOrderRec(node.getNododere());
        }
    }
}
