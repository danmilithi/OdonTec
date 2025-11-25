package odontec;

public class Usuario {
    private int id;
    private String login;
    private String senha;
    private TipoUsuario tipoUsuario;

    public Usuario(int id, String login, String senha, TipoUsuario tipoUsuario) {
        this.id = id;
        this.login = login;
        this.senha = senha;
        this.tipoUsuario = tipoUsuario;
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }
}
