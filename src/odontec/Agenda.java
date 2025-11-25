package odontec;

public class Agenda {
    private int id;
    private String paciente;
    private String dentista;
    private String data;
    private String hora;
    private String tratamento;

    public Agenda(int id, String paciente, String dentista, String data, String hora, String tratamento) {
        this.id = id;
        this.paciente = paciente;
        this.dentista = dentista;
        this.data = data;
        this.hora = hora;
        this.tratamento = tratamento;
    }

    public int getId() { return id; }
    public String getPaciente() { return paciente; }
    public String getDentista() { return dentista; }
    public String getData() { return data; }
    public String getHora() { return hora; }
    public String getTratamento() { return tratamento; }
}
