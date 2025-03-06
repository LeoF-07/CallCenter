import java.time.LocalDateTime;
import java.util.Date;

public class TesterCallCenter {

    static CallCenter callCenter;

    private static void inizializzaVariabili(){
        callCenter = new CallCenter();
    }

    public static void main(String[] args) {
        stampaDescrizione();
        inizializzaVariabili();
        popola();

        System.out.println(callCenter.toString());


        System.out.println("\nTest chiamata da un utente che ha già chiamato");
        chiama("111 111 1111");

        System.out.println("\nTest chiamata da un utente registrato che non ha mai chiamato");
        chiama("222 222 2222");

        System.out.println("\nTest chiamata da un utente non registrato");
        chiama("333 333 3333");
    }

    private static void stampaDescrizione(){
        System.out.println("Gestione di un call-center");
    }

    private static void popola(){
        Cliente[] clienti = {
                new Cliente("AAA", "Michieli", "Mattia", "via Roma 1", "Mestre", "111 111 1111"),
                new Cliente("BBB", "Fortin", "Leonardo", "via Roma 2", "Scorzè", "222 222 2222")
        };

        Dipendente[] dipendenti = {
                new Dipendente("CCC", "Rossi", "Mario"),
                new Dipendente("DDD", "Verdi", "Filippo")
        };

        Telefonata[] telefonate = {
                new Telefonata(clienti[0], LocalDateTime.of(2025, 3, 3, 12, 34), dipendenti[0])
        };

        for (Cliente cliente : clienti){
            try{
                callCenter.aggiungiCliente(cliente);
            }catch(NumeroTelefonicoGiaPresente e){
                System.out.println(e.getMessage());
            }
        }

        for (Dipendente dipendente : dipendenti) callCenter.aggiungiDipendente(dipendente);

        for (Telefonata telefonata : telefonate) callCenter.aggiungiTelefonata(telefonata);
    }

    public static void chiama(String numeroChiamante){
        try {
            System.out.println(callCenter.chiamata(numeroChiamante));
        } catch(ClienteInesistenteException e) {
            System.out.println(e.getMessage());
        } catch (ChiamataDaUnNuovoUtenteException e) {
            System.out.println(e.getMessage());
        } catch (CallCenterException e) {
            System.out.println("Errore durante la chiamata");
        }
    }

}