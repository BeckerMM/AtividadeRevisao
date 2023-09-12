package conta;

import pessoa.Pessoa;

public class Conta {

    private int numero;
    private double saldo;
    private int qtdTransacoes;
    private Pessoa titular;
    private String senha;

    private static int contador = 0;

    public Conta(Pessoa titular, String senha) {
        this.numero = contador;
        this.saldo = 0;
        this.qtdTransacoes = 0;
        this.titular = titular;
        this.senha = senha;
        contador++;
    }

    public String pagamento(double pagamento) {
        if (this.saldo >= pagamento) {
            this.saldo -= pagamento;
            this.qtdTransacoes ++;
            return "Pagamento realizado com sucesso";
        } else {
            return "Saldo insuficiente";
        }
    }

    public Conta verificarSenha(String senha){
        if (this.senha.equals(senha)){
            return this;
        }else {
            return null;
        }
    }
    public void credito(double valor) {
        this.saldo += valor;
        this.qtdTransacoes ++;
    }

    public double saldo() {
        return this.saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
        this.qtdTransacoes ++;
    }

    public int getNumero() {
        return numero;
    }

    public String getSenha() {
        return senha;
    }

    public Pessoa getTitular() {
        return titular;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "numero=" + numero +
                ", saldo=" + saldo +
                ", qtdTransacoes=" + qtdTransacoes +
                ", titular=" + titular +
                ", senha='" + senha + '\'' +
                '}';
    }
}
