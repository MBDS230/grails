package association

class MatchJoueur
{

    private int idmatch;
    private String joueur1;
    private Date datematch;
    private int scoredemandeur;
    private String joueur2;
    private int scorerecepteur;
    private Date datedebut;
    private Date datefin;

    public MatchJoueur()
    {

    }

    public MatchJoueur(int idmatch, String joueur1, Date datematch, int scoredemandeur, String joueur2, int scorerecepteur, Date datedebut, Date datefin) {
        this.idmatch = idmatch
        this.joueur1 = joueur1
        this.datematch = datematch
        this.scoredemandeur = scoredemandeur
        this.joueur2 = joueur2
        this.scorerecepteur = scorerecepteur
        this.datedebut = datedebut
        this.datefin = datefin
    }

    public int getIdmatch() {
        return idmatch
    }

    public void setIdmatch(int idmatch) {
        this.idmatch = idmatch
    }

    public String getJoueur1() {
        return joueur1
    }

    public void setJoueur1(String joueur1) {
        this.joueur1 = joueur1
    }

    public Date getDatematch() {
        return datematch
    }

    public void setDatematch(Date datematch) {
        this.datematch = datematch
    }

    public int getScoredemandeur() {
        return scoredemandeur
    }

    public void setScoredemandeur(int scoredemandeur) {
        this.scoredemandeur = scoredemandeur
    }

    public String getJoueur2() {
        return joueur2
    }

    public void setJoueur2(String joueur2) {
        this.joueur2 = joueur2
    }

    public int getScorerecepteur() {
        return scorerecepteur
    }

    public void setScorerecepteur(int scorerecepteur) {
        this.scorerecepteur = scorerecepteur
    }

    public Date getDatedebut() {
        return datedebut
    }

    public void setDatedebut(Date datedebut) {
        this.datedebut = datedebut
    }

    public Date getDatefin() {
        return datefin
    }

    public void setDatefin(Date datefin) {
        this.datefin = datefin
    }
}
