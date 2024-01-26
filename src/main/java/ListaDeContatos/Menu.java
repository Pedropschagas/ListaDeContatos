package ListaDeContatos;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {


    }

    public static void loopApresentacao() {
        Scanner sc = new Scanner(System.in);
        int menu = sc.nextInt();

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

            switch (menu) {
                case 1:
                    break;
                case 2:
                    System.out.println("Opção 2 selecionada");
                    break;
                case 3:
                    System.out.println("Opção 3 selecionada");
                    break;
                default:
                    System.out.println("Opção inválida. Escolha uma das opções do menu.");
            }
        }

    }
}
