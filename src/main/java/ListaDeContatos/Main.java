package ListaDeContatos;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Agenda agenda1 = new Agenda();
        menu(agenda1);

    }

    public static void limparConsole() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void menu(Agenda novaAgenda) {
        Scanner sc = new Scanner(System.in);
        int menu = 0;

        while (menu != 4) {
            System.out.println(
                    "##################\n" +
                            "##### AGENDA #####\n" +
                            "##################\n" +
                            ">>>> Contatos <<<<\n" +
                            "Id | Nome\n" +
                            ">>>> Menu <<<<\n" +
                            "1 - Adicionar Contato\n" +
                            "2 - Remover Contato\n" +
                            "3 - Editar Contato\n" +
                            "4 - Sair");

            menu = sc.nextInt();

            switch (menu) {
                case 1:
                    limparConsole();
                    System.out.println("Opção 1 selecionada");
                    novaAgenda.adicionarContato();
                    break;
                case 2:
                    System.out.println("Opção 2 selecionada");
                    break;
                case 3:
                    System.out.println("Opção 3 selecionada");
                    break;
                case 4:
                    System.out.println("Até Logo!!");
                    break;
                default:
                    System.out.println("Opção inválida. Escolha uma das opções do menu.");
            }
        }

    }


}
