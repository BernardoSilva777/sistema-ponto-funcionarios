import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

public class RegistroPontoDAO {

    public void salvarEntrada(String cpf, String nome, LocalDate data, LocalTime horaEntrada) {

        String sql = "INSERT INTO registro_ponto (cpf, nome, data, hora_entrada) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cpf);
            stmt.setString(2, nome);
            stmt.setDate(3, java.sql.Date.valueOf(data));
            stmt.setTime(4, java.sql.Time.valueOf(horaEntrada));

            stmt.executeUpdate();
            System.out.println("Entrada salva no banco!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void salvarSaida(String cpf, LocalDate data, LocalTime horaSaida, double totalHoras) {

        String sql = "UPDATE registro_ponto " +
                "SET hora_saida = ?, total_horas = ? " +
                "WHERE cpf = ? AND data = ? AND hora_saida IS NULL";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setTime(1, java.sql.Time.valueOf(horaSaida));
            stmt.setDouble(2, totalHoras);
            stmt.setString(3, cpf);
            stmt.setDate(4, java.sql.Date.valueOf(data));

            stmt.executeUpdate();
            System.out.println("Saída salva no banco!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


