import java.util.ArrayList;
import java.util.List;

public class adm {
    private String login;
    private String senha;
    private List<funcionario> funcionarios;

    public adm(String login, String senha) {
        this.login = login;
        this.senha = senha;
        this.funcionarios = new ArrayList<>();
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public void adicionarFuncionario(funcionario f) {
        funcionarios.add(f);
        System.out.println("Funcionário " + f + " cadastrado.");
    }

    public funcionario buscarFuncionario(String cpf) {
        for (funcionario f : funcionarios) {
            if (f.getCpf().equals(cpf)) {
                return f;
            }
        }
        return null;
    }

    public void listarFuncionarios() {
        if (funcionarios.isEmpty()) {
            System.out.println("Nenhum funcionário cadastrado.");
        } else {
            for (funcionario f : funcionarios) {
                System.out.println(f);
            }
        }
    }
}
