package view;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import model.Funcionario;

public class FuncionarioView {

    public void imprimirFuncionarios(List<Funcionario> funcionarios) {
        funcionarios.forEach(System.out::println);
    }

    public void imprimirAgrupadosPorFuncao(Map<String, List<Funcionario>> funcionariosPorFuncao) {
        funcionariosPorFuncao.forEach((funcao, lista) -> {
            System.out.println("Funcionários na função de " + funcao + ":");
            lista.forEach(System.out::println);
            System.out.println();
        });
    }

    public void imprimirAniversariantes(List<Funcionario> aniversariantes) {
        System.out.println("Aniversariantes:");
        aniversariantes.forEach(System.out::println);
        System.out.println();
    }

    public void imprimirMaiorIdade(Funcionario funcionario) {
        LocalDate dataNascimento = funcionario.getDataNascimento();
        long anos = dataNascimento.until(LocalDate.now()).getYears();

        System.out.println("Funcionário mais velho: " + funcionario.getNome() + ", Idade: " + anos + " anos");
    }

    public void imprimirOrdenadosPorNome(List<Funcionario> funcionariosOrdenados) {
        funcionariosOrdenados.forEach(System.out::println);
    }

    public void imprimirTotalSalarios(BigDecimal totalSalarios) {
        System.out.println("Total dos salários: " + totalSalarios);
    }

    public void imprimirSalariosEmSalariosMinimos(Map<String, BigDecimal> salariosEmSalariosMinimos) {
        salariosEmSalariosMinimos.forEach((nome, salariosMinimos) ->
                System.out.println(nome + " ganha " + salariosMinimos + "x salários mínimos."));
    }
}


