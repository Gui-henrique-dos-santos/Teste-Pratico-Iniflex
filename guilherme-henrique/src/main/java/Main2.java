import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import controller.FuncionarioController;
import model.Funcionario;
import view.FuncionarioView;

public class Main2 {
    public static void main(String[] args) {
        List<Funcionario> funcionarios = carregarFuncionariosPreDefinidos();

        FuncionarioController controller = new FuncionarioController(funcionarios);
        FuncionarioView view = new FuncionarioView();
        Scanner scanner = new Scanner(System.in);

        int opcao;
        do {
            System.out.println("----------- Menu -----------");
            System.out.println("1. Adicionar Funcionário");
            System.out.println("2. Remover Funcionário");
            System.out.println("3. Imprimir Funcionários");
            System.out.println("4. Aumentar Salários em 10%");
            System.out.println("5. Agrupar Funcionários por Função");
            System.out.println("6. Imprimir Aniversariantes dos Meses 10 e 12");
            System.out.println("7. Imprimir Funcionário Mais Velho");
            System.out.println("8. Imprimir Lista de Funcionários por Ordem Alfabética");
            System.out.println("9. Imprimir Total dos Salários dos Funcionários");
            System.out.println("10. Imprimir Salários em Salários Mínimos");
            System.out.println("0. Sair");
            System.out.print("Escolha a opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    adicionarFuncionario(controller, scanner);
                    break;
                case 2:
                    removerFuncionario(controller, scanner);
                    break;
                case 3:
                    view.imprimirFuncionarios(controller.obterFuncionarios());
                    break;
                case 4:
                    controller.aumentarSalarios(new BigDecimal("10"));
                    break;
                case 5:
                    view.imprimirAgrupadosPorFuncao(controller.agruparPorFuncao());
                    break;
                case 6:
                    view.imprimirAniversariantes(controller.aniversariantesMes(10));
                    view.imprimirAniversariantes(controller.aniversariantesMes(12));
                    break;
                case 7:
                    view.imprimirMaiorIdade(controller.funcionarioMaiorIdade());
                    break;
                case 8:
                    view.imprimirOrdenadosPorNome(controller.ordenarPorNome());
                    break;
                case 9:
                    view.imprimirTotalSalarios(controller.calcularTotalSalarios());
                    break;
                case 10:
                    imprimirSalariosEmSalariosMinimos(controller, scanner);
                    break;
                case 0:
                    System.out.println("Saindo do programa. Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }

    private static List<Funcionario> carregarFuncionariosPreDefinidos() {
        return Arrays.asList(
            new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"),
            new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"),
            new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador"),
            new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"),
            new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista"),
            new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"),
            new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"),
            new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"),
            new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista"),
            new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente")
        );
    }

    private static void adicionarFuncionario(FuncionarioController controller, Scanner scanner) {
        System.out.print("Digite o nome do funcionário: ");
        String nome = scanner.next();

        System.out.print("Digite a data de nascimento (no formato yyyy-mm-dd): ");
        String dataNascimentoStr = scanner.next();
        LocalDate dataNascimento = LocalDate.parse(dataNascimentoStr);

        System.out.print("Digite o salário: ");
        BigDecimal salario = scanner.nextBigDecimal();

        System.out.print("Digite a função: ");
        String funcao = scanner.next();

        controller.adicionarFuncionario(new Funcionario(nome, dataNascimento, salario, funcao));
        System.out.println("Funcionário adicionado com sucesso!");
    }

    private static void removerFuncionario(FuncionarioController controller, Scanner scanner) {
        System.out.print("Digite o nome do funcionário a ser removido: ");
        String nome = scanner.next();

        controller.removerFuncionario(nome);
        System.out.println("Funcionário removido com sucesso!");
    }

    private static void imprimirSalariosEmSalariosMinimos(FuncionarioController controller, Scanner scanner) {
        System.out.print("Digite o valor do salário mínimo: ");
        BigDecimal salarioMinimo = scanner.nextBigDecimal();

        Map<String, BigDecimal> salariosEmSalariosMinimos = controller.calcularSalariosEmSalariosMinimos(salarioMinimo);
        System.out.println("Salários em Salários Mínimos:");
        salariosEmSalariosMinimos.forEach((nome, salariosMinimos) ->
                System.out.println(nome + " ganha " + salariosMinimos + " salários mínimos."));
    }
}

