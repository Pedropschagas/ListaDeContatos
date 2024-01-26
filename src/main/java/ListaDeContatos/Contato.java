package ListaDeContatos;

import java.util.List;
import java.util.Scanner;

public class Contato {
    private static Long idContato = 1L;
    private String nome;
    private String sobreNome;
    private List<Telefone> lista;

    public Contato(String nome, String sobreNome, List<Telefone> telefones){
        this.idContato++;
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.lista = telefones;

    }

    public void setId(Long idContact) {this.idContato = idContact;}

    public void setNome(String nome) {this.nome = nome;}

    public void setSNome(String sNome) {this.sobreNome = sNome;}

    public void setFone(Telefone telefone) {
        int index = lista.indexOf(telefone);
        this.lista.set(index, telefone);
    }

    public Long getIdContato() {return idContato;}

    public String getNome() {return nome;}

    public String getSobreNome() {return sobreNome;}


    public List<Telefone> getTelefones() {return lista;}


    //Adição, Remoção e Edição de telefone.

    public boolean verificaTelefone(Long numero) {
        if()
    }

    public boolean adicionaTeleFone(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe o número, com o ddd, do novo telefone: ");
        String numero = sc.nextLine();

        while(numero.length() != 11){
            System.out.println("O numero e o ddd, deve conter, no máximo 11 digitos. Informe um novo número: ");
            numero = sc.nextLine();
        }



        sc.close();

        Telefone novoFone = null;
        Long numTelefone = Long.valueOf(numero.substring(2));
        novoFone.setDdd(numero.substring(0,2));
        novoFone.setNumero(numTelefone);
        lista.add(novoFone);

        return novoFone != null? true : false;
    }

}