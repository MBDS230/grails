package vsjoueur

import DAO.JoueurDao
import grails.converters.JSON
import mapping.Joueur
import mapping.Message
import utilitaire.ReturnObject
import utilitaire.StatusHttp

class MessageController {

    def login()
    {
        try
        {
            String username = params.getProperty("username");
            String motDePasse = params.getProperty("motDePasse");
            Joueur valiny = new UserService().login(username, motDePasse);
            if(valiny != null)
            {
                valiny.setStatus(true);
                new JoueurDao().update(valiny);
                session.setAttribute("SESSION_JOUEUR", valiny);
            }
            StatusHttp statu = new StatusHttp(200, null, "/game/accueil");
            ReturnObject ret = new ReturnObject();
            ret.setStatus(statu)
            ret.setObjet(valiny);
            render ret as JSON
        } catch (Exception exc ) {
            StatusHttp statu = new StatusHttp(500, exc.getMessage(), "/game/login");
            ReturnObject ret = new ReturnObject();
            ret.setStatus(statu)
            render ret as JSON
        }
        StatusHttp statu = new StatusHttp(500, exc.getMessage(), "/game/login");
        ReturnObject ret = new ReturnObject();
        ret.setStatus(statu)
        render ret as JSON
    }

    def listeMessage()
    {
        try
        {
            ArrayList<Message> val = new ArrayList<>();
            Joueur joueurSession = (Joueur) session.getAttribute("SESSION_JOUEUR");
            if(joueurSession != null)
            {
                int idAutreJoueur = Integer.parseInt(params.getProperty("idAutreJoueur"));
                int joueurConnecte = joueurSession.getIdjoueur();
                val = new MessageService().listeMessage(joueurConnecte, idAutreJoueur);
                StatusHttp statu = new StatusHttp(200, null, null);
                ReturnObject ret = new ReturnObject();
                ret.setStatus(statu)
                ret.setObjet(val)
                render ret as JSON
            }
            else
            {
                redirect(controller: "game", action: "login")
            }
            return val;
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

    def envoyerMessage()
    {
        try
        {
            Joueur joueurSession = (Joueur) session.getAttribute("SESSION_JOUEUR");
            if(joueurSession != null)
            {
                String message = params.getProperty("message");
                int idEnvoyeur = joueurSession.getIdjoueur();
                int idAutreJoueur = Integer.parseInt(params.getProperty("idAutreJoueur"));
                new MessageService().envoyerMessage(message,idEnvoyeur, idAutreJoueur)
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

    def vueMessage()
    {
        try
        {
            Joueur joueurSession = (Joueur) session.getAttribute("SESSION_JOUEUR");

            if(joueurSession != null)
            {
                int idMessage = Integer.parseInt(params.getProperty("idMessage"));
                new MessageService().vueMessage(idMessage);
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
}
