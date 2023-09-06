package conta;

import conta.Conta;
import pessoa.Pessoa;

public class Corrente extends Conta {
    private double limite;

    public Corrente(int numero, double saldo, int qtdTransacoes, Pessoa titular, double limite) {
        super(numero, saldo, qtdTransacoes, titular);
        this.limite = limite;
    }

    public void saque (){

    }

    public void transferencia(){

    }
}
