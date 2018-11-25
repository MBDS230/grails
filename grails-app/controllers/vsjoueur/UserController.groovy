package vsjoueur

import DAO.JoueurDao
import mapping.Joueur


class UserController
{
    def inscription()
    {
        String username = params.getProperty("username")
        String motDePasse = params.getProperty("motDePasse")
        new UserSer().inscription(username, motDePasse)
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
            //add Joueur SESSION
        }
    }

    def logout(int idjoueur)
    {
        Joueur joueurSession = null; // GET SESSION joueur
        if(joueurSession != null)
        {
            new UserService().logout(joueurSession.getIdjoueur());
        }
    }

    def listeJoueurConnecte()
    {
        ArrayList<Joueur> val = null;
        Joueur joueurSession = null; // GET SESSION joueur
        if(joueurSession != null)
        {
            new UserService().listeJoueurConnecte(joueurSession.getIdjoueur());
        }
        return val;
    }
}
