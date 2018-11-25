package mapping

class Match {

   
    private int idmatch
    private int iddemandematch
    private Date datematch
    private int scoredemandeur
    private int scorerecepteur
    private Date datedebut
    private Date datefin

     static constraints = {
    }
    Match(int idmatch, int iddemandematch, Date datematch, int scoredemandeur, int scorerecepteur, Date datedebut, Date datefin) {
        this.setIdmatch(idmatch)
        this.setIddemandematch(iddemandematch)
        this.setDatematch(datematch)
        this.setScoredemandeur(scoredemandeur);
        this.setScorerecepteur(scorerecepteur)
        this.setDatedebut(datedebut)
        this.setDatefin(datefin)
    }

    Match() {
    }

    int getIdmatch() {
        return idmatch
    }

    void setIdmatch(int idmatch) {
        this.idmatch = idmatch
    }

    int getIddemandematch() {
        return iddemandematch
    }

    void setIddemandematch(int iddemandematch) {
        this.iddemandematch = iddemandematch
    }

    Date getDatematch() {
        return datematch
    }

    void setDatematch(Date datematch) {
        this.datematch = datematch
    }

    int getScoredemandeur() {
        return scoredemandeur
    }

    void setScoredemandeur(int scoredemandeur) {
        this.scoredemandeur = scoredemandeur
    }

    int getScorerecepteur() {
        return scorerecepteur
    }

    void setScorerecepteur(int scorerecepteur) {
        this.scorerecepteur = scorerecepteur
    }

    Date getDatedebut() {
        return datedebut
    }

    void setDatedebut(Date datedebut) {
        this.datedebut = datedebut
    }

    Date getDatefin() {
        return datefin
    }

    void setDatefin(Date datefin) {
        this.datefin = datefin
    }
}
