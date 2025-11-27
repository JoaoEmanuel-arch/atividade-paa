package main.java.com.joao.RedeSocial;

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
    public String toString() {
        return "Par{" +
                "origem='" + origem + '\'' +
                ", destino='" + destino + '\'' +
                '}';
    }
}
