package vsjoueur

import DAO.JoueurDao
import grails.converters.JSON
import mapping.Joueur
import utilitaire.ReturnObject
import utilitaire.StatusHttp


class UserController
{
    def testLogoutJoueur()
    {
        session.removeAttribute("SESSION_JOUEUR");
        session.invalidate();
        Joueur j = new Joueur(1, "", "", false, 1, 1);
        render j as JSON
    }

    def testGetSessionJoueur()
    {
        Joueur val = (Joueur) session.getAttribute("SESSION_JOUEUR");
        if(val == null)
        {
            val = new Joueur(1, "TSIS ANATY SESSION", "", false, 1, 1);
        }
        render val as JSON;
    }

    def setSessionJoueur(Joueur joueur)
    {
        session.setAttribute("SESSION_JOUEUR", joueur);
    }

    def inscription()
    {
        mapping.Joueur joueur = new Joueur();
        try
        {
            String username = params.getProperty("username")
            String motDePasse = params.getProperty("motDePasse")
            joueur = new UserService().inscription(username, motDePasse)
            StatusHttp statu = new StatusHttp(500, null, "/game/login");
            /*ReturnObject ret = new ReturnObject();
            ret.setStatus(statu);
            ret.setObjet(joueur);*/
            def responseData = [
                    'results': joueur,
                    'status': statu
            ]
            render responseData as JSON
        } catch (Exception exc) {
            StatusHttp statu = new StatusHttp(500, exc.getMessage(), "/game/login");
            /*ReturnObject ret = new ReturnObject();
            ret.setStatus(statu)
            render ret as JSON*/
            def responseData = [
                    'results': joueur,
                    'status': statu
            ]
            render responseData as JSON
        }
        StatusHttp statu = new StatusHttp(500, null, "/game/login");
        /*ReturnObject ret = new ReturnObject();
        ret.setStatus(statu)
        render ret as JSON*/
        def responseData = [
                'results': joueur,
                'status': statu
        ]
        render responseData as JSON
    }

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
        StatusHttp statu = new StatusHttp(500, null, "/game/login");
        ReturnObject ret = new ReturnObject();
        ret.setStatus(statu)
        render ret as JSON
    }

    def logout()
    {
        Joueur joueurSession = (Joueur) session.getAttribute("SESSION_JOUEUR");
        if(joueurSession != null)
        {
            new UserService().logout(joueurSession.getIdjoueur());
        }
        session.removeAttribute("SESSION_JOUEUR");
        session.invalidate();
        redirect(controller: "game", action: "login")
    }

    def listeJoueurConnecte()
    {
        try
        {
            ArrayList<Joueur> val = null;
            Joueur joueurSession = (Joueur) session.getAttribute("SESSION_JOUEUR");
            if(joueurSession != null)
            {
                val = new UserService().listeJoueurConnecte(joueurSession.getIdjoueur());
                StatusHttp statu = new StatusHttp(200, null, null);
                ReturnObject ret = new ReturnObject();
                ret.setStatus(statu)
                ret.setObjet(val)

                def responseData = [
                        'results': val,
                        'status': statu
                ]
                render responseData as JSON
            }
            else
            {
                redirect(controller: "game", action: "login")
            }
        } catch (Exception exc) {
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
