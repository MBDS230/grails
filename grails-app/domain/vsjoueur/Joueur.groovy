package vsjoueur

class Joueur {
    private int idjoueur;
    private String nom;

    static constraints = {
    }

    public Joueur(int id, String nom)
    {
        this.setId(id);
        this.setNom(nom);
    }

    void setIdjoueur(int idjoueur) {
        this.idjoueur = idjoueur
    }

    void setNom(String nom) {
        this.nom = nom
    }

    int getIdjoueur() {
        return idjoueur
    }

    String getNom() {
        return nom
    }
}
