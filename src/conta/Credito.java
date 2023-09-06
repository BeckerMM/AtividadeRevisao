package conta;

import conta.Conta;
import pessoa.Pessoa;

public class Credito extends Conta {
    private int diaDaFatura;

    private double limite;

    public Credito( Pessoa titular, int diaDaFatura, double limite,String senha) {
        super( titular,senha);
        this.diaDaFatura = diaDaFatura;
        this.limite = limite;
    }
}
