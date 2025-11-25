package odontec;

public class Produto {
    private int id;
    private String nome;
    private double preco;
    private String fornecedor;
    private int quantidade;

    public Produto(int id, String nome, double preco, String fornecedor, int quantidade) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.fornecedor = fornecedor;
        this.quantidade = quantidade;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }
    
    public String getFornecedor() {
        return fornecedor;
    }

    public int getQuantidade() {
        return quantidade;
    }
}
