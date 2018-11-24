package mapping

class Message {

    
    
    private int idmessage;
    private int idenvoyeur;
    private int idrecepteur;
    private String corps;
    private int aprouve;
    private boolean affichage;
    private Date dateenvoye;
    private boolean status;

    static constraints = {
    }
    
    
    public Message(int idmessage, int idenvoyeur, int idrecepteur, String corps, int aprouve, boolean affichage, Date dateenvoye, boolean status) {
        this.idmessage = idmessage;
        this.idenvoyeur = idenvoyeur;
        this.idrecepteur = idrecepteur;
        this.corps = corps;
        this.aprouve = aprouve;
        this.affichage = affichage;
        this.dateenvoye = dateenvoye;
        this.status = status;
    }

    public Message() {
    }

    public int getIdmessage() {
        return idmessage;
    }

    public void setIdmessage(int idmessage) {
        this.idmessage = idmessage;
    }

    public int getIdenvoyeur() {
        return idenvoyeur;
    }

    public void setIdenvoyeur(int idenvoyeur) {
        this.idenvoyeur = idenvoyeur;
    }

    public int getIdrecepteur() {
        return idrecepteur;
    }

    public void setIdrecepteur(int idrecepteur) {
        this.idrecepteur = idrecepteur;
    }

    public String getCorps() {
        return corps;
    }

    public void setCorps(String corps) {
        this.corps = corps;
    }

    public int getAprouve() {
        return aprouve;
    }

    public void setAprouve(int aprouve) {
        this.aprouve = aprouve;
    }

    public boolean isAffichage() {
        return affichage;
    }

    public void setAffichage(boolean affichage) {
        this.affichage = affichage;
    }

    public Date getDateenvoye() {
        return dateenvoye;
    }

    public void setDateenvoye(Date dateenvoye) {
        this.dateenvoye = dateenvoye;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
