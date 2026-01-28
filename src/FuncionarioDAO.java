import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {

    public void salvar(funcionario f) {

        String sql = "INSERT INTO funcionario (nome, cpf) VALUES (?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getCpf());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<funcionario> listarTodos() {

        List<funcionario> lista = new ArrayList<>();
        String sql = "SELECT nome, cpf FROM funcionario";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                lista.add(new funcionario(nome, cpf));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
}
