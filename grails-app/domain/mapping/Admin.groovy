package mapping

class Admin {
    
    private int idadmin;
    private int idrole;
    private String surnom;
    private String login;
    private String motdepasse;

    static constraints = {
    }
    
    public Admin() {
    }

    public Admin(int idadmin, int idrole, String surnom, String login, String motdepasse) {
        this.idadmin = idadmin;
        this.idrole = idrole;
        this.surnom = surnom;
        this.login = login;
        this.motdepasse = motdepasse;
    }

    public int getIdadmin() {
        return idadmin;
    }

    public void setIdadmin(int idadmin) {
        this.idadmin = idadmin;
    }

    public int getIdrole() {
        return idrole;
    }

    public void setIdrole(int idrole) {
        this.idrole = idrole;
    }

    public String getSurnom() {
        return surnom;
    }

    public void setSurnom(String surnom) {
        this.surnom = surnom;
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
}
