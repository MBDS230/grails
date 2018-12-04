package vsjoueur

import Connecting.Connecting
import DAO.CronDao
import DAO.JoueurDao
import DAO.MessageDao
import grails.gorm.transactions.Transactional
import mapping.Cron
import mapping.Joueur
import mapping.Message

@Transactional
class MessageService {

    def listeMessage(int joueurConnecte, int idAutreJoueur)
    {
        ArrayList<Message> val = new ArrayList<>();
        if(joueurConnecte>0 && idAutreJoueur>0)
        {
            MessageDao mDao = new MessageDao();
            val = mDao.findByEnvoyeurAndRecepteur(joueurConnecte, idAutreJoueur);
        }
        return val;
    }

    def listeMessageToHtml(int joueurConnecte, int idAutreJoueur)
    {
        String htmlVal = "";
        if(joueurConnecte>0 && idAutreJoueur>0)
        {
            Joueur autreJ = new JoueurDao().findByID(idAutreJoueur);
            Joueur jSession = new JoueurDao().findByID(joueurConnecte);

            MessageDao mDao = new MessageDao();
            ArrayList<Message> val = mDao.findByEnvoyeurAndRecepteur(joueurConnecte, idAutreJoueur);

            htmlVal += "<div class='content contentMessage show' data-id-envoyeur='"+joueurConnecte+"' data-id-recepteur='"+idAutreJoueur+"'>";
            htmlVal +=  "<div class='contact-profile'>";
            htmlVal += "<img src='"+autreJ.getPhoto()+"' alt=''>";
            htmlVal += "<p>"+autreJ.getLogin()+"</p>";
            htmlVal += "<div class='social-media'>";
            htmlVal += "<i class='fa fa-facebook' aria-hidden='true'></i>";
            htmlVal += "<i class='fa fa-twitter' aria-hidden='true'></i>";
            htmlVal += "<i class='fa fa-instagram' aria-hidden='true'></i>";
            htmlVal += "</div>";
            htmlVal += "</div>";
            htmlVal += "<div class='messages'>";
            htmlVal +=  "<ul>";

            int i = 0;
            for(i=0; i<val.size(); i++)
            {
                if(val.get(i).getIdenvoyeur()==joueurConnecte)
                {
                    htmlVal += "<li class='sent'>";
                    htmlVal += "<img src='"+jSession.getPhoto()+"' alt=''>";
                    htmlVal += "<p>"+val.get(i).getCorps()+"</p>";
                    htmlVal += "</li>";
                }
                else
                {
                    htmlVal += "<li class='replies'>";
                    htmlVal += "<img src='"+autreJ.getPhoto()+"' alt=''>";
                    htmlVal += "<p>"+val.get(i).getCorps()+"</p>";
                    htmlVal += "</li>";
                }

            }
            htmlVal += "</ul>";
            htmlVal += "</div>";
            htmlVal += "<div class='message-input'>";
            htmlVal += "<div class='wrap'>";
            htmlVal += "<input type='text' placeholder='Write your message...'>";
            htmlVal += "<i class='fa fa-paperclip attachment' aria-hidden='true'></i>";
            htmlVal += "<button class='submit'><i class='fa fa-paper-plane-o' aria-hidden='true'></i></button>";
            htmlVal += "</div>";
            htmlVal += "</div>";
            htmlVal += "</div>";
        }
        return htmlVal;
    }



    def envoyerMessage(String message,int idEnvoyeur, int idAutreJoueur)
    {
        String htmlVal = "";
        if(message!=null && idEnvoyeur>0 && idAutreJoueur>0)
        {
            String trimMessage = message.trim();
            if(trimMessage.length()>0)
            {
                MessageDao messageDao = new MessageDao();
                int idMessage = Connecting.getMaxId("message");
                idMessage++;
                java.sql.Date jourCourant = new java.sql.Date(System.currentTimeMillis());
                Message messageObj = new Message(idMessage, idEnvoyeur, idAutreJoueur, message, 2, true,jourCourant, false);
                messageDao.insert(messageObj);
                JoueurDao joueurDao = new JoueurDao();
                Joueur joueur = joueurDao.findByID(idEnvoyeur);
                htmlVal = "<li class='sent'><img src='"+ joueur.photo +"' alt='' /><p> "+ message +" </p></li>";
                return htmlVal;
            }
        }
    }

    def vueMessage(int idMessage)
    {
        if(idMessage>0)
        {
            Message messageObj = new MessageDao().findByID(idMessage);
            if(messageObj!=null)
            {
                messageObj.setStatus(true);
                MessageDao messageDao = new MessageDao();
                messageDao.update(messageObj);
            }
        }
    }

    def activeCron(int idEnvoyeur, int idRecepteur)
    {
        List<Cron> lcron = new CronDao().findByRecepteurAndEnvoyeur(idEnvoyeur, idRecepteur);
        if(lcron!=null && lcron.size()>0)
        {
            Cron cron = lcron.get(0);
            cron.setActive(true);
            new CronDao().update(cron);
        }
        else
        {
            int idCron = Connecting.getMaxId("cron");
            idCron++;
            Cron cron = new Cron(idCron, idEnvoyeur, idRecepteur, true);
            new CronDao().insert(cron);
        }
    }

    def desactiveCron(int idEnvoyeur, int idRecepteur)
    {
        List<Cron> lcron = new CronDao().findByRecepteurAndEnvoyeur(idEnvoyeur, idRecepteur);
        if(lcron!=null && lcron.size()>0)
        {
            Cron cron = lcron.get(0);
            cron.setActive(false);
            new CronDao().update(cron);
        }
    }

    def cronMessage()
    {
        List<Cron> activeCron = new CronDao().findByActive();
        int i = 0;
        for(i=0; i< activeCron.size(); i++)
        {
            new MessageDao().cacheMessageByIdEnvoyeurAndRecepteur(activeCron.get(i).getIdenvoyeur(), activeCron.get(i).getIdrecepteur());
        }
    }
}
