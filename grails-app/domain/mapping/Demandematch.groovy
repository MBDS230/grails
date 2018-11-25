package mapping

class Demandematch {
    
    private int iddemandematch
    private int iddemandeur
    private int idrecepteur
    private int duree
    private Date datedemande
    private Date dateexpiration
    private int aprouvee

    static constraints = {
    }
    
    Demandematch() {
    }

    Demandematch(int iddemandematch, int iddemandeur, int idrecepteur, int duree, Date datedemande, Date dateexpiration, int aprouvee) {
        this.setIddemandematch(iddemandematch)
        this.setIddemandeur(iddemandeur)
        this.setIdrecepteur(idrecepteur)
        this.setDuree(duree)
        this.setDatedemande(datedemande)
        this.setDateexpiration(dateexpiration)
        this.setAprouvee(aprouvee)
    }

    public int getIddemandematch() {
        return iddemandematch
    }

    void setIddemandematch(int iddemandematch) {
        this.iddemandematch = iddemandematch
    }

    int getIddemandeur() {
        return iddemandeur
    }

    void setIddemandeur(int iddemandeur) {
        this.iddemandeur = iddemandeur
    }

    int getIdrecepteur() {
        return idrecepteur
    }

    void setIdrecepteur(int idrecepteur) {
        this.idrecepteur = idrecepteur
    }

    int getDuree() {
        return duree
    }

    void setDuree(int duree) {
        this.duree = duree
    }

    Date getDatedemande() {
        return datedemande
    }

    void setDatedemande(Date datedemande) {
        this.datedemande = datedemande
    }

    Date getDateexpiration() {
        return dateexpiration
    }

    void setDateexpiration(Date dateexpiration) {
        this.dateexpiration = dateexpiration
    }

    int getAprouvee() {
        return aprouvee
    }

    void setAprouvee(int aprouvee) {
        this.aprouvee = aprouvee
    }
}
