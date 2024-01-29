package ListaDeContatos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Contato {
    private Long idContato = 1L;
    private String nome;
    private String sobreNome;
    private List<Telefone> lista;
    private Long idListaTel = 0L;

    public Contato() {
        this.nome = new String();
        this.sobreNome = new String();
        this.lista = new ArrayList<>();
    }

    public void setIdContato(Long idContact) {
        this.idContato = idContact;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSNome(String sNome) {
        this.sobreNome = sNome;
    }

    public void setLista(Telefone telefone){
        this.lista.add(telefone);
    }

    public Long setIdListaTel(){
        this.idListaTel += 1;
        return getIdListaTel();
    }


    public Long getIdContato() {
        return idContato;
    }

    public Long getIdListaTel() {
        return idListaTel;
    }

    public String getNome() {
        return nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }


    public List<Telefone> getLista() {
        return lista;
    }

    //utilidades

    public void insereTelefone(Long id, String ddd, Long numero){
        Telefone novoTelefone = new Telefone();
        novoTelefone.setIdTelefone(id);
        novoTelefone.setDdd(ddd);
        novoTelefone.setNumero(numero);
        this.lista.add(novoTelefone);
    }

    public String extrairDdd(String numero) {return numero.substring(0, 2);}

    public Long extrairNumero(String numero) {return Long.valueOf(numero.substring(2));}

    private Telefone buscaTelefone(Long idTelefone) {
        for (Telefone telefone : this.lista) {
            if (telefone.getIdTelefone() == idTelefone) {
                return telefone;
            }
        }
        return null;
    }

    // Verificações
    private static boolean contemApenasNumeros(String dddTelefone) {
        for (char c : dddTelefone.toCharArray()) {
            if (!Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    private static boolean tamanhoDoNumero(String dddTelefone) {
        if (dddTelefone.length() != 11)
            return true;
        return false;
    }



    //Adição, Remoção e Edição de telefones.


    public Telefone recebeTelefone() {
        Telefone novoFone = new Telefone();
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe o número, com o ddd, do novo telefone: ");
        String numero = sc.nextLine();


        while (contemApenasNumeros(numero)) {
            System.out.println("Apenas números devem ser colocados nesse campo. Digite novamente o telefone: ");
            numero = sc.nextLine();
        }


        while (tamanhoDoNumero(numero)) {
            System.out.println("O telefone e o ddd formam um número de 11 digitos. Por favor, digite novamente: ");
            numero = sc.nextLine();
        }

        novoFone.setDdd(extrairDdd(numero));
        novoFone.setNumero(extrairNumero(numero));

        return novoFone;
    }


    public void editarTelefone() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe o id do telefone que deseja editar: ");
        Long id = sc.nextLong();


        if (buscaTelefone(id) == null) {
            System.out.println("id não encontrado");
        } else {
            System.out.println("Informe o novo número com ddd: ");
            String novo = sc.nextLine();

            for (Telefone tel : this.lista) {
                if (buscaTelefone(id) == tel) {
                    tel.setNumero(extrairNumero(novo));
                    tel.setDdd(extrairDdd(novo));
                }
            }
            System.out.println("Número de telefone alterado.");
        }

    }

    public void removerTelefone() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe o id do telefone que deseja remover: ");
        Long id = sc.nextLong();



        if (buscaTelefone(id) == null) {
            System.out.println("id não encontrado");
        } else {
            Telefone aux = buscaTelefone(id);
            this.lista.remove(aux);
            System.out.println("Número de telefone removido.");
        }
    }
}
