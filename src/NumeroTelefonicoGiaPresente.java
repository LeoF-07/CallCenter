public class NumeroTelefonicoGiaPresente extends CallCenterException {

    private String message = "Impossibile registrarsi, il numero telefonico è gia usato da un altro cliente";

    @Override
    public String getMessage() {
        return message;
    }

}
