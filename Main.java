package main.java.com.joao.RedeSocial;

public class Main {

    public static void main(String[] args){

        Grafo grafo = new Grafo();

        grafo.adicionarPessoa(new Pessoa("A", "Alisson", 20));
        grafo.adicionarPessoa(new Pessoa("B", "Bruno", 25));
        grafo.adicionarPessoa(new Pessoa("C", "Carlos", 30));
        grafo.adicionarPessoa(new Pessoa("D", "Daniel", 22));
        grafo.adicionarPessoa(new Pessoa("E", "Emanuel", 18));
        grafo.adicionarPessoa(new Pessoa("F", "Felipe", 27));
        grafo.adicionarPessoa(new Pessoa("G", "Guilherme", 23));

        grafo.adicionarAresta("A", "B", 0.8);
        grafo.adicionarAresta("B", "C", 0.2);
        grafo.adicionarAresta("A", "D", 0.3);
        grafo.adicionarAresta("D", "E", 0.7);
        grafo.adicionarAresta("E", "F", 0.5);
        grafo.adicionarAresta("D", "G", 0.9);

        System.out.println("Influência de Alisson: " + grafo.calcularInfluencia("A"));

    }

}
