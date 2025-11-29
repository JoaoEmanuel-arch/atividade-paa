package main.java.com.joao.RedeSocial;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Grafo {

    private Map<Integer, Pessoa> pessoas = new HashMap<>(); // guarda todas as pessoas da rede social (id -> pessoa)
    private Map<Par, Double> matrizEsparsa = new HashMap<>(); // guarda todas as conexões existentes entre as pessoas da rede social

    public void adicionaPessoa(Pessoa pessoa) {
        pessoas.put(pessoa.getId(), pessoa);
    }

    public void adicionarAresta(String origem, String destino, double peso) { // adicionar a conexão na matriz, a chave é a conexão
        Par chave = new Par(origem, destino);
        matrizEsparsa.put(chave, peso);
    }

    public Double getPeso(String origem, String destino) { // passo os vértices da aresta e me retorna o peso
        return matrizEsparsa.get(new Par(origem, destino)); // o metodo get do map busca o valor dentro do map pela chave. Aqui a chave é um objeto (origem, destino)
    }

    public List<String> getVizinhosRaio1(String origem) { // retorna os vizinhos do vértice com raio 1
        List<String> vizinhosRaio1 = new ArrayList<>();

        for (Par chave : matrizEsparsa.keySet()) { // percorre a matriz e vai salvando cada conexão (Par, peso)
            if (chave.getOrigem().equals(origem)) { // string não pode ser comparada com ==, tem que usar o equals da classe String
                vizinhosRaio1.add(chave.getDestino()); // com base na origem, eu pego o vértice adjacente
            }
        }
        return vizinhosRaio1;
    }

    public List<String> getVizinhosRaio2(String origem) { // retorna os vizinhos do vértice com raio 2
        List<String> vizinhosRaio2 = new ArrayList<>();

        // eu vou percorrer a lista de vizinhos com raio 1 e para cada vizinho da origem (sqc) eu vou ver quem são os seus vizinhos
        for (String sqc : getVizinhosRaio1(origem)) {
            vizinhosRaio2.addAll(getVizinhosRaio1(sqc)); // adiciono à coleção a lista de vizinhos do vizinho da origem
        }
        return vizinhosRaio2;
    }

    // NÃO PRECISAVA DESSA FUNÇÃO
    public double calcularInfluenciaEspecifica(String origem, String destino) {

        // Calcula a influência direta (A -> B)
        for (String b : getVizinhosRaio1(origem)) { //
            if (b.equals(destino)) { // aqui o b é o próprio destino
                return getPeso(origem, b);
            }
        }

        // Influência indireta (A -> B -> C)
        for (String b : getVizinhosRaio1(origem)) { // b é o intermediário, lista dos vizinhos de A
            for (String c : getVizinhosRaio1(b)) { // c é possível destino, vizinhos do intermediário
                if (c.equals(destino)) { // se o destino da aresta analisada for igual a que eu quero descobrir, eu achei a conexão
                    Double p1 = getPeso(origem, b); // A -> B
                    Double p2 = getPeso(b, destino); // B -> destino
                    if(p1 != null && p2 != null){
                        return p1 * p2; // influência indireta
                    }
                }
            }
        }
        return 0.0; // não alcança o destino
    }

    public double calcularInfluencia(String origem) {
        double influencia = 0.0;

        for (String b : getVizinhosRaio1(origem)) { // lista de vizinhos da origem (intermediários), o intermediário pode ser o fim da conexão
            double p1 = getPeso(origem, b);
            influencia += p1; // influência para vizinhos diretos

            for (String c : getVizinhosRaio2(origem)) { // lista de vizinhos com raio 2, cada um salvando em c no for
                Double p2 = getPeso(b, c); // tem que ser o peso do vértice b do primeiro for
                if(p2 != null){
                    influencia += p1 * p2; // basicamente se existir a conexão, houver peso na aresta ;
                }
            }
        }
        return influencia;
    }

}
