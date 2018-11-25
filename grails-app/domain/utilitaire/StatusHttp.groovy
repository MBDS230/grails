package utilitaire

class StatusHttp
{
    public int status;
    public String messageErreur;
    public String redirectUrl;

    static constraints = {
    }

    StatusHttp(int status, String messageErreur, String redirectUrl) {
        this.setStatus(status)
        this.setMessageErreur(messageErreur)
        this.setRedirectUrl(redirectUrl)
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

    String getRedirectUrl() {
        return redirectUrl
    }

    void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl
    }
}
