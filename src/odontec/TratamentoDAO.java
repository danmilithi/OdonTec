package odontec;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
public class TratamentoDAO {
    // Salvar um novo tratamento
    public void salvar(Tratamento tratamento) {
        String sql = "INSERT INTO tratamento (nome_tratamento, preco, duracao) VALUES (?, ?, ?)";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, tratamento.getTratamento());
            stmt.setDouble(2, tratamento.getPreco());
            stmt.setDouble(3, tratamento.getDuracao());

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Listar todos os tratamentos
    public List<Tratamento> listarTodos() {
        List<Tratamento> lista = new ArrayList<>();
        String sql = "SELECT * FROM tratamento";

        try (Connection conn = Conexao.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Tratamento t = new Tratamento(
                        rs.getInt("id"),
                        rs.getString("nome_tratamento"),
                        rs.getDouble("preco"),
                        rs.getDouble("duracao")
                );
                lista.add(t);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    // Buscar tratamento por ID
    public Tratamento buscarPorId(int id) {
        String sql = "SELECT * FROM tratamento WHERE id = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Tratamento(
                        rs.getInt("id"),
                        rs.getString("nome_tratamento"),
                        rs.getDouble("preco"),
                        rs.getDouble("duracao")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // Atualizar tratamento
    public void atualizar(Tratamento tratamento) {
        String sql = "UPDATE tratamento SET nome_tratamento = ?, preco = ?, duracao = ? WHERE id = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, tratamento.getTratamento());
            stmt.setDouble(2, tratamento.getPreco());
            stmt.setDouble(3, tratamento.getDuracao());
            stmt.setInt(4, tratamento.getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Deletar tratamento por ID
    public void deletar(int id) {
        String sql = "DELETE FROM tratamento WHERE id = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
