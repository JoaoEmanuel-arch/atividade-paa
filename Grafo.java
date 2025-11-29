package main.java.com.joao.RedeSocial;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Grafo {

    private Map<Integer, Pessoa> pessoas = new HashMap<>(); // guarda todas as pessoas da rede social (id -> pessoa)
    private Map<Par, Double> matrizEsparsa = new HashMap<>(); // guarda todas as conexões existentes entre as pessoas da rede social

    public void adicionaPessoa(Pessoa pessoa){
        pessoas.put(pessoa.getId(), pessoa);
    }

    public void adicionarAresta(String origem, String destino, double peso){ // adicionar a conexão na matriz, a chave é a conexão
        Par chave = new Par(origem, destino);
        matrizEsparsa.put(chave, peso);
    }

    public Double getPeso(String origem, String destino){ // passo os vértices da aresta e me retorna o peso
        return matrizEsparsa.get(new Par(origem, destino)); // o metodo get do map busca o valor dentro do map pela chave. Aqui a chave é um objeto (origem, destino)
    }

    public List<String> getVizinhosRaio1(String origem){ // retorna os vizinhos do vértice com raio 1
        List<String> vizinhosRaio1 = new ArrayList<>();

        for(Par chave : matrizEsparsa.keySet()){ // percorre a matriz e vai salvando cada conexão (Par, peso)
            if(chave.getOrigem().equals(origem)){ // string não pode ser comparada com ==, tem que usar o equals da classe String
                vizinhosRaio1.add(chave.getDestino()); // com base na origem, eu pego o vértice adjacente
            }
        }
        return vizinhosRaio1;
    }

    public List<String> getVizinhosRaio2(String origem){ // retorna os vizinhos do vértice com raio 2
        List<String> vizinhosRaio2 = new ArrayList<>();

        // eu vou percorrer a lista de vizinhos com raio 1 e para cada vizinho da origem (sqc) eu vou ver quem são os seus vizinhos
        for(String sqc : getVizinhosRaio1(origem)){
            vizinhosRaio2.addAll(getVizinhosRaio1(sqc)); // adiciono à coleção a lista de vizinhos do vizinho da origem
        }
        return vizinhosRaio2;
    }

    // ESSA FUNÇÃO NÃO FAZ OQ TA PEDINDO, MAS ELA FAZ SENTIDO
    public Double calcularInfluencia(String origem, String destino){
        for(String sqc : getVizinhosRaio1(origem)){ // o sqc é cada vizinho primeiro
            if(sqc.equals(destino)){ // aqui o sqc é o próprio destino
                return getPeso(origem, sqc);
            }
        }

        for(String sqc : getVizinhosRaio2(origem)){
            if(sqc.equals(destino)){
                return getPeso(origem, sqc) * getPeso(sqc, destino);
            }
        }

        return 0.0;
    }

}
