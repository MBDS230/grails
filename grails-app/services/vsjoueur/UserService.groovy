package vsjoueur

import Connecting.Connecting
import DAO.JoueurDao
import grails.gorm.transactions.Transactional
import mapping.Joueur

import java.nio.charset.StandardCharsets
import java.security.MessageDigest
import java.security.SecureRandom

@Transactional
class UserService {

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

    def inscription(String username, String motDePasse)
    {
        Joueur joueur = new Joueur(0, username, motDePasse, 0, 2);
        int idMaxJoueur = Connecting.getMaxId("joueur");
        idMaxJoueur++;
        JoueurDao jDao = new JoueurDao();
        joueur.setMotdepasse(getPasswordHash(motDePasse));
        jDao.joueurInsert(joueur);
    }

    def login(String username, String motDePasse)
    {
        String motDePasseHash = getPasswordHash(motDePasse);
        JoueurDao jDao = new JoueurDao();
        Joueur valiny = jDao.joueurFindByLoginAndPassword(username, motDePasseHash);
        return valiny;
    }

    def logout(int idjoueur)
    {
        JoueurDao jDao = new JoueurDao();
        Joueur joueur = jDao.joueurByID(idjoueur);
        if(joueur != null)
        {
            joueur.setStatus(0);
            jDao.joueurUpdate(joueur);
        }
    }

    def listeJoueurConnecte(int joueurConnecte)
    {
        ArrayList<Joueur> val = new JoueurDao().joueurFindByStatus(joueurConnecte, true);
        return val;
    }
}
