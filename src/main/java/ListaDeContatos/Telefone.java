package ListaDeContatos;

public class Telefone {

    private Long idTelefone;
    private String ddd;
    private Long numero;

    public Telefone() {
        this.ddd = new String();
        this.idTelefone = 1L;
        this.numero = 0L;
    }

    public void setIdTelefone(Long id) {
        this.idTelefone = id;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public Long getIdTelefone() {
        return idTelefone;
    }

    public Long getNumero() {
        return numero;
    }

    public String getDdd() {
        return ddd;
    }
}
