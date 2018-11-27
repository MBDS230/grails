package vsjoueur

import Connecting.Connecting
import DAO.JoueurDao
import grails.gorm.transactions.Transactional
import mapping.Joueur

import java.security.MessageDigest

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

    def inscription(String username, String motDePasse) throws Exception
    {
        Joueur joueur = new Joueur(0, username, motDePasse, false, 1);
        ArrayList<Joueur> arrJoueur = new JoueurDao().findByUsername(username);
        if(arrJoueur == null || arrJoueur.size() == 0)
        {
            int idMaxJoueur = Connecting.getMaxId("joueur");
            idMaxJoueur++;
            JoueurDao jDao = new JoueurDao();
            joueur.setIdjoueur(idMaxJoueur);
            joueur.setMotdepasse(getPasswordHash(motDePasse));
            jDao.insert(joueur);
        }
        else
        {
            throw new Exception("Pseudo éxistant");
        }
        return joueur;
    }

    def login(String username, String motDePasse) throws Exception
    {
        String motDePasseHash = getPasswordHash(motDePasse);
        JoueurDao jDao = new JoueurDao();
        Joueur verif = new Joueur();
        verif.setLogin(username);
        verif.setMotdepasse(motDePasse);
        Joueur valiny = jDao.findByLoginAndPassword(username, motDePasseHash);
        if(valiny!=null && valiny.getAprouve()==0)
        {
            throw new Exception("Joueur Bloqué");
        }
        else if(valiny!=null && valiny.getAprouve()==2)
        {
            throw new Exception("Joueur en attente d'approbation");
        }
        return valiny;
    }

    def logout(int idjoueur)
    {
        JoueurDao jDao = new JoueurDao();
        Joueur joueur = jDao.findByID(idjoueur);
        if(joueur != null)
        {
            joueur.setStatus(false);
            jDao.update(joueur);
        }
    }

    def listeJoueurConnecte(int joueurConnecte)
    {
        ArrayList<Joueur> val = new JoueurDao().findByStatus(joueurConnecte, true);
        return val;
    }

    def listeJoueurConnecteToHtml(int joueurConnecte)
    {
        ArrayList<Joueur> val = new JoueurDao().findByStatus(joueurConnecte, true);
        int i = 0;
        String htmlVal = "";
        for(i=0; i<val.size(); i++)
        {
            htmlVal += "<li class='contact'>";
            htmlVal += "<div class='wrap'>";
            htmlVal += "<span class='contact-status online'></span>";
            htmlVal += "<img src='http://emilcarlsson.se/assets/louislitt.png' alt='' />";
            htmlVal += "<div class='meta'>";
            htmlVal += "<p class='name'>"+val.get(i).getLogin()+"</p>";
            htmlVal += "<button class='btn btn-success boutonJouer' data-id='"+val.get(i).getIdjoueur()+"'>Jouer</button>";
            htmlVal += "<button class='btn btn-primary boutonMessage' data-id='"+val.get(i).getIdjoueur()+"'>Message</button>";
            htmlVal += "</div>";
            htmlVal += "</div>";
            htmlVal += "</li>";
        }

        return htmlVal;
    }










}
