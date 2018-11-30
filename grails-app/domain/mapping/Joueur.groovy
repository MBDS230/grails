package mapping

class Joueur {

    private int idjoueur
    private String login
    private String motdepasse
    private boolean status
    private int aprouve
    private String photo

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

    boolean getStatus() {
        return status;
    }
    String getStatusAffichage(){
        switch (status){
            case true:
                return "connecté";
            case false:
                return "déconnecté";
        }
    }
    String getStatusClass(){
        switch (status){
            case true:
                return "badge-success";
            case false:
                return "badge-warning";
        }
    }

    void setStatus(boolean status) {
        this.status = status;
    }

    int getAprouve() {
        return aprouve;
    }
    String getAprouveAffichage(){
        switch(aprouve)
        {
            case 0:
                return "rejeté";
            case 1:
                return "approuvé";
            case 2:
                return "en attente";
            default:
                return "état non disponible";
        }
    }
    String getAprouveClass(){
        switch(aprouve)
        {
            case 0:
                return "badge-danger";
            case 1:
                return "badge-success";
            case 2:
                return "badge-warning";
            default:
                return "badge-light";
        }
    }

    void setAprouve(int aprouve) {
        this.aprouve = aprouve;
    }

    String getPhoto() {
        return photo
    }

    void setPhoto(String photo) {
        this.photo = photo
    }
}
