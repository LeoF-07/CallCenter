import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Telefonata {

    private Cliente cliente;
    private LocalDateTime dataUltimaTelefonata;
    private Dipendente ultimoDipendente;

    public Telefonata(Cliente cliente, LocalDateTime dataUltimaTelefonata, Dipendente ultimoDipendente) {
        this.cliente = cliente;
        this.dataUltimaTelefonata = dataUltimaTelefonata;
        this.ultimoDipendente = ultimoDipendente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public LocalDateTime getDataUltimaTelefonata() {
        return dataUltimaTelefonata;
    }

    public Dipendente getUltimoDipendente() {
        return ultimoDipendente;
    }

    public void setDataUltimaTelefonata(LocalDateTime dataUltimaTelefonata) {
        this.dataUltimaTelefonata = dataUltimaTelefonata;
    }

    public void setUltimoDipendente(Dipendente ultimoDipendente) {
        this.ultimoDipendente = ultimoDipendente;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String dataFormattata = dataUltimaTelefonata.format(formatter);

        return "Telefonata:" +
                "\n- " + cliente.toString() +
                "\n- Data e ora ultima telefonata: " + dataFormattata +
                "\n- Ultimo dipendente che ha risposto: " + ultimoDipendente.toString();
    }

}
