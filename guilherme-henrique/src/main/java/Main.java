import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import controller.FuncionarioController;
import model.Funcionario;
import view.FuncionarioView;

public class Main {
    public static void main(String[] args) {
        FuncionarioController controller = new FuncionarioController();
        FuncionarioView view = new FuncionarioView();

        // Adicionar funcionários
        controller.adicionarFuncionario(
                new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"));
        controller.adicionarFuncionario(
                new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"));
        controller.adicionarFuncionario(
                new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador"));
        controller.adicionarFuncionario(
                new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"));
        controller.adicionarFuncionario(
                new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista"));
        controller.adicionarFuncionario(
                new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"));
        controller.adicionarFuncionario(
                new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"));
        controller.adicionarFuncionario(
                new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"));
        controller.adicionarFuncionario(
                new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista"));
        controller.adicionarFuncionario(
                new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente"));
        // Remover funcionário "João"
        controller.removerFuncionario("João");

        // Imprimir todos os funcionários
        view.imprimirFuncionarios(controller.obterFuncionarios());

        // Aumentar salários em 10%
        controller.aumentarSalarios(new BigDecimal("10"));

        // Agrupar por função e imprimir
        Map<String, List<Funcionario>> funcionariosPorFuncao = controller.agruparPorFuncao();
        view.imprimirAgrupadosPorFuncao(funcionariosPorFuncao);

        // Imprimir aniversariantes do mês 10
        List<Funcionario> aniversariantesMes10 = controller.aniversariantesMes(10);
        view.imprimirAniversariantes(aniversariantesMes10);

        // Imprimir aniversariantes do mês 12
        List<Funcionario> aniversariantesMes12 = controller.aniversariantesMes(12);
        view.imprimirAniversariantes(aniversariantesMes12);

        // Imprimir funcionário mais velho
        Funcionario maisVelho = controller.funcionarioMaiorIdade();
        view.imprimirMaiorIdade(maisVelho);

        // Imprimir lista ordenada por nome
        List<Funcionario> funcionariosOrdenados = controller.ordenarPorNome();
        view.imprimirOrdenadosPorNome(funcionariosOrdenados);

        // Imprimir total dos salários
        BigDecimal totalSalarios = controller.calcularTotalSalarios();
        view.imprimirTotalSalarios(totalSalarios);

        // Imprimir salários em salários mínimos
        BigDecimal salarioMinimo = new BigDecimal("1212.00");
        Map<String, BigDecimal> salariosEmSalariosMinimos = controller.calcularSalariosEmSalariosMinimos(salarioMinimo);
        view.imprimirSalariosEmSalariosMinimos(salariosEmSalariosMinimos);
    }
}
