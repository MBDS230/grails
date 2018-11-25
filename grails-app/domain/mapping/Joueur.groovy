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
        if(login != null && login.length() >= 6){
            this.login = login
        }else{
            throw new Exception("L'identifiant doit comporter au moins 6 caractères")
        }
    }

    String getMotdepasse() {
        return motdepasse;
    }

    void setMotdepasse(String motdepasse) {


        if(motdepasse.length() >= 6){
            this.motdepasse = motdepasse
        }else{
            throw new Exception("Le mot de passe doit comporter comporter au moins 6 caractères")
        }
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
