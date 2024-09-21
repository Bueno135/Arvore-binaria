class Node {
    int valor;
    Node esquerda, direita;

    public Node(int valor) {
        this.valor = valor;
        esquerda = direita = null;
    }
}

class ArvoreBinaria {
    Node raiz;

    public ArvoreBinaria() {
        raiz = null;
    }

    void inserir(int valor) {
        raiz = inserirRec(raiz, valor);
    }

    Node inserirRec(Node raiz, int valor) {
        if (raiz == null) {
            raiz = new Node(valor);
            return raiz;
        }
        if (valor < raiz.valor)
            raiz.esquerda = inserirRec(raiz.esquerda, valor);
        else if (valor > raiz.valor)
            raiz.direita = inserirRec(raiz.direita, valor);
        return raiz;
    }

    boolean buscar(int valor) {
        return buscarRec(raiz, valor);
    }

    boolean buscarRec(Node raiz, int valor) {
        if (raiz == null) {
            return false;
        }
        if (raiz.valor == valor) {
            return true;
        }
        return valor < raiz.valor
            ? buscarRec(raiz.esquerda, valor)
            : buscarRec(raiz.direita, valor);
    }

    void percorrerInOrder() {
        percorrerInOrderRec(raiz);
    }

    void percorrerInOrderRec(Node raiz) {
        if (raiz != null) {
            percorrerInOrderRec(raiz.esquerda);
            System.out.print(raiz.valor + " ");
            percorrerInOrderRec(raiz.direita);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();

        arvore.inserir(50);
        arvore.inserir(30);
        arvore.inserir(20);
        arvore.inserir(40);
        arvore.inserir(70);
        arvore.inserir(60);
        arvore.inserir(80);

        System.out.println("Travessia In-Order:");
        arvore.percorrerInOrder();

        System.out.println("\n\nBuscar 40: " + arvore.buscar(40)); 
        System.out.println("Buscar 100: " + arvore.buscar(100));
    }
}
