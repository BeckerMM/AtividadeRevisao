package banco;

import conta.Conta;
import pessoa.Pessoa;

import java.util.ArrayList;

public class Banco {
    private String nome;
    private String endereço;
    private int agencia;
    private ArrayList<Conta> contas = new ArrayList<>();
    private double juros;
    private double taxaDeServico;

    public Banco(String nome, String endereço, int agencia, ArrayList<Pessoa> clientes, double juros, double taxaDeServico) {
        this.nome = nome;
        this.endereço = endereço;
        this.agencia = agencia;
        this.juros = juros;
        this.taxaDeServico = taxaDeServico;
    }

    public void cadastrarConta(Conta conta) {
        this.contas.add(conta);

    }
    
    public Conta verificarConta( int numero){
        for (Conta conta:contas) {
            if (conta.getNumero() == numero){
                return conta;
            }
        }
        return null;
    }
}
