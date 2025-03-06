public class Dipendente {

    private String codice;
    private String cognome;
    private String nome;

    public Dipendente(String codice, String cognome, String nome) {
        this.codice = codice;
        this.cognome = cognome;
        this.nome = nome;
    }

    public String getCodice() {
        return codice;
    }

    public String getCognome() {
        return cognome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Dipendente:" +
                " codice: " + getCodice() +
                ", cognome e nome: " + getCognome() + " " + getNome();
    }

}
