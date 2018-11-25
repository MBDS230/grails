package mapping

class Joueur {

    private int idjoueur
    private String login
    private String motdepasse
    private boolean status
    private int aprouve

    static constraints = {
    }
    
    
    Joueur(int idjoueur, String login, String motdepasse, boolean status, int aprouve) {
        this.setIdjoueur(idjoueur)
        this.setLogin(login)
        this.setMotdepasse(motdepasse)
        this.setStatus(status)
        this.setAprouve(aprouve)
    }

    Joueur() {
    }

    int getIdjoueur() {
        return idjoueur;
    }

    void setIdjoueur(int idjoueur) {
        this.idjoueur = idjoueur;
    }

    String getLogin() {
        return login;
    }

    void setLogin(String login) {
        this.login = login;
    }

    String getMotdepasse() {
        return motdepasse;
    }

    void setMotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
    }

    boolean isStatus() {
        return status;
    }

    void setStatus(boolean status) {
        this.status = status;
    }

    int getAprouve() {
        return aprouve;
    }

    void setAprouve(int aprouve) {
        this.aprouve = aprouve;
    }
}
