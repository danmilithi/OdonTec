package odontec;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class DentistaDAO {
    // Salvar um novo dentista
    public void salvar(Dentista dentista) {
        String sql = "INSERT INTO dentista (nome, especialidade) VALUES (?, ?)";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, dentista.getNome());
            stmt.setString(2, dentista.getEspecialidade());

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Listar todos os dentistas
    public List<Dentista> listarTodos() {
        List<Dentista> lista = new ArrayList<>();
        String sql = "SELECT * FROM dentista";

        try (Connection conn = Conexao.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Dentista d = new Dentista(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("especialidade")
                );
                lista.add(d);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    // Buscar dentista por ID
    public Dentista buscarPorId(int id) {
        String sql = "SELECT * FROM dentista WHERE id = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Dentista(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("especialidade")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // Atualizar dentista
    public void atualizar(Dentista dentista) {
        String sql = "UPDATE dentista SET nome = ?, especialidade = ? WHERE id = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, dentista.getNome());
            stmt.setString(2, dentista.getEspecialidade());
            stmt.setInt(3, dentista.getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Deletar dentista por ID
    public void deletar(int id) {
        String sql = "DELETE FROM dentista WHERE id = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
