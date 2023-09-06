package conta;

import conta.Conta;
import pessoa.Pessoa;

public class Poupanca extends Conta {

    public Poupanca( Pessoa titular, String senha) {
        super( titular, senha);
    }

    public void saque(double valor){
    this.setSaldo(this.saldo()-valor);
    }

}
