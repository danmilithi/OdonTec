package odontec;

public class Fornecedor {
    private int id;
    private String nome;
    private String telefone;
    private String produto;

    public Fornecedor(int id, String nome, String telefone, String produto) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.produto = produto;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getProduto() {
        return produto;
    }
}
