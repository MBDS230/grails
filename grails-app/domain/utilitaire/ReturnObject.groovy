package utilitaire

class ReturnObject {

    public Object objet;
    public StatusHttp status;

    Object getObjet() {
        return objet
    }

    void setObjet(Object objet) {
        this.objet = objet
    }

    StatusHttp getStatus() {
        return status
    }

    void setStatus(StatusHttp status) {
        this.status = status
    }
}
