package ListaDeContatos;

public class Telefone {

    private Long idTelefone = 1L;
    private String ddd;
    private Long numero;

    public Telefone(Long id, String ddd, Long numero) {
        this.ddd = ddd;
        this.idTelefone++;
        this.numero = numero;
    }

    public void setId(Long id) {this.idTelefone = id;}

    public void setDdd(String ddd) {this.ddd = ddd;}

    public void setNumero(Long numero) {this.numero = numero;}

    public Long getId() {return idTelefone;}

    public Long getNumero() {return numero;}

    public String getDdd() {return ddd;}
}
