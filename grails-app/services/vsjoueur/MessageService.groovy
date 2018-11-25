package vsjoueur

import Connecting.Connecting
import DAO.MessageDao
import grails.gorm.transactions.Transactional
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
