package ListaDeContatos;

import java.util.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;

public class Agenda {
    private Long idListaContato = 0L;
    public List<Contato> contatos;

    public Agenda() {
        this.contatos = new ArrayList<>();
    }


    public void setContatos(List<Contato> contatos) {
        this.contatos = contatos;
    }

    public Long setIdListaContato() {
        this.idListaContato += 1;
        return getIdListaContato();
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

    public void exibirAgenda() {

        System.out.println(
                "##################\n" +
                        "##### AGENDA #####\n" +
                        "##################\n" +
                        ">>>> Contatos <<<<\n" +
                        "Id | Nome"
        );


        Collections.sort(this.contatos, Comparator.comparing(Contato::getNome));
        if (this.contatos.size() >= 1)
            for (Contato contato : this.contatos) {
                System.out.println(contato.getIdContato() + " | " + contato.getNome() + " " + contato.getSobreNome());
            }

        System.out.println(
                ">>>> Menu <<<<\n" +
                        "1 - Adicionar Contato\n" +
                        "2 - Remover Contato\n" +
                        "3 - Editar Contato\n" +
                        "4 - Exibir Telefones\n" +
                        "5 - Sair");
    }

    public void exibirTelefones() {
        Contato aux = new Contato();
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe o id do contato: ");
        aux = buscaContato(Long.valueOf(sc.next()));

        //Inserção para organizar os espaços antes do telefone, na saída.
        String quantidadeEspacos = " ".repeat(String.valueOf(aux.getIdContato()).length() + 1);


        System.out.println(aux.getIdContato() + " | " + aux.getNome() + " " + aux.getSobreNome());
        if (!aux.getLista().isEmpty())
            for (Telefone numero : aux.getLista()) {
                System.out.println(quantidadeEspacos + "| " + numero.getIdTelefone() + " - " + numero.getDdd() + numero.getNumero());
            }
    }

    public void escreverAgenda() {
        try (PrintWriter escrever = new PrintWriter(new FileWriter("Agenda.txt"))) {
            for (Contato cont : this.contatos) {
                escrever.print(cont.getIdContato() + "," + cont.getNome() + "," + cont.getSobreNome() + "|");
                if (cont.getLista().isEmpty()) {
                    escrever.print(".\n");
                } else {
                    for (Telefone numero : cont.getLista()) {
                        escrever.print(numero.getIdTelefone() + "," + numero.getDdd() + numero.getNumero() + "|");
                    }
                escrever.print("\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void lerAgenda(){
        try(BufferedReader br = new BufferedReader(new FileReader("Agenda.txt"))){
            String linha;

            while((linha = br.readLine()) != null){

                String linhaFinal = linha;
                String[] dadosSeparados = linhaFinal.split("\\|");
                String[] nomeEsobrenome = dadosSeparados[0].split(",");


                //######### Adicionar dados do Contato #########
                Contato novoContato = new Contato();
                novoContato.setIdContato(Long.valueOf(nomeEsobrenome[0]));
                novoContato.setNome(nomeEsobrenome[1]);
                novoContato.setSNome(nomeEsobrenome[2]);


                //######### Adicionar Telefones do Contato #########
                if(dadosSeparados.length > 1){
                    for(int i = 1; i < dadosSeparados.length;i++){
                        String[] idENumero = dadosSeparados[i].split(",");
                        String id = idENumero[0];
                        String numEddd = idENumero[1];
                        novoContato.insereTelefone(Long.valueOf(id), numEddd.substring(0, 2), Long.valueOf(numEddd.substring(2)));
                    }
                }
                this.contatos.add(novoContato);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }

    }

//    public void lerAgenda();

    //Verificações
    public static boolean validaString(String string) {
        if (!string.trim().isEmpty() && string.matches("[a-zA-Z]+")) {
            return true;
        }
        return false;
    }

    private boolean numeroExistente(Telefone novo) {
        for (Contato cont : this.contatos) {
            for (Telefone tel : cont.getLista()) {
                if (Objects.equals(tel.getDdd(), novo.getDdd()) && Objects.equals(tel.getNumero(), novo.getNumero())) {
                    return true;
                }
            }
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
        novoContato.setIdContato(setIdListaContato());

        Telefone novo = novoContato.recebeTelefone();


        if (this.contatos.size() == 0) {
            novo.setIdTelefone(novoContato.setIdListaTel());
            novoContato.setLista(novo);
            this.contatos.add(novoContato);
            System.out.println("Contato adicionado com Sucesso!\n\n");
        } else if (!numeroExistente(novo)) {
            novo.setIdTelefone(novoContato.setIdListaTel());
            novoContato.setLista(novo);
            this.contatos.add(novoContato);
            System.out.println("Contato adicionado com Sucesso!\n\n");
        } else {
            System.out.println("Telefone já cadastrado. Tente novamente.");
        }
    }

    public void removerContato() {
        Scanner sc = new Scanner(System.in);
        System.out.println("informe o id do contato que deseja remover: ");
        String aux_id = sc.nextLine();
        Contato buscado = buscaContato(Long.valueOf(aux_id));

        if (buscado == null) {
            System.out.println("Contato não encontrado.");
        } else {
            this.contatos.remove(buscado);
            System.out.println("Contato removido.");
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
                    while (opcao != 6) {
                        System.out.println("Digite:\n" +
                                "1 - Para alterar nome;\n" +
                                "2 - Para alterar sobrenome\n" +
                                "3 - Para alterar um telefone\n" +
                                "4 - Para adicionar um telefone a um contato\n" +
                                "5 - Para remover um telefone do contato\n" +
                                "6 - Voltar ao menu anterior");

                        opcao = sc.nextInt();

                        switch (opcao) {
                            case 1:
                                System.out.println("Informe um novo nome para o contato: ");
                                String nome = sc.next();
                                if (validaString(nome)) {
                                    cont.setNome(nome);
                                } else {
                                    System.out.println("Nome inválido!");
                                }
                                break;
                            case 2:
                                System.out.println("Informe um novo sobrenome para o contato: ");
                                String sobrenome = sc.next();
                                if (validaString(sobrenome)) {
                                    cont.setSNome(sobrenome);
                                } else {
                                    System.out.println("Sobrenome inválido!");
                                }
                                break;
                            case 3:
                                cont.editarTelefone();
                                break;
                            case 4:
                                Telefone novo = cont.recebeTelefone();
                                if (!numeroExistente(novo)) {
                                    novo.setIdTelefone(cont.setIdListaTel());
                                    cont.setLista(novo);
                                } else {
                                    System.out.println("Numero já cadastrado. Tente novamente.");
                                }
                                break;
                            case 5:
                                cont.removerTelefone();
                                break;
                            case 6:
                                break;
                            default:
                                System.out.println("Opção inválida. Escolha uma das opções do menu.");
                                break;
                        }
                    }
                }
            }
        }
    }
}
