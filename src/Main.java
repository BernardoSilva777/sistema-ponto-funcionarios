import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        adm admin = new adm("admin", "1234");

        funcionario f1 = new funcionario("bernardo", "19593659757");
        admin.adicionarFuncionario(f1); // já pre-cadastrado

        System.out.println("Digite o login :");
        String login = sc.next();

        System.out.println("Digite a senha :");
        String senha = sc.next();

        if (admin.getLogin().equals(login) && admin.getSenha().equals(senha)) {
            System.out.println("Login realizado com sucesso!");
            mostrarMenu(admin, sc);
        } else {
            System.out.println("Login ou senha incorretos!");
        }

        sc.close();
    }

    public static void mostrarMenu(adm admin, Scanner sc) {
        int opcao;

        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1 - Cadastrar funcionário");
            System.out.println("2 - Registrar entrada");
            System.out.println("3 - Registrar saída");
            System.out.println("4 - Listar funcionários");
            System.out.println("5 - Sair");

            System.out.print("Escolha uma opção: ");
            while (!sc.hasNextInt()) {
                System.out.print("Por favor, digite um número válido: ");
                sc.next();
            }
            opcao = sc.nextInt();
            sc.nextLine(); // limpar o buffer

            switch (opcao) {
                case 1:
                    System.out.print("Nome do funcionário: ");
                    String nome = sc.nextLine();
                    System.out.print("CPF: ");
                    String cpf = sc.nextLine();
                    funcionario novoFunc = new funcionario(nome, cpf);
                    admin.adicionarFuncionario(novoFunc);
                    break;

                case 2:
                    System.out.print("CPF do funcionário para registrar entrada: ");
                    cpf = sc.nextLine();
                    funcionario fEntrada = admin.buscarFuncionario(cpf);
                    if (fEntrada != null) {
                        fEntrada.registrarEntrada();
                    } else {
                        System.out.println("Funcionário não encontrado.");
                    }
                    break;

                case 3:
                    System.out.print("CPF do funcionário para registrar saída: ");
                    cpf = sc.nextLine();
                    funcionario fSaida = admin.buscarFuncionario(cpf);
                    if (fSaida != null) {
                        fSaida.registrarSaida();
                    } else {
                        System.out.println("Funcionário não encontrado.");
                    }
                    break;

                case 4:
                    admin.listarFuncionarios();
                    break;

                case 5:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 5);
    }
}
