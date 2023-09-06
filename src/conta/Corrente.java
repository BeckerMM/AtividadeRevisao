package conta;

import conta.Conta;
import pessoa.Pessoa;

public class Corrente extends Conta {
    private double limite;

    public Corrente(Pessoa titular, double limite, String senha) {
        super(titular,senha);
        this.limite = limite;
    }

    public void saque (double valor){
        if(!(this.saldo() - valor <0 - this.limite)){
            this.setSaldo(this.saldo()-valor);
        }
    }

    public Boolean transferencia(Conta contaParaReceber, double valor){
        if(!(this.saldo() - valor <0 - this.limite)) {
            this.setSaldo(this.saldo() - valor);
            contaParaReceber.setSaldo(this.saldo() + valor);
            return true;
        }
        return false;
    }
}
