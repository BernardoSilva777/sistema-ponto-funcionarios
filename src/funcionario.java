import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class funcionario {

    private String nome;
    private String cpf;
    private LocalDateTime entrada;
    private LocalDateTime saida;

    public funcionario(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public void registrarEntrada() {
        entrada = LocalDateTime.now();
        saida = null; // importante: limpa saída quando entra
        System.out.println("Entrada registrada para " + nome + " às " + entrada);
    }

    public void registrarSaida() {
        saida = LocalDateTime.now();
        System.out.println("Saída registrada para " + nome + " às " + saida);
    }

    // ===== REGRAS =====

    public boolean temEntradaSemSaida() {
        return entrada != null && saida == null;
    }

    public boolean naoTemEntrada() {
        return entrada == null;
    }

    // ===== DADOS PARA O BANCO =====

    public LocalDate getData() {
        if (entrada != null) return entrada.toLocalDate();
        return LocalDate.now();
    }

    public LocalTime getHoraEntrada() {
        if (entrada != null) return entrada.toLocalTime();
        return null;
    }

    public LocalTime getHoraSaida() {
        if (saida != null) return saida.toLocalTime();
        return null;
    }

    public double getTotalHoras() {
        if (entrada != null && saida != null) {
            long minutos = Duration.between(entrada, saida).toMinutes();
            return minutos / 60.0;
        }
        return 0;
    }

    // ===== GETTERS =====

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    @Override
    public String toString() {
        return nome + " | CPF: " + cpf + " | Entrada: " + entrada + " | Saída: " + saida;
    }
}
