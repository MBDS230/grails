package vsjoueur

import DAO.AdminDao
import DAO.JoueurDao
import grails.gorm.transactions.Transactional
import mapping.Admin
import mapping.Joueur

@Transactional
class AdminService {

    def approuve(int idJoueur)
    {
        if(idJoueur>0)
        {
            JoueurDao joueurDao = new JoueurDao();
            Joueur joueur = joueurDao.joueurByID(idJoueur);
            if(joueur!=null)
            {
                joueur.setAprouve(1);
                joueurDao.joueurUpdate(joueur);
            }
        }
    }

    def rejete(int idJoueur)
    {
        if(idJoueur>0)
        {
            JoueurDao joueurDao = new JoueurDao();
            Joueur joueur = joueurDao.joueurByID(idJoueur);
            if(joueur!=null)
            {
                joueur.setAprouve(0);
                joueurDao.joueurUpdate(joueur);
            }
        }
    }
}
