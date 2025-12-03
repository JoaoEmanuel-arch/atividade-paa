package main.java.com.joao.RedeSocial;

import java.util.Objects;

public class Par {

    private String origem;
    private String destino;

    public Par(String origem, String destino) {
        this.origem = origem;
        this.destino = destino;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Par par)) return false;
        return Objects.equals(origem, par.origem) && Objects.equals(destino, par.destino);
    }

    @Override
    public int hashCode() {
        return Objects.hash(origem, destino);
    }

    @Override
    public String toString() {
        return "Par{" +
                "origem='" + origem + '\'' +
                ", destino='" + destino + '\'' +
                '}';
    }
}
