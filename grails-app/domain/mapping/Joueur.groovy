package mapping

class Joueur {

    private int idjoueur;
    private String login;
    private String motdepasse;
    private boolean status;
    private int aprouve;

    static constraints = {
    }
    
    
    public Joueur(int idjoueur, String login, String motdepasse, boolean status, int aprouve) {
        this.idjoueur = idjoueur;
        this.login = login;
        this.motdepasse = motdepasse;
        this.status = status;
        this.aprouve = aprouve;
    }

    public Joueur() {
    }

    public int getIdjoueur() {
        return idjoueur;
    }

    public void setIdjoueur(int idjoueur) {
        this.idjoueur = idjoueur;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMotdepasse() {
        return motdepasse;
    }

    public void setMotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getAprouve() {
        return aprouve;
    }

    public void setAprouve(int aprouve) {
        this.aprouve = aprouve;
    }
}
