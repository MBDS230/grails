package utilitaire

class StatusHttp
{
    public int status;
    public String messageErreur;

    static constraints = {
    }

    StatusHttp(int status, String messageErreur) {
        this.setStatus(status)
        this.setMessageErreur(messageErreur)
    }

    int getStatus() {
        return status
    }

    void setStatus(int status) {
        this.status = status
    }

    String getMessageErreur() {
        return messageErreur
    }

    void setMessageErreur(String messageErreur) {
        this.messageErreur = messageErreur
    }
}
