package vsjoueur

import mapping.Demandematch
import mapping.Joueur

class MatchController {

    def demandeMatch()
    {
        Joueur joueurSession = null; // GET SESSION joueur
        if(joueurSession != null)
        {
            int idAutreJoueur = Integer.parseInt(params.getProperty("idAutreJoueur"));
            int duree = Integer.parseInt(params.getProperty("duree"));
            int joueurConnecte = joueurSession.getIdjoueur();
            new MatchService().demandeMatch(joueurConnecte, idAutreJoueur, duree);
        }
    }

    def listeDemandeRencontre()
    {
        ArrayList<Demandematch> listDem = null;
        Joueur joueurSession = null; // GET SESSION joueur
        if(joueurSession != null)
        {
            int idJoueurConnecte = joueurSession.getIdjoueur();
            listDem = new MatchService().listeDemandeRencontre(idJoueurConnecte);
        }
        return listDem;
    }
}
