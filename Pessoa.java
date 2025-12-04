package main.java.com.joao.RedeSocial;

import java.util.Objects;

public class Pessoa {

    private String id;
    private String nome;
    private int idade;

    public Pessoa(String id, String nome, int idade){
        this.id = id;
        this.nome = nome;
        this.idade = idade;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Pessoa pessoa)) return false;
        return idade == pessoa.idade && Objects.equals(id, pessoa.id) && Objects.equals(nome, pessoa.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, idade);
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id='" + id + '\'' +
                ", nome='" + nome + '\'' +
                ", idade=" + idade +
                '}';
    }
}
