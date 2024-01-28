package ListaDeContatos;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Agenda agenda1 = new Agenda();
        agenda1.lerAgenda();

        Contato contatoGeral = new Contato();

        menu(agenda1);
        agenda1.escreverAgenda();
    }


    //Funções utilitárias para o programa principal.

    public static void menu(Agenda agenda) {
        Scanner sc = new Scanner(System.in);
        Contato Aux_contato = new Contato();
        int menu = 0;

        while (menu != 5) {

            agenda.exibirAgenda();

            menu = sc.nextInt();

            switch (menu) {
                case 1:
                    agenda.adicionarContato();
                    pausa();
                    break;
                case 2:
                    agenda.removerContato();
                    pausa();
                    break;
                case 3:
                    agenda.editarContato();
                    pausa();
                    break;
                case 4:
                    agenda.exibirTelefones();
                    pausa();
                    break;
                case 5:
                    System.out.println("Até Logo!!");
                    break;
                default:
                    System.out.println("Opção inválida. Escolha uma das opções do menu.");
            }
        }
    }
    public static void pausa(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Aperte Enter para retornar ao menu inicial");
        sc.nextLine();
    }


}
