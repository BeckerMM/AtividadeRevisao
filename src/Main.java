import banco.Banco;

import java.util.Scanner;

public class Main {
   private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
    }

    public void menuInicial() {
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
    }
}
