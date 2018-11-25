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
        if(login.length() >= 6){
            this.login = login
        }else{
            throw new Exception("the Username must contain at least 6 characters")
        }
    }

    String getMotdepasse() {
        return motdepasse;
    }

    void setMotdepasse(String motdepasse) {

        String pattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#\$%^&+=])(?=\\S+\$).{8,}\$"
        if(motdepasse.matches(pattern)){
            this.motdepasse = motdepasse
        }else{
            throw new Exception("the password must contain at least 1 character 1 number and 1 special character")
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
