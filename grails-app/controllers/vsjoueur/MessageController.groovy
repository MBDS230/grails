package vsjoueur

import grails.converters.JSON
import mapping.Joueur
import utilitaire.StatusHttp

class MessageController
{
    def listeMessage()
    {
        try
        {
            String htmlVal = "";
            Joueur joueurSession = (Joueur) session.getAttribute("SESSION_JOUEUR");
            if(joueurSession != null)
            {
                int idAutreJoueur = Integer.parseInt(params.getProperty("idAutreJoueur"));
                int joueurConnecte = joueurSession.getIdjoueur();
                htmlVal = new MessageService().listeMessageToHtml(joueurConnecte, idAutreJoueur);
                StatusHttp statu = new StatusHttp(200, null, null);
                def responseData = [
                        'results': htmlVal,
                        'status': statu
                ]
                render responseData as JSON
                return;
            }
            else
            {
                redirect(controller: "game", action: "login")
            }
        } catch (Exception exc ) {
            StatusHttp statu = new StatusHttp(500, exc.getMessage(), null);
            def responseData = [
                    'results': null,
                    'status': statu
            ]
            render responseData as JSON
            return;
        }
        StatusHttp statu = new StatusHttp(500, null, null);
        def responseData = [
                'results': null,
                'status': statu
        ]
        render responseData as JSON
        return;
    }

    def envoyerMessage()
    {
        try
        {
            Joueur joueurSession = (Joueur) session.getAttribute("SESSION_JOUEUR");
            if(joueurSession != null)
            {
                String message = params.getProperty("message");
                int idEnvoyeur = joueurSession.getIdjoueur();
                int idAutreJoueur = Integer.parseInt(params.getProperty("idAutreJoueur"));
                new MessageService().envoyerMessage(message,idEnvoyeur, idAutreJoueur)
                StatusHttp statu = new StatusHttp(200, null, null);
                def responseData = [
                        'results': null,
                        'status': statu
                ]
                render responseData as JSON
                return;
            }
            else
            {
                redirect(controller: "game", action: "login")
            }

        } catch (Exception exc ) {
            StatusHttp statu = new StatusHttp(500, exc.getMessage(), null);
            def responseData = [
                    'results': null,
                    'status': statu
            ]
            render responseData as JSON
            return;
        }
        StatusHttp statu = new StatusHttp(500, null, null);
        def responseData = [
                'results': null,
                'status': statu
        ]
        render responseData as JSON
        return;
    }

    def vueMessage()
    {
        try
        {
            Joueur joueurSession = (Joueur) session.getAttribute("SESSION_JOUEUR");

            if(joueurSession != null)
            {
                int idMessage = Integer.parseInt(params.getProperty("idMessage"));
                new MessageService().vueMessage(idMessage);
                StatusHttp statu = new StatusHttp(200, null, null);
                def responseData = [
                        'results': null,
                        'status': statu
                ]
                render responseData as JSON
                return;
            }

        } catch (Exception exc ) {
            StatusHttp statu = new StatusHttp(500, exc.getMessage(), null);
            def responseData = [
                    'results': null,
                    'status': statu
            ]
            render responseData as JSON
            return;
        }
        StatusHttp statu = new StatusHttp(500, null, null);
        def responseData = [
                'results': null,
                'status': statu
        ]
        render responseData as JSON
        return;
    }


    def activeCron()
    {
        try
        {
            Joueur joueurSession = (Joueur) session.getAttribute("SESSION_JOUEUR");

            if(joueurSession != null)
            {
                int idRecepteur = Integer.parseInt(params.getProperty("idAutreJoueur"));
                new MessageService().activeCron(joueurSession.getIdjoueur(), idRecepteur);
                StatusHttp statu = new StatusHttp(200, null, null);
                def responseData = [
                        'results': null,
                        'status': statu
                ]
                render responseData as JSON
                return;
            }

        } catch (Exception exc ) {
            StatusHttp statu = new StatusHttp(500, exc.getMessage(), null);
            def responseData = [
                    'results': null,
                    'status': statu
            ]
            render responseData as JSON
            return;
        }
        StatusHttp statu = new StatusHttp(500, null, null);
        def responseData = [
                'results': null,
                'status': statu
        ]
        render responseData as JSON
        return;
    }

    def desactiveCron()
    {
        try
        {
            Joueur joueurSession = (Joueur) session.getAttribute("SESSION_JOUEUR");

            if(joueurSession != null)
            {
                int idRecepteur = Integer.parseInt(params.getProperty("idAutreJoueur"));
                new MessageService().desactiveCron(joueurSession.getIdjoueur(), idRecepteur);
                StatusHttp statu = new StatusHttp(200, null, null);
                def responseData = [
                        'results': null,
                        'status': statu
                ]
                render responseData as JSON
                return;
            }

        } catch (Exception exc ) {
            StatusHttp statu = new StatusHttp(500, exc.getMessage(), null);
            def responseData = [
                    'results': null,
                    'status': statu
            ]
            render responseData as JSON
            return;
        }
        StatusHttp statu = new StatusHttp(500, null, null);
        def responseData = [
                'results': null,
                'status': statu
        ]
        render responseData as JSON
        return;
    }
}
