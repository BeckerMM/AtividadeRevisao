package banco;
import pessoa.Pessoa;
import java.util.ArrayList;
public class Banco {
    private String nome;
    private String endereço;
    private int agencia;
    private ArrayList<Pessoa> clientes;
    private double juros;
    private double taxaDeServico;

    public Banco(String nome, String endereço, int agencia, ArrayList<Pessoa> clientes, double juros, double taxaDeServico) {
        this.nome = nome;
        this.endereço = endereço;
        this.agencia = agencia;
        this.clientes = clientes;
        this.juros = juros;
        this.taxaDeServico = taxaDeServico;
    }

    public void cadastrarConta(){


    }
}
