package odontec;
import java.time.LocalDate;
class Paciente {
     private int id;
    private String nome;
    private String telefone;
    private String dataNascimento;
    private String cep;

    public Paciente(int id, String nome, String telefone, String dataNascimento, String cep) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.cep = cep;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getTelefone() { return telefone; }
    public String getDataNascimento() { return dataNascimento; }
    public String getCep() { return cep; }
}
