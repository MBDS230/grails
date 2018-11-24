package mapping

class Role {

    
    private int idrole;
    private String nom;
    private int degre;
    
    static constraints = {
    }
    
    public Role(int idrole, String nom, int degre) {
        this.idrole = idrole;
        this.nom = nom;
        this.degre = degre;
    }

    public Role() {
    }

    public int getIdrole() {
        return idrole;
    }

    public void setIdrole(int idrole) {
        this.idrole = idrole;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getDegre() {
        return degre;
    }

    public void setDegre(int degre) {
        this.degre = degre;
    }
}
