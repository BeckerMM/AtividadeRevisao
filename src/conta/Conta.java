package conta;

import pessoa.Pessoa;

public class Conta {

    private int numero;
    private double saldo;
    private int qtdTransacoes;
    private Pessoa titular;

    public Conta(int numero, double saldo, int qtdTransacoes, Pessoa titular) {
        this.numero = numero;
        this.saldo = saldo;
        this.qtdTransacoes = qtdTransacoes;
        this.titular = titular;
    }

    public void pagamento(double pagamento) {
        if
        this.saldo -= pagamento;
    }

    public void credito(){


    }

    public double saldo(){
        return this.saldo;
    }
}
