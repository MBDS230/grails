package vsjoueur

import DAO.AdminDao
import DAO.JoueurDao
import grails.gorm.transactions.Transactional
import mapping.Admin
import mapping.Joueur

import java.security.MessageDigest

@Transactional
class AdminService {


    def getPasswordHash(String data) throws  Exception
    {
        String signature = "";
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(data.getBytes("UTF-8"));
        byte[] bytes = md.digest(data.getBytes("UTF-8"));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++)
        {
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        signature = sb.toString();
        return signature;
    }

    def login(String username, String motDePasse) throws Exception
    {
        String motDePasseHash = getPasswordHash(motDePasse);
        AdminDao jDao = new AdminDao();
        Admin verif = new Admin();
        verif.setLogin(username);
        verif.setMotdepasse(motDePasse);
        Admin valiny = jDao.findByLoginAndPassword(username, motDePasseHash);
        if(valiny!=null)
        {
            throw new Exception("Admin Bloqué");
        }
        return valiny;
    }

    def logout(int idAdmin)
    {

    }

    def approuve(int idJoueur)
    {
        if(idJoueur>0)
        {
            JoueurDao joueurDao = new JoueurDao();
            Joueur joueur = joueurDao.findByID(idJoueur);
            if(joueur!=null)
            {
                joueur.setAprouve(1);
                joueurDao.update(joueur);
            }
        }
    }

    def rejete(int idJoueur)
    {
        if(idJoueur>0)
        {
            JoueurDao joueurDao = new JoueurDao();
            Joueur joueur = joueurDao.findByID(idJoueur);
            if(joueur!=null)
            {
                joueur.setAprouve(0);
                joueurDao.update(joueur);
            }
        }
    }
}
