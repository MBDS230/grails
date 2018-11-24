package vsjoueur

import Connecting.Connecting
import DAO.DemandematchDao
import DAO.JoueurDao
import grails.gorm.transactions.Transactional
import mapping.Demandematch
import mapping.Joueur

import java.sql.Date


@Transactional
class MatchService {

    def demandeMatch(int joueurConnecte, int idAutreJoueur, int duree)
    {
        if(joueurConnecte>0 && idAutreJoueur>0 && duree>0)
        {
            JoueurDao jDao = new JoueurDao();
            Joueur demandeur = jDao.joueurByID(joueurConnecte);
            Joueur autreJoueur = jDao.joueurByID(idAutreJoueur);
            if(demandeur!= null && autreJoueur!=null)
            {
                java.sql.Date jourCourant = new java.sql.Date(System.currentTimeMillis());
                java.sql.Date demain = new Date(jourCourant.getYear(), jourCourant.getMonth(), jourCourant.getDay());
                DemandematchDao dmDao = new DemandematchDao();
                int iddemande = Connecting.getMaxId("demandematch");
                iddemande++;
                Demandematch dem = new Demandematch(iddemande, joueurConnecte, idAutreJoueur, duree, jourCourant, demain, 0);
                dmDao.demandematchInsert(dem);
            }
            else
            {
                throw new Exception("Joueur inexistant");
            }
        }
    }

    def listeDemandeRencontre(int idJoueurConnecte)
    {
        ArrayList <Demandematch> listDem = new ArrayList<>();
        if(joueurConnecte>0)
        {
            listDem = new DemandematchDao().demandeMatchFindByRecepteurAndAprouve(idJoueurConnecte, false);
        }
        return listDem;
    }

}
