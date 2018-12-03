package mapping

class Cron {

    private int idcron;
    private int idenvoyeur;
    private int idrecepteur;
    private boolean active;

    public Cron()
    {

    }

    Cron(int idcron, int idenvoyeur, int idrecepteur, boolean active) {
        this.setIdcron(idcron);
        this.setIdenvoyeur(idenvoyeur);
        this.setIdrecepteur(idrecepteur);
        this.setActive(active);
    }

    public int getIdcron() {
        return idcron
    }

    public void setIdcron(int idcron) {
        this.idcron = idcron
    }

    public int getIdenvoyeur() {
        return idenvoyeur
    }

    public void setIdenvoyeur(int idenvoyeur) {
        this.idenvoyeur = idenvoyeur
    }

    public int getIdrecepteur() {
        return idrecepteur
    }

    public void setIdrecepteur(int idrecepteur) {
        this.idrecepteur = idrecepteur
    }

    public boolean getActive() {
        return active
    }

    public void setActive(boolean active) {
        this.active = active
    }
}
