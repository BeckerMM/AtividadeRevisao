import banco.Banco;
import conta.Conta;
import conta.Corrente;
import conta.Credito;
import conta.Poupanca;
import pessoa.Fisica;
import pessoa.Juridica;
import pessoa.Pessoa;

import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static Banco banco = new Banco("Banco1", "Rua 1", 123, null, 10, 5);
    private static Conta contaLogada;
    private static int dia;

    public static void main(String[] args) {
        while(menuInicial());
    }

    private static Boolean menuInicial() {
        int decisao;
        do {
            System.out.println("""
                    ==========Menu Incial==========
                    1- Login
                    2- Registrar
                    3- Logout""");
            decisao = sc.nextInt();
            switch (decisao) {
                case 1 -> login();
                case 2 -> registrar();
                case 3 -> System.exit(0);
            }
        } while (decisao != 3);
        return true;
    }

    private static void login() {
        int cont = 0;
        int numeroDaConta;
        String senha;
        do {
            System.out.println("Digite o número da conta:");
            numeroDaConta = sc.nextInt();
            Conta conta = banco.verificarConta(numeroDaConta);
            if (conta != null ){
                System.out.println("Digite sua senha:");
                senha = sc.next();
                contaLogada = conta.verificarSenha(senha);
                System.out.println(contaLogada);
            }
            cont++;
        } while (contaLogada==null || cont < 3);
        if (contaLogada !=null){
            telaDaConta();
        }
    }

    private static void telaDaConta() {
        int decisao;
        System.out.println("""
                ====== BEM VINDO =====
                1- Pagamento
                2- crédito
                3- Ver saldo
                4- sair
                5- Passar dias
                """);
                if ( contaLogada instanceof Corrente){
                    System.out.println("""
                            6- Saque
                            7- Trasferência
                            """);
                }
                decisao = sc. nextInt();
                switch (decisao){
                    case 1 -> {
                        System.out.println("Valor do pagamento:");
                        double pagamento = sc.nextDouble();
                        contaLogada.pagamento(pagamento);
                    }
                    case 2 ->{
                        System.out.println("Valor do crédito:");
                        double credito = sc.nextDouble();
                        contaLogada.credito(credito);
                    }
                    case 3 -> System.out.println(contaLogada.saldo());
                    case 4-> {
                        return;
                    }
//                    case 5 -> passarDias();
                    case 6 ->{
                        if (contaLogada instanceof Corrente){
                            System.out.println("Valor do saque:");
                            double saque = sc.nextDouble();
                            ((Corrente) contaLogada).saque(saque);
                        }
                    }
                    case 7 ->{
                        if (contaLogada instanceof Corrente){
                            System.out.println("Informe o número da conta para efetuar a transferência:");
                            int numero = sc.nextInt();
                            System.out.println("Valor da transferência");
                            double valor = sc.nextDouble();
                            if (!((Corrente) contaLogada).transferencia(banco.verificarConta(numero),valor)){
                                System.out.println("Número da conta inválido");
                            }
                        }
                    }
                }
    }

    private static Pessoa registrarPessoa() {
        int decisao;
        System.out.println("""
                ===== Registrar Pessoa =====
                1- Física
                2- Jurídica
                3- Sair""");
        decisao = sc.nextInt();
        switch (decisao) {
            case 1 -> {
                System.out.println("Digite seu endereço:");
                String endereco = sc.next();
                return pessoaFisica(endereco);
            }
            case 2 -> {
                System.out.println("Digite seu endereço:");
                String endereco = sc.next();
                return pessoaJuridica(endereco);
            }
            case 3 -> {
                return null;
            }
            default -> System.out.println("Valor inválido!");
        }
        return null;
    }

    private static Pessoa pessoaFisica(String endereco) {
        System.out.println("Digite seu nome completo:");
        String nomeCompleto = sc.next();
        System.out.println("Digite seu CPF:");
        long cpf = sc.nextLong();
        return new Fisica(endereco, cpf, nomeCompleto);
    }

    private static Pessoa pessoaJuridica(String endereco) {
        System.out.println("Digite sua razão social:");
        String razaoSocial = sc.next();
        System.out.println("Digite seu CNPJ");
        long cnpj = sc.nextLong();
        return new Juridica(endereco, cnpj, razaoSocial);
    }

    private static void registrar() {
        Pessoa titular = registrarPessoa();
        Conta conta = registrarConta(titular);
        if (conta != null) {
            banco.cadastrarConta(conta);
        }
    }

    private static Conta registrarConta(Pessoa titular) {
        int decisao;
        String senha = null;
        double limite = 0;
        System.out.println("""
                ======= Bem Vindo =======
                1- Corrente
                2- Credito
                3- Poupanca
                4- Sair
                """);
        decisao = sc.nextInt();
        if (decisao >= 1 && decisao <= 3) {
            System.out.println("Digite a senha: ");
            senha = sc.next();
            if (decisao == 1 || decisao == 3) {
                System.out.println("Defina o limite:");
                limite = sc.nextDouble();
            }
        }
        switch (decisao) {
            case 1 -> {
                return new Corrente(titular, limite, senha);
            }
            case 2 -> {
                System.out.println("Escolha o dia de vencimento da fatura:");
                int diaDaFatura = sc.nextInt();
                return new Credito(titular, diaDaFatura, limite, senha);
            }
            case 3 -> {
                return new Poupanca(titular, senha);
            }
        }
        return null;
    }
}
