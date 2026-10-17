import java.util.Scanner;

public class CaixaEletronico {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double saldo = 500.00;
        int opcao;

        do {
            System.out.println("\n===== CAIXA ELETRÔNICO =====");
            System.out.println("1 - Consultar Saldo");
            System.out.println("2 - Realizar Depósito");
            System.out.println("3 - Realizar Saque");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opção: ");

            // Evita travar se o usuário digitar letras
            if (!sc.hasNextInt()) {
                sc.next(); // descarta a entrada inválida
                System.out.println("Opção inválida");
                opcao = 0;
                continue;
            }
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.printf("Saldo atual: R$ %.2f%n", saldo);
                    break;

                case 2:
                    System.out.print("Valor do depósito: R$ ");
                    if (!sc.hasNextDouble()) {
                        sc.next();
                        System.out.println("Valor inválido.");
                        break;
                    }
                    double deposito = sc.nextDouble();
                    if (deposito <= 0) {
                        System.out.println("Valor inválido. O depósito deve ser maior que zero.");
                    } else {
                        saldo += deposito;
                        System.out.printf("Depósito realizado. Novo saldo: R$ %.2f%n", saldo);
                    }
                    break;

                case 3:
                    System.out.print("Valor do saque: R$ ");
                    if (!sc.hasNextDouble()) {
                        sc.next();
                        System.out.println("Valor inválido.");
                        break;
                    }
                    double saque = sc.nextDouble();
                    if (saque <= 0) {
                        System.out.println("Valor inválido. O saque deve ser maior que zero.");
                    } else if (saque > saldo) {
                        System.out.println("Saldo insuficiente");
                    } else {
                        saldo -= saque;
                        System.out.printf("Saque realizado. Novo saldo: R$ %.2f%n", saldo);
                    }
                    break;

                case 4:
                    System.out.println("Encerrando. Obrigado por usar o caixa eletrônico!");
                    break;

                default:
                    System.out.println("Opção inválida");
            }

        } while (opcao != 4);

        sc.close();
    }
}