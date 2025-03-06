public class Cliente {

    private String codice;
    private String cognome;
    private String nome;
    private String indirizzo;
    private String citta;
    private String numeroTelefonico;

    public Cliente(String codice, String cognome, String nome, String indirizzo, String citta, String numeroTelefonico) {
        this.codice = codice;
        this.cognome = cognome;
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.citta = citta;
        this.numeroTelefonico = numeroTelefonico;
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

    public String getIndirizzo() {
        return indirizzo;
    }

    public String getCitta() {
        return citta;
    }

    public String getNumeroTelefonico() {
        return numeroTelefonico;
    }

    @Override
    public String toString() {
        return "Cliente: " +
                " codice: " + getCodice() +
                ", cognome e nome: " + getCognome() + " " + getNome() +
                ", città e indirizzo: " + getCitta() + ", " + getIndirizzo() +
                ", numero telefonico: " + getNumeroTelefonico();
    }
}
