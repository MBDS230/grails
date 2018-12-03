package mapping

class Parametrecron {

    private int idparametrecron;
    private int  heure;
    private int minute;
    private int seconde;

    public Parametrecron()
    {

    }

    public Parametrecron(int idparametrecron, int  heure, int minute, int seconde)
    {
        this.setIdparametrecron(idparametrecron)
        this.setHeure(heure)
        this.setMinute(minute)
        this.setSeconde(seconde)
    }

    public int getIdparametrecron() {
        return idparametrecron
    }

    public void setIdparametrecron(int idparametrecron) {
        this.idparametrecron = idparametrecron
    }

    public int getHeure() {
        return heure
    }

    public void setHeure(int heure) {
        this.heure = heure
    }

    public int getMinute() {
        return minute
    }

    public void setMinute(int minute) {
        this.minute = minute
    }

    public int getSeconde() {
        return seconde
    }

    public void setSeconde(int seconde) {
        this.seconde = seconde
    }
}
