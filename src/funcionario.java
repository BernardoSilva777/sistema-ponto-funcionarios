import java.time.LocalDateTime;

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
        System.out.println("Entrada registrada para " + nome + " às " + entrada);
    }

    public void registrarSaida() {
        saida = LocalDateTime.now();
        System.out.println("Saída registrada para " + nome + " às " + saida);
    }

    public String getCpf() {
        return cpf;
    }

    @Override
    public String toString() {
        return nome + " | CPF: " + cpf + " | Entrada: " + entrada + " | Saída: " + saida;
    }
}
