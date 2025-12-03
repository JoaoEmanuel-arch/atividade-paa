package main.java.com.joao.RedeSocial;

public class Grafo2Teste {

    public static void main(String[] args){

        Grafo grafo = new Grafo();

        // GRAFO 2 - Duas comunidades com ligações fracas
        grafo.adicionarPessoa(new Pessoa("A", "Ana", 21));
        grafo.adicionarPessoa(new Pessoa("B", "Beatriz", 22));
        grafo.adicionarPessoa(new Pessoa("C", "Caio", 24));
        grafo.adicionarPessoa(new Pessoa("D", "Davi", 26));
        grafo.adicionarPessoa(new Pessoa("E", "Eduarda", 20));
        grafo.adicionarPessoa(new Pessoa("F", "Fabio", 23));
        grafo.adicionarPessoa(new Pessoa("G", "Gabriela", 25));
        grafo.adicionarPessoa(new Pessoa("H", "Hugo", 27));

        // Comunidade 1
        grafo.adicionarAresta("A","B",0.91);
        grafo.adicionarAresta("B","C",0.85);
        grafo.adicionarAresta("C","D",0.78);
        grafo.adicionarAresta("A","C",0.66);
        grafo.adicionarAresta("B","D",0.44);

        // Comunidade 2
        grafo.adicionarAresta("E","F",0.87);
        grafo.adicionarAresta("F","G",0.93);
        grafo.adicionarAresta("G","H",0.82);
        grafo.adicionarAresta("E","G",0.59);
        grafo.adicionarAresta("F","H",0.48);

        // Ligações fracas entre comunidades
        grafo.adicionarAresta("C","F",0.22);
        grafo.adicionarAresta("B","E",0.17);
        grafo.adicionarAresta("D","G",0.12);
        grafo.adicionarAresta("A","E",0.10);
        grafo.adicionarAresta("H","D",0.33);
        grafo.adicionarAresta("G","B",0.27);
        grafo.adicionarAresta("F","A",0.19);
        grafo.adicionarAresta("E","C",0.15);

        System.out.println("INFLUÊNCIA DE TODAS AS PESSOAS NA REDE SOCIAL:");
        System.out.println("Influência da Ana: " + String.format("%.2f", grafo.calcularInfluencia("A")));
        System.out.println("Influência da Beatriz: " + String.format("%.2f", grafo.calcularInfluencia("B")));
        System.out.println("Influência do Caio: " + String.format("%.2f", grafo.calcularInfluencia("C")));
        System.out.println("Influência do Davi: " + String.format("%.2f", grafo.calcularInfluencia("D")));
        System.out.println("Influência da Eduarda: " + String.format("%.2f", grafo.calcularInfluencia("E")));
        System.out.println("Influência do Fabio: " + String.format("%.2f", grafo.calcularInfluencia("F")));
        System.out.println("Influência da Gabriela: " + String.format("%.2f", grafo.calcularInfluencia("G")));
        System.out.println("Influência do Hugo: " + String.format("%.2f", grafo.calcularInfluencia("H")));

        System.out.println("--------------------------------------------------------------------");
        System.out.println("PESSOA MENOS INFLUENCIÁVEL NA REDE SOCIAL: " + grafo.menosInfluenciavel());

        System.out.println("--------------------------------------------------------------------");
        System.out.println("TOP 3 PESSOAS MAIS INFLUENTES DA REDES SOCIAL: ");
        for(String nome : grafo.top3MaisInfluentes()){
            System.out.println(nome);
        }

    }

}

