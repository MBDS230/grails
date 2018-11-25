package vsjoueur

import mapping.Joueur
import mapping.Message

class MessageController {

    def listeMessage()
    {
        ArrayList<Message> val = new ArrayList<>();
        Joueur joueurSession = null; // GET SESSION joueur
        if(joueurSession != null)
        {
            int idAutreJoueur = Integer.parseInt(params.getProperty("idAutreJoueur"));
            int joueurConnecte = joueurSession.getIdjoueur();
            val = new MessageService().listeMessage(joueurConnecte, idAutreJoueur);

        }
        return val;
    }

    def envoyerMessage()
    {
        Joueur joueurSession = null; // GET SESSION joueur
        if(joueurSession != null)
        {
            String message = params.getProperty("message");
            int idEnvoyeur = joueurSession.getIdjoueur();
            int idAutreJoueur = Integer.parseInt(params.getProperty("idAutreJoueur"));
            new MessageService().envoyerMessage(message,idEnvoyeur, idAutreJoueur)
        }
    }

    def vueMessage()
    {
        Joueur joueurSession = null; // GET SESSION joueur
        if(joueurSession != null)
        {
            int idMessage = Integer.parseInt(params.getProperty("idMessage"));
            new MessageService().vueMessage(idMessage);
        }
    }
}
