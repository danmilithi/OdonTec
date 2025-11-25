package odontec;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class AgendaDAO {
    // Salvar um novo agendamento
    public void salvar(Agenda agenda) {
        String sql = "INSERT INTO agenda (paciente, dentista, data, hora, tratamento) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, agenda.getPaciente());
            stmt.setString(2, agenda.getDentista());
            stmt.setString(3, agenda.getData());
            stmt.setString(4, agenda.getHora());
            stmt.setString(5, agenda.getTratamento());

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                // Se quiser armazenar o id gerado no objeto, adicione um setter no Agenda
                // agenda.setId(rs.getInt(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Listar todos os agendamentos
    public List<Agenda> listarTodos() {
        List<Agenda> lista = new ArrayList<>();
        String sql = "SELECT * FROM agenda";

        try (Connection conn = Conexao.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Agenda a = new Agenda(
                        rs.getInt("id"),
                        rs.getString("paciente"),
                        rs.getString("dentista"),
                        rs.getString("data"),
                        rs.getString("hora"),
                        rs.getString("tratamento")
                );
                lista.add(a);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    // Buscar agendamento por ID
    public Agenda buscarPorId(int id) {
        String sql = "SELECT * FROM agenda WHERE id = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Agenda(
                        rs.getInt("id"),
                        rs.getString("paciente"),
                        rs.getString("dentista"),
                        rs.getString("data"),
                        rs.getString("hora"),
                        rs.getString("tratamento")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // Atualizar agendamento
    public void atualizar(Agenda agenda) {
        String sql = "UPDATE agenda SET paciente = ?, dentista = ?, data = ?, hora = ?, tratamento = ? WHERE id = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, agenda.getPaciente());
            stmt.setString(2, agenda.getDentista());
            stmt.setString(3, agenda.getData());
            stmt.setString(4, agenda.getHora());
            stmt.setString(5, agenda.getTratamento());
            stmt.setInt(6, agenda.getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Deletar agendamento por ID
    public void deletar(int id) {
        String sql = "DELETE FROM agenda WHERE id = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
