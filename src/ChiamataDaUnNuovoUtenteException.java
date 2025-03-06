public class ChiamataDaUnNuovoUtenteException extends CallCenterException {

    private String message = "È stata ricevuta una chiamata da un nuovo cliente:\n";
    private Cliente cliente;

    public ChiamataDaUnNuovoUtenteException(Cliente cliente){
        this.cliente = cliente;
    }

    @Override
    public String getMessage() {
        return message + cliente.toString();
    }

}
