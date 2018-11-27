package vsjoueur

import DAO.JoueurDao
import grails.converters.JSON
import mapping.Joueur
import utilitaire.StatusHttp


class UserController
{
    def testLogoutJoueur()
    {
        session.removeAttribute("SESSION_JOUEUR");
        session.invalidate();
        Joueur j = new Joueur(1, "", "ergergergere", false, 1);
        render j as JSON
    }

    def testGetSessionJoueur()
    {
        Joueur val = (Joueur) session.getAttribute("SESSION_JOUEUR");
        if(val == null)
        {
            val = new Joueur(1, "TSIS ANATY SESSION", "ergergergerer", false, 1);
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
            StatusHttp statu = new StatusHttp(200, null, "/game/index?inscription=success");
            joueur = new UserService().login(username, motDePasse);
            if(joueur != null)
            {
                joueur.setStatus(true);
                new JoueurDao().update(joueur);
                session.setAttribute("SESSION_JOUEUR", joueur);
            }
            def responseData = [
                    'results': joueur,
                    'status': statu
            ]
            render responseData as JSON
            return;
        } catch (Exception exc) {
            StatusHttp statu = new StatusHttp(500, exc.getMessage(), "/game/login");
            def responseData = [
                    'results': joueur,
                    'status': statu
            ]
            render responseData as JSON
            return;
        }
        StatusHttp statu = new StatusHttp(500, null, "/game/login");
        def responseData = [
                'results': joueur,
                'status': statu
        ]
        render responseData as JSON
        return;
    }

    def login()
    {
        Joueur valiny = new Joueur();
        try
        {
            String username = params.getProperty("username");
            String motDePasse = params.getProperty("motDePasse");
            valiny = new UserService().login(username, motDePasse);
            if(valiny != null)
            {
                valiny.setStatus(true);
                new JoueurDao().update(valiny);
                session.setAttribute("SESSION_JOUEUR", valiny);
                StatusHttp statu = new StatusHttp(200, null, "/game/index");
                def responseData = [
                        'results': valiny,
                        'status': statu
                ]
                render responseData as JSON
                return;
            }
            StatusHttp statu = new StatusHttp(500, "L'utilisateur n'existe pas", "/game/login");
            def responseData = [
                    'results': valiny,
                    'status': statu
            ]
            render responseData as JSON
            return;
        } catch (Exception exc ) {
            StatusHttp statu = new StatusHttp(500, exc.getMessage(), "/game/login");
            def responseData = [
                    'results': valiny,
                    'status': statu
            ]
            render responseData as JSON
            return;
        }
        StatusHttp statu = new StatusHttp(500, null, "/game/login");
        def responseData = [
                'results': valiny,
                'status': statu
        ]
        render responseData as JSON
        return;
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
            String htmlVal = null;
            Joueur joueurSession = (Joueur) session.getAttribute("SESSION_JOUEUR");
            if(joueurSession != null)
            {
                htmlVal = new UserService().listeJoueurConnecteToHtml(joueurSession.getIdjoueur());
                StatusHttp statu = new StatusHttp(200, null, null);
                def responseData = [
                        'results': htmlVal,
                        'status': statu
                ]
                render responseData as JSON
                return;
            }
            else
            {
                redirect(controller: "game", action: "login")
            }
        } catch (Exception exc) {
            StatusHttp statu = new StatusHttp(500, exc.getMessage(), "/game/login");
            def responseData = [
                    'results': null,
                    'status': statu
            ]
            render responseData as JSON
            return;
        }
        StatusHttp statu = new StatusHttp(500, null, "/game/login");
        def responseData = [
                'results': null,
                'status': statu
        ]
        render responseData as JSON
        return;
    }



}
