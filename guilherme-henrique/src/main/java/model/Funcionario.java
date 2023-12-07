package model;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class Funcionario extends Pessoa {
    private BigDecimal salario;
    private String funcao;

    public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
        super(nome, dataNascimento);
        this.salario = salario;
        this.funcao = funcao;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void aumentarSalario(BigDecimal percentual) {
        this.salario = this.salario.add(this.salario.multiply(percentual.divide(BigDecimal.valueOf(100))));
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Salário: %.2f", salario);
    }

    public BigDecimal getSalarioEmSalariosMinimos(BigDecimal salarioMinimo) {
        return this.salario.divide(salarioMinimo, 2, RoundingMode.HALF_UP);
    }
}


