package main.java.com.joao.RedeSocial;

import java.util.Objects;

public class Pessoa {

    private int id;
    private String nome;
    private int idade;

    public Pessoa(int id, String nome, int idade){
        this.id = id;
        this.nome = nome;
        this.idade = idade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
        if (!(o instanceof Pessoa noPessoa)) return false;
        return id == noPessoa.id && idade == noPessoa.idade && Objects.equals(nome, noPessoa.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, idade);
    }

    @Override
    public String toString() {
        return "NoPessoa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", idade=" + idade +
                '}';
    }
}
