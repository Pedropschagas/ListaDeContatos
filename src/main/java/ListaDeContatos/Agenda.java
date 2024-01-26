package ListaDeContatos;

import java.util.List;
import java.util.Scanner;

public class Agenda {
    public List<Contato> contatos;

    public Agenda(List<Contato> contatos){
        this.contatos = contatos;
    }

    //contatos

    public void setContatos(List<Contato> contatos) {this.contatos = contatos;}

    public List<Contato> getContatos() {return contatos;}


    public void adicionaContact(Contato novo) {
        Contato novoContato = novo;
        Scanner sc = new Scanner(System.in);

        System.out.println("Informe o nome do novo contato: ");
        novoContato.setNome(sc.nextLine());


        System.out.println("Informe o sobrenome do novo contato: ");
        novoContato.setSNome(sc.nextLine());


        System.out.println("Informe o número do telefone do contato, com o ddd: ");
        String numerocomDDD = sc.nextLine();
        novoContato.;
    }
}
