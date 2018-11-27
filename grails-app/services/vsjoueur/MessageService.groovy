package vsjoueur

import Connecting.Connecting
import DAO.JoueurDao
import DAO.MessageDao
import grails.gorm.transactions.Transactional
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

            MessageDao mDao = new MessageDao();
            ArrayList<Message> val = mDao.findByEnvoyeurAndRecepteur(joueurConnecte, idAutreJoueur);

            htmlVal += "<div class='content contentMessage show'>";
            htmlVal +=  "<div class='contact-profile'>";
            htmlVal += "<img src='http://emilcarlsson.se/assets/harveyspecter.png' alt=''>";
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
                    htmlVal += "<img src='http://emilcarlsson.se/assets/mikeross.png' alt=''>";
                    htmlVal += "<p>"+val.get(i).getCorps()+"</p>";
                    htmlVal += "</li>";
                }
                else
                {
                    htmlVal += "<li class='replies'>";
                    htmlVal += "<img src='http://emilcarlsson.se/assets/mikeross.png' alt=''>";
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
            htmlVal += "<button class='submit'><i class='fa fa-paper-plane' aria-hidden='true'></i></button>";
            htmlVal += "</div>";
            htmlVal += "</div>";
            htmlVal += "</div>";
        }
        return htmlVal;
    }



    def envoyerMessage(String message,int idEnvoyeur, int idAutreJoueur)
    {
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
}
