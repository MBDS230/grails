package vsjoueur

import Connecting.Connecting
import DAO.DemandematchDao
import DAO.JoueurDao
import DAO.MatchDao
import grails.gorm.transactions.Transactional
import mapping.Demandematch
import mapping.Joueur
import mapping.Match

import java.sql.Date


@Transactional
class MatchService
{

    def resultatMatch(int idJoueurConnecte, int idAutreJoueur)
    {
        List<Match> val = new ArrayList<>();
        if(idJoueurConnecte >0 && idAutreJoueur>0)
        {
            val = new MatchDao().findMatchByIdDemandeurAndRecepteur(idJoueurConnecte, idAutreJoueur);
        }
        return val;
    }

    def jouer(int idDemandeMatch)
    {
        if(idDemandeMatch >0)
        {
            Demandematch demande = new DemandematchDao().findByID(idDemandeMatch);
            if(demande!=null && demande.getAprouvee()==1)
            {
                List<Match> findMatch = new MatchDao().findMatchByIdDemandematch(idDemandeMatch);
                if(findMatch==null || findMatch.size()==0)
                {
                    int idMatch = Connecting.getMaxId("match");
                    idMatch++;
                    java.sql.Date jourCourant = new java.sql.Date(System.currentTimeMillis());

                    Match mInsert = new Match(idMatch, idDemandeMatch, jourCourant, 1, 0, jourCourant, jourCourant);
                    new MatchDao().insert(mInsert);
                }
                else
                {
                    throw new Exception("Match déja términé");
                }
            }
            else if(demande==null)
            {
                throw new Exception("Vous devez faire une demande de match");
            }
            else if(demande!=null && demande.getAprouvee()==0)
            {
                throw new Exception("Demande de match déja rejété");
            }
            else if(demande!=null && demande.getAprouvee()==2)
            {
                throw new Exception("Demande de match pas encore aprouvé pas l'autre joueur");
            }
        }
    }

    def demandeMatch(int joueurConnecte, int idAutreJoueur, int duree)
    {
        if(joueurConnecte>0 && idAutreJoueur>0 && duree>0)
        {
            JoueurDao jDao = new JoueurDao();
            Joueur demandeur = jDao.findByID(joueurConnecte);
            Joueur autreJoueur = jDao.findByID(idAutreJoueur);
            if(demandeur!= null && autreJoueur!=null)
            {
                java.sql.Date jourCourant = new java.sql.Date(System.currentTimeMillis());
                java.sql.Date demain = new Date(jourCourant.getYear(), jourCourant.getMonth(), jourCourant.getDay());
                DemandematchDao dmDao = new DemandematchDao();
                int iddemande = Connecting.getMaxId("demandematch");
                iddemande++;
                Demandematch dem = new Demandematch(iddemande, joueurConnecte, idAutreJoueur, duree, jourCourant, demain, 0);
                dmDao.insert(dem);
            }
            else
            {
                throw new Exception("Joueur inexistant");
            }
        }
    }

    def listeDemandeAutresJoueurs(int idJoueurConnecte)
    {
        ArrayList <Demandematch> listDem = new ArrayList<>();
        if(idJoueurConnecte>0)
        {
            listDem = new DemandematchDao().findByRecepteurAndAprouve(idJoueurConnecte, 2);
        }
        return listDem;
    }

    def listeDeMesDemandes(int idJoueurConnecte)
    {
        ArrayList <Demandematch> listDem = new ArrayList<>();
        if(idJoueurConnecte>0)
        {
            listDem = new DemandematchDao().findByEnvoyeurAndAprouve(idJoueurConnecte, 2);
        }
        return listDem;
    }

}
