package mapping

class Admin {
    
    private int idadmin
    private int idrole
    private String surnom
    private String login
    private String motdepasse

    static constraints = {
    }
    
    Admin() {
    }

    Admin(int idadmin, int idrole, String surnom, String login, String motdepasse) {
        this.setIdadmin(idadmin)
        this.setIdrole(idrole)
        this.setSurnom(surnom)
        this.setLogin(login)
        this.setMotdepasse(motdepasse)
    }

    int getIdadmin() {
        return idadmin
    }

    void setIdadmin(int idadmin) {
        this.idadmin = idadmin
    }

    int getIdrole() {
        return idrole
    }

    void setIdrole(int idrole) {
        this.idrole = idrole
    }

    String getSurnom() {
        return surnom
    }

    void setSurnom(String surnom) {
        this.surnom = surnom
    }

    String getLogin() {
        return login
    }

    void setLogin(String login) {

        if(login != null && login.length() >= 6){
            this.login = login
        }else{
            throw new Exception("L'identifiant doit comporter au moins 6 caractères")
        }

    }

    String getMotdepasse() {
        return motdepasse
    }

    void setMotdepasse(String motdepasse) {

        String pattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#\$%^&+=])(?=\\S+\$).{8,}\$"
        if(motdepasse.matches(pattern)){
            this.motdepasse = motdepasse
        }else{
            throw new Exception("Le mot de passe doit comporter au moins 8 caractères et doit comporter au moins une majuscule et un caractère numérique ou de ponctuation. ")
        }
    }
}
