package mapping

class Message {

    
    
    private int idmessage
    private int idenvoyeur
    private int idrecepteur
    private String corps
    private int aprouve
    private boolean affichage
    private Date dateenvoye
    private boolean status

    static constraints = {
    }
    
    
    Message(int idmessage, int idenvoyeur, int idrecepteur, String corps, int aprouve, boolean affichage, Date dateenvoye, boolean status) {
        this.setIdmessage(idmessage)
        this.setIdenvoyeur(idenvoyeur)
        this.setIdrecepteur(idrecepteur)
        this.setCorps(corps)
        this.setAprouve(aprouve)
        this.setAffichage(affichage)
        this.setDateenvoye(dateenvoye)
        this.setStatus(status)
    }

    Message() {
    }

    int getIdmessage() {
        return idmessage
    }

    void setIdmessage(int idmessage) {
        this.idmessage = idmessage
    }

    int getIdenvoyeur() {
        return idenvoyeur
    }

    void setIdenvoyeur(int idenvoyeur) {
        this.idenvoyeur = idenvoyeur
    }

    int getIdrecepteur() {
        return idrecepteur
    }

    void setIdrecepteur(int idrecepteur) {
        this.idrecepteur = idrecepteur
    }

    String getCorps() {
        return corps
    }

    void setCorps(String corps) {
        this.corps = corps
    }

    int getAprouve() {
        return aprouve
    }

    void setAprouve(int aprouve) {
        this.aprouve = aprouve
    }

    boolean isAffichage() {
        return affichage
    }

    void setAffichage(boolean affichage) {
        this.affichage = affichage
    }

    Date getDateenvoye() {
        return dateenvoye;
    }

    void setDateenvoye(Date dateenvoye) {
        this.dateenvoye = dateenvoye
    }

    boolean isStatus() {
        return status
    }

    void setStatus(boolean status) {
        this.status = status
    }
}
