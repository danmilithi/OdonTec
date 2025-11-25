package odontec;
import java.time.LocalDate;
class Tratamento {
    private int id;
    private String Tratamento;
    private double preco;
    private double duracao;

    public Tratamento(int id, String Tratamento, double preco, double duracao) {
        this.id = id;
        this.Tratamento = Tratamento;
        this.preco = preco;
        this.duracao = duracao;
    }

    public int getId() {
        return id;
    }

    public String getTratamento() {
        return Tratamento;
    }

    public double getPreco() {
        return preco;
    }

    public double getDuracao() {
        return duracao;
    }

}
