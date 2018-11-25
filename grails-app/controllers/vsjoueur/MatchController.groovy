package vsjoueur

import DAO.JoueurDao
import grails.converters.JSON
import mapping.Demandematch
import mapping.Joueur
import utilitaire.ReturnObject
import utilitaire.StatusHttp

class MatchController {

    def demandeMatch()
    {
        try
        {
            Joueur joueurSession =(Joueur) session.getAttribute("SESSION_JOUEUR");
            if(joueurSession != null)
            {
                int idAutreJoueur = Integer.parseInt(params.getProperty("idAutreJoueur"));
                int duree = Integer.parseInt(params.getProperty("duree"));
                int joueurConnecte = joueurSession.getIdjoueur();
                new MatchService().demandeMatch(joueurConnecte, idAutreJoueur, duree);
                StatusHttp statu = new StatusHttp(200, null, null);
                ReturnObject ret = new ReturnObject();
                ret.setStatus(statu)
                render ret as JSON
            }
            else
            {
                redirect(controller: "game", action: "login")
            }
        } catch (Exception exc ) {
            StatusHttp statu = new StatusHttp(500, exc.getMessage(), "/game/login");
            ReturnObject ret = new ReturnObject();
            ret.setStatus(statu)
            render ret as JSON
        }
        StatusHttp statu = new StatusHttp(500, null, "/game/login");
        ReturnObject ret = new ReturnObject();
        ret.setStatus(statu)
        render ret as JSON

    }

    def listeDemandeRencontre()
    {
        try
        {
            ArrayList<Demandematch> listDem = null;
            Joueur joueurSession = (Joueur) session.getAttribute("SESSION_JOUEUR");
            if(joueurSession != null)
            {
                int idJoueurConnecte = joueurSession.getIdjoueur();
                listDem = new MatchService().listeDemandeRencontre(idJoueurConnecte);
                StatusHttp statu = new StatusHttp(200, null, null);
                ReturnObject ret = new ReturnObject();
                ret.setStatus(statu)
                ret.setObjet(listDem);
                render ret as JSON
            }
        }catch (Exception exc ) {
            StatusHttp statu = new StatusHttp(500, exc.getMessage(), "/game/login");
            ReturnObject ret = new ReturnObject();
            ret.setStatus(statu)
            render ret as JSON
        }
        StatusHttp statu = new StatusHttp(500, null, "/game/login");
        ReturnObject ret = new ReturnObject();
        ret.setStatus(statu)
        render ret as JSON
    }
}
