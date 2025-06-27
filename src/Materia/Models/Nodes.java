package Models;

public class Nodes {
    private int valor;
    private Nodes nodoiz;
    private Nodes nododere;
    private int Height;


    
    public Nodes(int valor) {
        this.valor = valor;
        this.nodoiz = null;
        this.nododere = null;
    }


    public int getValor() {
        return valor;
    }
    public void setValor(int valor) {
        this.valor = valor;
    }
    public Nodes getNodoiz() {
        return nodoiz;
    }
    public void setNodoiz(Nodes nodoiz) {
        this.nodoiz = nodoiz;
    }
    public Nodes getNododere() {
        return nododere;
    }
    public void setNododere(Nodes nododere) {
        this.nododere = nododere;
    }
    
    public int getHeight() {
        return Height;
    }


    public void setHeight(int height) {
        Height = height;
    }

    @Override
    public String toString() {
        return "Nodes [valor=" + valor + "]";
    }





    
}
