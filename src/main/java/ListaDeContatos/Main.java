package ListaDeContatos;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Agenda agenda1 = new Agenda();
        agenda1.lerAgenda();

        Contato contatoGeral = new Contato();

        menu(agenda1);
        agenda1.escreverAgenda();
        sc.close();
    }


    //Funções utilitárias para o programa principal.

    public static void menu(Agenda agenda) {
        Scanner sc = new Scanner(System.in);
        Contato Aux_contato = new Contato();
        int menu = 0;

        while (menu != 5) {

            try {
                agenda.exibirAgenda();
                menu = sc.nextInt();

                switch (menu) {
                    case 1:
                        agenda.adicionarContato();
                        pausa(1300);
                        break;
                    case 2:
                        agenda.removerContato();
                        pausa(1300);
                        break;
                    case 3:
                        agenda.editarContato();
                        pausa(1300);
                        break;
                    case 4:
                        agenda.exibirTelefones();
                        pausa(1300);
                        break;
                    case 5:
                        System.out.println("Até Logo!!");
                        break;
                    default:
                        System.out.println("Opção inválida. Escolha uma das opções do menu.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada invalida. Digite um numero inteiro, conforme" +
                        " as opções do Menu.");
                sc.nextLine();
                pausa(1300);
            }

        }
    }

    public static void pausa(int tempo_em_ms) {
        try {
            Thread.sleep(1300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

