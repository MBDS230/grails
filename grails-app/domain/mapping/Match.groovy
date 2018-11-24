package mapping

class Match {

   
    private int idmatch;
    private int iddemandematch;
    private Date datematch;
    private int scoredemandeur;
    private int scorerecepteur;
    private Date datedebut;
    private Date datefin;

     static constraints = {
    }
    public Match(int idmatch, int iddemandematch, Date datematch, int scoredemandeur, int scorerecepteur, Date datedebut, Date datefin) {
        this.idmatch = idmatch;
        this.iddemandematch = iddemandematch;
        this.datematch = datematch;
        this.scoredemandeur = scoredemandeur;
        this.scorerecepteur = scorerecepteur;
        this.datedebut = datedebut;
        this.datefin = datefin;
    }

    public Match() {
    }

    public int getIdmatch() {
        return idmatch;
    }

    public void setIdmatch(int idmatch) {
        this.idmatch = idmatch;
    }

    public int getIddemandematch() {
        return iddemandematch;
    }

    public void setIddemandematch(int iddemandematch) {
        this.iddemandematch = iddemandematch;
    }

    public Date getDatematch() {
        return datematch;
    }

    public void setDatematch(Date datematch) {
        this.datematch = datematch;
    }

    public int getScoredemandeur() {
        return scoredemandeur;
    }

    public void setScoredemandeur(int scoredemandeur) {
        this.scoredemandeur = scoredemandeur;
    }

    public int getScorerecepteur() {
        return scorerecepteur;
    }

    public void setScorerecepteur(int scorerecepteur) {
        this.scorerecepteur = scorerecepteur;
    }

    public Date getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(Date datedebut) {
        this.datedebut = datedebut;
    }

    public Date getDatefin() {
        return datefin;
    }

    public void setDatefin(Date datefin) {
        this.datefin = datefin;
    }
}
