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
        grafo.adicionarPessoa(new Pessoa("H", "Henrique", 17));

        grafo.adicionarAresta("A", "B", 0.80);
        grafo.adicionarAresta("A", "G", 0.50);
        grafo.adicionarAresta("A", "F", 0.08);
        grafo.adicionarAresta("B", "C", 0.72);
        grafo.adicionarAresta("C", "D", 0.68);
        grafo.adicionarAresta("C", "G", 0.86);
        grafo.adicionarAresta("E", "A", 0.91);
        grafo.adicionarAresta("E", "B", 0.70);
        grafo.adicionarAresta("E", "F", 0.83);
        grafo.adicionarAresta("E", "H", 0.16);
        grafo.adicionarAresta("F", "C", 0.62);
        grafo.adicionarAresta("F", "G", 0.58);
        grafo.adicionarAresta("F", "H", 0.30);
        grafo.adicionarAresta("G", "D", 0.90);
        grafo.adicionarAresta("G", "H", 0.40);
        grafo.adicionarAresta("H", "D", 0.20);

        System.out.println("INFLUÊNCIA DE TODAS AS PESSOAS NA REDE SOCIAL:");
        System.out.println("Influência do Alisson: " + grafo.calcularInfluencia("A"));
        System.out.println("Influência do Bruno: " + grafo.calcularInfluencia("B"));
        System.out.println("Influência do Carlos: " + grafo.calcularInfluencia("C"));
        System.out.println("Influência do Daniel: " + grafo.calcularInfluencia("D"));
        System.out.println("Influência do Emanuel: " + grafo.calcularInfluencia("E"));
        System.out.println("Influência do Felipe: " + grafo.calcularInfluencia("F"));
        System.out.println("Influência do Guilherme: " + grafo.calcularInfluencia("G"));
        System.out.println("Influência do Henrique: " + grafo.calcularInfluencia("H"));

        System.out.println("--------------------------------------------------------------------");
        System.out.println("PESSOA MENOS INFLUENCIÁVEL NA REDE SOCIAL: " + grafo.menosInfluenciavel());

        System.out.println("--------------------------------------------------------------------");
        System.out.println("TOP 3 PESSOAS MAIS INFLUENTES DA REDE SOCIAL: ");
        for(String nome : grafo.top3MaisInfluentes()){
            System.out.println(nome);
        }

    }

}
