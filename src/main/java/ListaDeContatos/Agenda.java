package ListaDeContatos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Agenda {
    private Long idListaContato = 1L;
    public List<Contato> contatos;

    public Agenda() {
        this.contatos = new ArrayList<>();
        this.idListaContato++;
    }


    public void setContatos(List<Contato> contatos) {
        this.contatos = contatos;
    }

    public void somaIdListaContato() {
        this.idListaContato++;
    }

    public List<Contato> getContatos() {
        return contatos;
    }

    public Long getIdListaContato() {
        return idListaContato;
    }

    //utilidades
    public Contato buscaContato(Long idContato) {
        for (Contato cont : contatos) {
            if (cont.getIdContato() == idContato) {
                return cont;
            }
        }
        return null;
    }

    //Verificações
    public static boolean validaString(String string) {
        if (!string.trim().isEmpty() && string.matches("[a-zA-Z]+")) {
            return true;
        }
        return false;
    }


    //Adição, Remoção e Edição de Contatos.

    public void adicionarContato() {
        Contato novoContato = new Contato();
        Scanner sc = new Scanner(System.in);

        System.out.println("Informe o primeiro nome do novo contato: ");
        String string = sc.nextLine();


        while (!validaString(string)) {
            System.out.println("Nome inválido. Digite o primeiro nome do contato.");
            string = sc.nextLine();
        }
        novoContato.setNome(string);


        System.out.println("Informe o sobrenome do novo contato: ");
        string = sc.nextLine();

        while (!validaString(string)) {
            System.out.println("Nome inválido. Digite o sobrenome do contato.");
            string = sc.nextLine();
        }
        novoContato.setSNome(string);
        novoContato.setIdContato(idListaContato);
        novoContato.adicionarTeleFone();

        this.contatos.add(novoContato);
        somaIdListaContato();
        sc.close();
    }

    public void removerContato() {
        Scanner sc = new Scanner(System.in);
        System.out.println("informe o id do contato que deseja remover: ");
        Long aux_id = sc.nextLong();
        Contato buscado = buscaContato(aux_id);

        sc.close();

        if (buscado == null) {
            System.out.println("Contato não encontrado.");
        } else {
            for (Contato cont : contatos) {
                if (cont == buscado) {
                    cont = null;
                    System.out.println("Contato removido.");
                }
            }
        }
    }

    public void editarContato() {
        Scanner sc = new Scanner(System.in);
        System.out.println("informe o id do contato que deseja editar: ");
        Long aux_id = sc.nextLong();
        Contato buscado = buscaContato(aux_id);

        if (buscado == null) {
            System.out.println("Contato não encontrado.");
        } else {
            for (Contato cont : contatos) {
                if (cont == buscado) {
                    int opcao = 0;
                    while (opcao != 4) {
                        System.out.println("Digite:\n" +
                                "1 - Para alterar nome;\n" +
                                "2 - Para alterar sobrenome\n" +
                                "3 - Para alterar um telefone\n" +
                                "4 - Voltar ao menu anterior");

                        opcao = sc.nextInt();
                        switch (opcao) {
                            case 1:
                                System.out.println("Informe um novo nome para o contato: ");
                                String nome = sc.nextLine();
                                if (validaString(nome)) {
                                    cont.setNome(nome);
                                } else {
                                    System.out.println("Nome inválido!");
                                }
                                break;
                            case 2:
                                System.out.println("Informe um novo sobrenome para o contato: ");
                                String sobrenome = sc.nextLine();
                                if (validaString(sobrenome)) {
                                    cont.setSNome(sobrenome);
                                } else {
                                    System.out.println("Sobrenome inválido!");
                                }
                                break;
                            case 3:
                                cont.editarTelefone();
                                break;
                            default:
                                System.out.println("Opção inválida. Escolha uma das opções do menu.");
                        }
                    }
                }
            }
        }
        sc.close();
    }
}
