public class ClienteInesistenteException extends CallCenterException {

    private String message;

    public ClienteInesistenteException(String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
