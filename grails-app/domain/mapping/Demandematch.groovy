package mapping

class Demandematch {

   
    
    private int iddemandematch;
    private int iddemandeur;
    private int idrecepteur;
    private int duree;
    private Date datedemande;
    private Date dateexpiration;
    private int aprouvee;

    static constraints = {
    }
    
    public Demandematch() {
    }

    public Demandematch(int iddemandematch, int iddemandeur, int idrecepteur, int duree, Date datedemande, Date dateexpiration, int aprouvee) {
        this.iddemandematch = iddemandematch;
        this.iddemandeur = iddemandeur;
        this.idrecepteur = idrecepteur;
        this.duree = duree;
        this.datedemande = datedemande;
        this.dateexpiration = dateexpiration;
        this.aprouvee = aprouvee;
    }

    public int getIddemandematch() {
        return iddemandematch;
    }

    public void setIddemandematch(int iddemandematch) {
        this.iddemandematch = iddemandematch;
    }

    public int getIddemandeur() {
        return iddemandeur;
    }

    public void setIddemandeur(int iddemandeur) {
        this.iddemandeur = iddemandeur;
    }

    public int getIdrecepteur() {
        return idrecepteur;
    }

    public void setIdrecepteur(int idrecepteur) {
        this.idrecepteur = idrecepteur;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public Date getDatedemande() {
        return datedemande;
    }

    public void setDatedemande(Date datedemande) {
        this.datedemande = datedemande;
    }

    public Date getDateexpiration() {
        return dateexpiration;
    }

    public void setDateexpiration(Date dateexpiration) {
        this.dateexpiration = dateexpiration;
    }

    public int getAprouvee() {
        return aprouvee;
    }

    public void setAprouvee(int aprouvee) {
        this.aprouvee = aprouvee;
    }
}
