package mapping

class Role {

    
    private int idrole
    private String nom
    private int degre
    
    static constraints = {
    }
    
    Role(int idrole, String nom, int degre) {
        this.setIdrole(idrole)
        this.setNom(nom)
        this.setDegre(degre)
    }

    public Role() {
    }

     int getIdrole() {
        return idrole
    }

    void setIdrole(int idrole) {
        this.idrole = idrole
    }

    String getNom() {
        return nom
    }

    void setNom(String nom) {
        this.nom = nom
    }

    int getDegre() {
        return degre
    }

    void setDegre(int degre) {
        this.degre = degre
    }
}
