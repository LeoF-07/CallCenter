import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CallCenter {

    private HashMap<String, Cliente> clienti;
    private HashMap<String, Dipendente> dipendenti;
    private ArrayList<Telefonata> telefonate;

    public CallCenter(){
        clienti = new HashMap<>();
        dipendenti = new HashMap<>();
        telefonate = new ArrayList<>();
    }

    public String chiamata(String numeroChiamante) throws CallCenterException {
        for (Telefonata telefonata : telefonate){
            if(telefonata.getCliente().getNumeroTelefonico().equals(numeroChiamante)) return telefonata.toString();
        }

        Cliente cliente;

        try{
            cliente = trovaClienteDatoIlNumeroTelefonico(numeroChiamante);
        }catch (ClienteInesistenteException e){
            throw new ClienteInesistenteException("È stata ricevuta una chiamata da un cliente non registrato con il seguente numero telefonico: " + numeroChiamante);
        }

        throw new ChiamataDaUnNuovoUtenteException(cliente);
    }

    public void aggiungiCliente(Cliente nuovoCliente) throws NumeroTelefonicoGiaPresente {
        Iterator<Map.Entry<String, Cliente>> iterator = clienti.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<String, Cliente> cliente = iterator.next();
            if(cliente.getValue().getNumeroTelefonico().equals(nuovoCliente.getNumeroTelefonico())) throw new NumeroTelefonicoGiaPresente();
        }

        clienti.put(nuovoCliente.getCodice(), nuovoCliente);
    }

    public void aggiungiDipendente(Dipendente dipendente){
        dipendenti.put(dipendente.getCodice(), dipendente);
    }

    public void aggiungiTelefonata(Telefonata nuovaTelefonata){
        for (Telefonata telefonata : telefonate){
            if(telefonata.getCliente().equals(nuovaTelefonata.getCliente())){
                telefonata.setDataUltimaTelefonata(nuovaTelefonata.getDataUltimaTelefonata());
                telefonata.setUltimoDipendente(nuovaTelefonata.getUltimoDipendente());
            }
        }

        telefonate.add(nuovaTelefonata);
    }

    public Cliente trovaClienteDatoIlNumeroTelefonico(String numeroChiamante) throws ClienteInesistenteException {
        Iterator<Map.Entry<String, Cliente>> iterator = clienti.entrySet().iterator();

        while(iterator.hasNext()){
            Map.Entry<String, Cliente> cliente = iterator.next();
            if(cliente.getValue().getNumeroTelefonico().equals(numeroChiamante)) return cliente.getValue();
        }

        throw new ClienteInesistenteException("Non esiste nessun cliente con questo numero di telefono");
    }

    public String clientiToString(){
        String s = "Elenco dei clienti\n";

        Iterator<Map.Entry<String, Cliente>> iterator = clienti.entrySet().iterator();
        for(int i = 0; iterator.hasNext(); i++){
            Map.Entry<String, Cliente> cliente = iterator.next();
            s += i + ") " + cliente.getValue().toString() + "\n";
        }

        return s;
    }

    public String dipendentiToString(){
        String s = "Elenco dei dipendenti:\n";

        Iterator<Map.Entry<String, Dipendente>> iterator = dipendenti.entrySet().iterator();
        for(int i = 0; iterator.hasNext(); i++){
            Map.Entry<String, Dipendente> dipendente = iterator.next();
            s += i + ") " + dipendente.getValue().toString() + "\n";
        }

        return s;
    }

    public String telefonateToString(){
        String s = "Elenco delle telefonate:\n";

        for (int i = 0; i < telefonate.size(); i++){
            s += i + ") " + telefonate.get(i).toString() + "\n";
        }

        return s;
    }

    @Override
    public String toString() {
        String s = "Call Center\n\n";

        s += clientiToString() + "\n";
        s += dipendentiToString() + "\n";
        s += telefonateToString() + "\n";

        return s;
    }

}
