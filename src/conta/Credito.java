package conta;

import conta.Conta;
import pessoa.Pessoa;

public class Credito extends Conta {
    private int diaDaFatura;

    private double limite;

    public Credito(int numero, double saldo, int qtdTransacoes, Pessoa titular, int diaDaFatura, double limite) {
        super(numero, saldo, qtdTransacoes, titular);
        this.diaDaFatura = diaDaFatura;
        this.limite = limite;
    }
}
