package vsjoueur

import DAO.JoueurDao
import grails.converters.JSON
import mapping.Joueur


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
        String username = params.getProperty("username")
        String motDePasse = params.getProperty("motDePasse")
        new UserService().inscription(username, motDePasse)
    }

    def login()
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
        render valiny as JSON
    }

    def logout(int idjoueur)
    {
        Joueur joueurSession = (Joueur) session.getAttribute("SESSION_JOUEUR");
        if(joueurSession != null)
        {
            new UserService().logout(joueurSession.getIdjoueur());
        }
        session.removeAttribute("SESSION_JOUEUR");
        session.invalidate();
    }

    def listeJoueurConnecte()
    {
        ArrayList<Joueur> val = null;
        Joueur joueurSession = (Joueur) session.getAttribute("SESSION_JOUEUR");
        if(joueurSession != null)
        {
            new UserService().listeJoueurConnecte(joueurSession.getIdjoueur());
        }
        return val;
    }
}
