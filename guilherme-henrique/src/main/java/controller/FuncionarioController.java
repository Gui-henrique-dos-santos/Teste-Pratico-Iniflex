package controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import model.Funcionario;

public class FuncionarioController {
    private List<Funcionario> funcionarios;

    public FuncionarioController() {
        this.funcionarios = new ArrayList<>();
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        this.funcionarios.add(funcionario);
    }

    public void removerFuncionario(String nome) {
        this.funcionarios.removeIf(funcionario -> funcionario.getNome().equals(nome));
    }

    public List<Funcionario> obterFuncionarios() {
        return Collections.unmodifiableList(this.funcionarios);
    }

    public void aumentarSalarios(BigDecimal percentual) {
        this.funcionarios.forEach(funcionario -> funcionario.aumentarSalario(percentual));
    }

    public Map<String, List<Funcionario>> agruparPorFuncao() {
        return this.funcionarios.stream().collect(Collectors.groupingBy(Funcionario::getFuncao));
    }

    public List<Funcionario> aniversariantesMes(int mes) {
        return this.funcionarios.stream()
                .filter(funcionario -> funcionario.getDataNascimento().getMonthValue() == mes)
                .collect(Collectors.toList());
    }

    public Funcionario funcionarioMaiorIdade() {
        return Collections.max(funcionarios, Comparator.comparing(funcionario ->
                funcionario.getDataNascimento().until(LocalDate.now()).getDays()));
    }

    public List<Funcionario> ordenarPorNome() {
        return this.funcionarios.stream()
                .sorted(Comparator.comparing(Funcionario::getNome))
                .collect(Collectors.toList());
    }

    public BigDecimal calcularTotalSalarios() {
        return this.funcionarios.stream()
                .map(Funcionario::getSalario)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public Map<String, BigDecimal> calcularSalariosEmSalariosMinimos(BigDecimal salarioMinimo) {
        return this.funcionarios.stream()
                .collect(Collectors.toMap(Funcionario::getNome, funcionario -> funcionario.getSalarioEmSalariosMinimos(salarioMinimo)));
    }
}

