package main.java.com.joao.RedeSocial;

public class Grafo3Teste {

    public static void main(String[] args){

        Grafo grafo = new Grafo();

        // GRAFO 3 - Rede densa com pesos altos
        grafo.adicionarPessoa(new Pessoa("A", "Arthur", 29));
        grafo.adicionarPessoa(new Pessoa("B", "Bianca", 24));
        grafo.adicionarPessoa(new Pessoa("C", "Clara", 22));
        grafo.adicionarPessoa(new Pessoa("D", "Diego", 26));
        grafo.adicionarPessoa(new Pessoa("E", "Elisa", 23));
        grafo.adicionarPessoa(new Pessoa("F", "Fernando", 21));
        grafo.adicionarPessoa(new Pessoa("G", "Giovana", 25));
        grafo.adicionarPessoa(new Pessoa("H", "Helena", 28));

        grafo.adicionarAresta("A","B",0.92);
        grafo.adicionarAresta("A","C",0.88);
        grafo.adicionarAresta("A","D",0.80);

        grafo.adicionarAresta("B","E",0.95);
        grafo.adicionarAresta("B","F",0.91);
        grafo.adicionarAresta("B","G",0.89);

        grafo.adicionarAresta("C","F",0.93);
        grafo.adicionarAresta("C","H",0.82);

        grafo.adicionarAresta("D","G",0.90);
        grafo.adicionarAresta("D","H",0.84);

        grafo.adicionarAresta("E","A",0.97);
        grafo.adicionarAresta("E","C",0.94);

        grafo.adicionarAresta("F","D",0.89);
        grafo.adicionarAresta("F","H",0.78);

        grafo.adicionarAresta("G","A",0.96);
        grafo.adicionarAresta("G","E",0.87);

        grafo.adicionarAresta("H","B",0.91);
        grafo.adicionarAresta("H","F",0.76);

        System.out.println("INFLUÊNCIA DE TODAS AS PESSOAS NA REDE SOCIAL:");
        System.out.println("Influência do Arthur: " + grafo.calcularInfluencia("A"));
        System.out.println("Influência da Bianca: " + grafo.calcularInfluencia("B"));
        System.out.println("Influência da Clara: " + grafo.calcularInfluencia("C"));
        System.out.println("Influência do Diego: " + grafo.calcularInfluencia("D"));
        System.out.println("Influência da Elisa: " + grafo.calcularInfluencia("E"));
        System.out.println("Influência do Fernando: " + grafo.calcularInfluencia("F"));
        System.out.println("Influência da Giovana: " + grafo.calcularInfluencia("G"));
        System.out.println("Influência da Helena: " + grafo.calcularInfluencia("H"));

        System.out.println("--------------------------------------------------------------------");
        System.out.println("PESSOA MENOS INFLUENCIÁVEL NA REDE SOCIAL: " + grafo.menosInfluenciavel());

        System.out.println("--------------------------------------------------------------------");
        System.out.println("TOP 3 PESSOAS MAIS INFLUENTES DA REDE SOCIAL: ");
        for(String nome : grafo.top3MaisInfluentes()){
            System.out.println(nome);
        }

    }

}

